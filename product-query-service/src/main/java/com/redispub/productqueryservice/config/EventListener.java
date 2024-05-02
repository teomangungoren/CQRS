package com.redispub.productqueryservice.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redispub.productqueryservice.domain.Product;
import com.redispub.productqueryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EventListener {

    private final ObjectMapper objectMapper=new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(EventListener.class);

    private final ProductRepository productRepository;

    public void listen(String message) throws JsonProcessingException {
        try {
            LOGGER.info("New event received: {}", message);
            Product productEvent = objectMapper.readValue(message, Product.class);
            System.out.println(productEvent);
            LOGGER.info("parsed event : {}", productEvent);
            this.productRepository.save(productEvent);
            System.out.println("Product saved");
        } catch (IOException e) {
            LOGGER.error("error while parsing message");
        }
    }
}
