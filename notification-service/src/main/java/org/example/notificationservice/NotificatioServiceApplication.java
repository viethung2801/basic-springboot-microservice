package org.example.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.example.notificationservice.event.OrderPlacedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author HungDV
 */
@SpringBootApplication
@Slf4j
public class NotificatioServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificatioServiceApplication.class,args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        // send out an email notification
        log.info("Received notification for order {}",orderPlacedEvent.getOrderNumber());
    }
}
