package com.hermes.notificationservice.messaging;

import com.hermes.notificationservice.models.NotifyTargetMessage;
import com.hermes.notificationservice.services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author meverg
 */
@Component
public class NotifyTargetListener {

  private NotificationService notificationService;

  public NotifyTargetListener(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @RabbitListener(queues = "${ns.rabbit.queues.notify-target}")
  public void notifyTargetListener(NotifyTargetMessage message) {
    notificationService.notifyTarget(message);
  }
}
