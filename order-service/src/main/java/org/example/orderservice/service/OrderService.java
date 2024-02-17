package org.example.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orderservice.dto.InventoryResponse;
import org.example.orderservice.dto.OrderLineItemDto;
import org.example.orderservice.dto.OrderRequest;
import org.example.orderservice.event.OrderPlacedEvent;
import org.example.orderservice.model.Order;
import org.example.orderservice.model.OrderLineItem;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author HungDV
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemDtos().stream().map(orderLineItemDto -> mapToOrderLineItem(orderLineItemDto)).toList();
        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).toList();

        //Call inventory-service check product is stock
        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("sku-code", skuCodes)
                                .build()
                )
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean result = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        if (result) {
            orderRepository.save(order);
            log.info("Order saved: {}", order.getOrderNumber());
            kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
        } else {
            throw new IllegalArgumentException("product is not in stock, please try again");
        }


    }

    private OrderLineItem mapToOrderLineItem(OrderLineItemDto orderLineItemDto) {
        return OrderLineItem.builder()
                .price(orderLineItemDto.getPrice())
                .quantity(orderLineItemDto.getQuantity())
                .skuCode(orderLineItemDto.getSkuCode())
                .build();
    }
}
