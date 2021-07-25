package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public abstract class NotificationMessage implements Serializable {

  private Long notificationId;

  public Long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }

  @Override
  public String toString() {
    return "NotificationMessage{" +
           "notificationId=" + notificationId +
           '}';
  }
}
