package org.example.orderservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HungDV
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {

    private String orderNumber;

}
