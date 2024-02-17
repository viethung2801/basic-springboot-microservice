package org.example.orderservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author HungDV
 */
@Entity
@Table(name = "t_order")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderNumber;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;
}
