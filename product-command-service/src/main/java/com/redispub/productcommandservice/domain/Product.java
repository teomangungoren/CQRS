package com.redispub.productcommandservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
@Getter
@Setter
public class Product {
    @Id
    private String  id;
    private String name;
    private String description;
    private double price;
}
