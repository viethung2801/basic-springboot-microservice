package org.example.orderservice.repository;

import org.example.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HungDV
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
