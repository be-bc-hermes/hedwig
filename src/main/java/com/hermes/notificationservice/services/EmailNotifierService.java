package com.hermes.notificationservice.services;

import com.hermes.notificationservice.entities.Notification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
public class EmailNotifierService {

  private static final String NOREPLY_ADDRESS = "noreply@hedwig.com";

  private final JavaMailSender mailSender;

  public EmailNotifierService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void sendEmailNotification(Notification notification, String emailAddress) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(NOREPLY_ADDRESS);
    message.setTo(emailAddress);
    message.setSubject("Product Price Change");
    message.setText(
        String.format("Price of the product %d you follow has changed from %.2f to %.2f", notification.getProductId(),
                      notification.getOldPriceInCents().floatValue() / 100,
                      notification.getNewPriceInCents().floatValue() / 100));
    mailSender.send(message);
  }
}
