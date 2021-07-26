package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public abstract class NotificationMessage implements Serializable {

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "NotificationMessage{" +
           "notificationId=" + id +
           '}';
  }
}
