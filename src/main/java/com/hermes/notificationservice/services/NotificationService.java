package com.hermes.notificationservice.services;

import com.hermes.notificationservice.entities.Notification;
import com.hermes.notificationservice.exception.NotificationNotFoundById;
import com.hermes.notificationservice.messaging.NotificationPublisher;
import com.hermes.notificationservice.models.NotificationTarget;
import com.hermes.notificationservice.models.NotificationType;
import com.hermes.notificationservice.models.NotifyTargetMessage;
import com.hermes.notificationservice.models.ProductPriceChangeMessage;
import com.hermes.notificationservice.repositories.NotificationRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
public class NotificationService {

  private final NotificationRepository repository;

  private final NotificationPublisher notificationPublisher;

  private final EmailNotifierService emailNotifierService;

  public NotificationService(NotificationRepository repository,
                             NotificationPublisher notificationPublisher,
                             EmailNotifierService emailNotifierService) {
    this.repository = repository;
    this.notificationPublisher = notificationPublisher;
    this.emailNotifierService = emailNotifierService;
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
      default -> throw new IllegalStateException(
          "Unexpected price channel value: " + productPriceChangeMessage.getPriceChannel());
    }
    return notification;
  }

  public void notifyTarget(NotifyTargetMessage message) {
    Long id = message.getNotificationId();
    Optional<Notification> notificationRecord = repository.findById(id);
    if (notificationRecord.isPresent()) {
      Notification notification = notificationRecord.get();
      sendNotificationToTarget(notification, message.getTargetType(), message.getTargetAddress());
    } else {
      throw new NotificationNotFoundById(id);
    }
  }

  private void sendNotificationToTarget(Notification notification, NotificationTarget targetType,
                                        String targetAddress) {
    switch (targetType) {
      case EMAIL -> {
        emailNotifierService.sendEmailNotification(notification, targetAddress);
      }
      case MOBILE, DESKTOP -> throw new IllegalStateException("Target value currently not supported: " + targetType);
      default -> throw new IllegalStateException("Unexpected notification target value: " + targetType);
    }
  }
}
