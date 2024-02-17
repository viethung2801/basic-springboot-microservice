package org.example.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.productservice.dto.ProductRequest;
import org.example.productservice.dto.ProductResponse;
import org.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HungDV
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest product) {
       return productService.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }
}
