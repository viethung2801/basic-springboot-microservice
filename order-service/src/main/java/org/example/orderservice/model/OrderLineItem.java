package org.example.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author HungDV
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
