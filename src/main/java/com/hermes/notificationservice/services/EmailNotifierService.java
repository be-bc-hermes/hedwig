package com.hermes.notificationservice.services;

import com.hermes.notificationservice.entities.Notification;
import org.springframework.stereotype.Service;

/**
 * @author meverg
 */
@Service
public class EmailNotifierService {

  public void sendEmailNotification(Notification notification, String emailAddress) {
    //TODO
    System.out.printf("Will send email to %s , about %s%n", emailAddress, notification.toString());
  }
}
