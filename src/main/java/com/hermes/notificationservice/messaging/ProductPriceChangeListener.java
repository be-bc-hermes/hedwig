package com.hermes.notificationservice.messaging;

import com.hermes.notificationservice.models.ProductPriceChangeMessage;
import com.hermes.notificationservice.services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author meverg
 */
@Component
public class ProductPriceChangeListener {

  private final NotificationService notificationService;

  public ProductPriceChangeListener(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @RabbitListener(queues = "${ns.rabbit.queues.product-price-change}")
  public void productPriceChangeListener(ProductPriceChangeMessage message) {
    notificationService.createProductPriceChangeNotification(message);
  }
}
