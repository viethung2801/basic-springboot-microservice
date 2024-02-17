package org.example.inventoryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HungDV
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String skuCode;

    private int quantity;
}
