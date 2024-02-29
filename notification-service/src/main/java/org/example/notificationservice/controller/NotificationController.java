package org.example.notificationservice.controller;

import org.example.notificationservice.dto.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HungDV
 */
@RestController
@RequestMapping("/api")
public class NotificationController {
    @PostMapping("/notification")
    public ResponseEntity<String> getNotification(@RequestBody Notification notification){
        System.out.println(notification.toString());
        return ResponseEntity.ok("Hello World");
    }
}
