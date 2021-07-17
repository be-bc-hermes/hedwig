package com.hermes.notificationservice.services;

import com.hermes.notificationservice.entities.Notification;
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

  public Notification createNotification() {
    Notification notification = new Notification();
    notification.setNewPriceInCents(1000);
    notification.setOldPriceInCents(1500);
    notification.setProductId(100000L);
    repository.save(notification);
    return notification;
  }

  private void getSubscriptionsOfProductPriceChange(Long productId){}

  private void notifySubscribers(){};

}
