package com.hermes.notificationservice.exception;

/**
 * @author meverg
 */
public class NotificationNotFoundById extends RuntimeException {

  public NotificationNotFoundById(Long id) {
    super(String.format("Notification by id: %d not found", id));
  }
}
