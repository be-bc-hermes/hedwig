package com.hermes.notificationservice.entities;

import com.hermes.notificationservice.models.NotificationType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author meverg
 */
@Entity
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Enumerated(EnumType.STRING)
  private NotificationType notificationType;

  private Long productId;

  private Double newPrice;

  private Double oldPrice;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Double getNewPrice() {
    return newPrice;
  }

  public void setNewPrice(Double newPriceInCents) {
    this.newPrice = newPriceInCents;
  }

  public Double getOldPrice() {
    return oldPrice;
  }

  public void setOldPrice(Double oldPriceInCents) {
    this.oldPrice = oldPriceInCents;
  }

  public NotificationType getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(NotificationType notificationType) {
    this.notificationType = notificationType;
  }

  @Override
  public String toString() {
    return "Notification{" +
           "id=" + id +
           ", notificationType=" + notificationType +
           ", productId=" + productId +
           ", newPriceInCents=" + newPrice +
           ", oldPriceInCents=" + oldPrice +
           '}';
  }
}
