package org.example.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.productservice.dto.ProductRequest;
import org.example.productservice.dto.ProductResponse;
import org.example.productservice.model.Product;
import org.example.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HungDV
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Saved product : {}",product.getId());
        return mapToProductResponse(product);
    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll().stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(),product.getDescription(),product.getPrice());
    }
}
