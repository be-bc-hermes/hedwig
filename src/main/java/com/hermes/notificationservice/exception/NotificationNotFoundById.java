package com.hermes.notificationservice.exception;

/**
 * @author meverg
 */
public class NotificationNotFoundById extends RuntimeException {

  public NotificationNotFoundById(String id) {
    super(String.format("Notification by id: %s not found", id));
  }
}
