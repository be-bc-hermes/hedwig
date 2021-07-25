package com.hermes.notificationservice.messaging;

import com.hermes.notificationservice.entities.Notification;
import com.hermes.notificationservice.models.ProductPriceChangeNotificationMessage;
import com.hermes.notificationservice.models.ProductPriceChannel;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author meverg
 */
@Component
public class NotificationPublisher {

  private final RabbitTemplate rabbitTemplate;

  private final DirectExchange notificationExchange;

  @Value("${ns.rabbit.routing-keys.product-price-change-notification}")
  private String productPriceChangeNotificationRoutingKey;

  public NotificationPublisher(RabbitTemplate rabbitTemplate,
                               DirectExchange notificationExchange) {
    this.rabbitTemplate = rabbitTemplate;
    this.notificationExchange = notificationExchange;
  }

  public void publishNewNotificationMessage(Notification notification) {
    switch (notification.getNotificationType()) {
      case PRODUCT_MOBILE_PRICE_CHANGE -> {
        var message = new ProductPriceChangeNotificationMessage();
        message.setNotificationId(notification.getId());
        message.setProductId(notification.getProductId());
        message.setProductPriceChannel(ProductPriceChannel.MOBILE);
        rabbitTemplate.convertAndSend(notificationExchange.getName(), productPriceChangeNotificationRoutingKey,
                                      message);
      }
      case PRODUCT_DESKTOP_PRICE_CHANGE -> {
        var message = new ProductPriceChangeNotificationMessage();
        message.setNotificationId(notification.getId());
        message.setProductId(notification.getProductId());
        message.setProductPriceChannel(ProductPriceChannel.DESKTOP);
        rabbitTemplate.convertAndSend(notificationExchange.getName(), productPriceChangeNotificationRoutingKey,
                                      message);
      }
      default -> throw new IllegalStateException(
          "Unexpected notification type value: " + notification.getNotificationType());
    }
  }
}
