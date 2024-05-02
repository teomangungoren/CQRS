package com.redispub.productcommandservice.repository;

import com.redispub.productcommandservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
