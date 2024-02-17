package org.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
