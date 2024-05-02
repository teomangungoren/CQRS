package com.redispub.productcommandservice.service;

import com.redispub.productcommandservice.domain.Product;
import com.redispub.productcommandservice.domain.ProductCommand;
import com.redispub.productcommandservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);


    public Product saveProduct(ProductCommand productCommand) {
       Product product = mapToProduct(productCommand);
       product = productRepository.save(product);
       publishEvent(product);
       return product;
    }

    @Retryable(maxAttempts = 3,backoff = @org.springframework.retry.annotation.Backoff(delay = 1000))
    private void publishEvent(Product product){
        LOGGER.info("Publishing event: {} to channel: {}", product, topic.getTopic());
        Long id = redisTemplate.convertAndSend(topic.getTopic(),product);
        if (id != null) {
            LOGGER.info("event published to channel: {}", topic.getTopic());
        }
    }

    private Product mapToProduct(ProductCommand productCommand){
        Product product = new Product();
        product.setName(productCommand.getName());
        product.setDescription(productCommand.getDescription());
        product.setPrice(productCommand.getPrice());
        return product;
    }
}
