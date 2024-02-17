package org.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author HungDV
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderRequest {
    private List<OrderLineItemDto> orderLineItemDtos;
}
