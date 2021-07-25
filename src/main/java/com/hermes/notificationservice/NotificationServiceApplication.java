package com.hermes.notificationservice;

import com.hermes.notificationservice.models.ProductPriceChange;
import com.hermes.notificationservice.services.NotificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(NotificationService notificationService) {
    return args -> {
      notificationService.createProductPriceChangeNotification(new ProductPriceChange());
    };
  }

}
