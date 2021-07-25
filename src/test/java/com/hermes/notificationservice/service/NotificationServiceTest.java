package com.hermes.notificationservice.service;


import com.hermes.notificationservice.entities.Notification;
import com.hermes.notificationservice.models.NotificationType;
import com.hermes.notificationservice.repositories.NotificationRepository;
import com.hermes.notificationservice.services.NotificationService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NotificationRepository notificationRepository;



    @Test
    @Order(1)
    public void createNotification() {
        // test with dummy data
        Notification notification = new Notification();
        notification.setProductId(1200L);
        notification.setNewPriceInCents(70);
        notification.setOldPriceInCents(100);
        notification.setNotificationType(NotificationType.PRODUCT_DESKTOP_PRICE_CHANGE);
        notificationRepository.save(notification);
        assertEquals(notification.getProductId(), 1200L);
    }
}
