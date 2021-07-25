package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public abstract class NotificationMessage implements Serializable {

  private String notificationId;

  public String getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(String notificationId) {
    this.notificationId = notificationId;
  }

  @Override
  public String toString() {
    return "NotificationMessage{" +
           "notificationId=" + notificationId +
           '}';
  }
}
