package org.example.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author HungDV
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
