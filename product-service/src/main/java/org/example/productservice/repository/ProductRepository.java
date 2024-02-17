package org.example.productservice.repository;

import org.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HungDV
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
