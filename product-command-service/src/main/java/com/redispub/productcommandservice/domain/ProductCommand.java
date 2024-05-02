package com.redispub.productcommandservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductCommand {
    private String name;
    private String description;
    private double price;
}
