package com.redispub.productqueryservice.repository;

import com.redispub.productqueryservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
