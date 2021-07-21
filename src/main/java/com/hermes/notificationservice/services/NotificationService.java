package com.hermes.notificationservice.services;

import com.hermes.notificationservice.entities.Notification;
import com.hermes.notificationservice.models.ProductPriceChange;
import com.hermes.notificationservice.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
public class NotificationService {

  private final NotificationRepository repository;

  public NotificationService(NotificationRepository repository) {
    this.repository = repository;
  }

  public Notification createProductPriceChangeNotification(ProductPriceChange productPriceChange) {
    Notification notification = new Notification();
    notification.setNewPriceInCents(productPriceChange.getNewPrice());
    notification.setOldPriceInCents(productPriceChange.getOldPrice());
    notification.setProductId(productPriceChange.getProductId());
    repository.save(notification);
    return notification;
  }

  private void getSubscriptionsOfProductPriceChange(Long productId) {
  }

  private void notifySubscribers() {
  }

  ;
}
