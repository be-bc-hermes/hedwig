package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public class NotifyTargetMessage implements Serializable {

  private Long notificationId;

  private NotificationTarget targetType;

  private String targetAddress;

  public Long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }

  public NotificationTarget getTargetType() {
    return targetType;
  }

  public void setTargetType(NotificationTarget targetType) {
    this.targetType = targetType;
  }

  public String getTargetAddress() {
    return targetAddress;
  }

  public void setTargetAddress(String targetAddress) {
    this.targetAddress = targetAddress;
  }

  @Override
  public String toString() {
    return "NotifyTargetMessage{" +
           "notificationId=" + notificationId +
           ", targetType=" + targetType +
           ", targetAddress='" + targetAddress + '\'' +
           '}';
  }
}
