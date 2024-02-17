package org.example.orderservice.dto;

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
public class OrderLineItemDto {
    private Long id;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;
}
