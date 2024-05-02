package com.redispub.productcommandservice.controller;

import com.redispub.productcommandservice.domain.Product;
import com.redispub.productcommandservice.domain.ProductCommand;
import com.redispub.productcommandservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final ProductService productCommandService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,path = "/save")
    public Product saveProduct(@RequestBody ProductCommand productCommand) {
       return productCommandService.saveProduct(productCommand);
    }
}
