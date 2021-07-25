package com.hermes.notificationservice.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author meverg
 */
@Configuration
public class NotificationMessagingConfig {

  @Value("${ns.rabbit.exchanges.notification}")
  String notificationExchangeName;

  @Value("${ns.rabbit.queues.product-price-change-notification-subscribers}")
  String notificationSubscribersQueueName;

  @Value("${ns.rabbit.routing-keys.product-price-change-notification}")
  String productPriceChangeNotificationRoutingKey;

  @Bean
  public DirectExchange notificationExchange() {
    return new DirectExchange(notificationExchangeName);
  }

  @Bean
  public Queue notificationSubscribersQueue() {
    return new Queue(notificationSubscribersQueueName, true);
  }

  @Bean
  public Binding notificationSubscribersBinding(DirectExchange notificationExchange,
                                                Queue notificationSubscribersQueue) {
    return BindingBuilder.bind(notificationSubscribersQueue)
                         .to(notificationExchange)
                         .with(productPriceChangeNotificationRoutingKey);
  }
}
