package org.example.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HungDV
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notification {
    private String message;
    private String type;
}
