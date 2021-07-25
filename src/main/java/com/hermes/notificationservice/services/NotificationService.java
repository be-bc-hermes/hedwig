package com.hermes.notificationservice.services;

import com.hermes.notificationservice.entities.Notification;
import com.hermes.notificationservice.messaging.NotificationPublisher;
import com.hermes.notificationservice.models.NotificationType;
import com.hermes.notificationservice.models.ProductPriceChangeMessage;
import com.hermes.notificationservice.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
public class NotificationService {

  private final NotificationRepository repository;

  private final NotificationPublisher notificationPublisher;

  public NotificationService(NotificationRepository repository,
                             NotificationPublisher notificationPublisher) {
    this.repository = repository;
    this.notificationPublisher = notificationPublisher;
  }

  public void createProductPriceChangeNotification(ProductPriceChangeMessage productPriceChangeMessage) {
    Notification notification = productPriceChangeToNotification(productPriceChangeMessage);
    Notification notificationRecord = repository.save(notification);
    notificationPublisher.publishNewNotificationMessage(notificationRecord);
  }

  private Notification productPriceChangeToNotification(ProductPriceChangeMessage productPriceChangeMessage) {
    Notification notification = new Notification();
    notification.setNewPriceInCents(productPriceChangeMessage.getNewPrice());
    notification.setOldPriceInCents(productPriceChangeMessage.getOldPrice());
    notification.setProductId(productPriceChangeMessage.getProductId());
    switch (productPriceChangeMessage.getPriceChannel()) {
      case MOBILE -> {
        notification.setNotificationType(NotificationType.PRODUCT_MOBILE_PRICE_CHANGE);
      }
      case DESKTOP -> {
        notification.setNotificationType(NotificationType.PRODUCT_DESKTOP_PRICE_CHANGE);
      }
      default -> throw new IllegalStateException("Unexpected value: " + productPriceChangeMessage.getPriceChannel());
    }
    return notification;
  }
}
