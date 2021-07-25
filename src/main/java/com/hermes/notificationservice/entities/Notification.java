package com.hermes.notificationservice.entities;

import com.hermes.notificationservice.models.NotificationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

/**
 * @author meverg
 */
@Document
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
  private String id;

  @Field
  private Long productId;

  @Field
  private Integer newPriceInCents;

  @Field
  private Integer oldPriceInCents;

  @Field
  private NotificationType notificationType;

  public String getId() {
    return id;
  }

  public NotificationType getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(NotificationType notificationType) {
    this.notificationType = notificationType;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getNewPriceInCents() {
    return newPriceInCents;
  }

  public void setNewPriceInCents(Integer newPriceInCents) {
    this.newPriceInCents = newPriceInCents;
  }

  public Integer getOldPriceInCents() {
    return oldPriceInCents;
  }

  public void setOldPriceInCents(Integer oldPriceInCents) {
    this.oldPriceInCents = oldPriceInCents;
  }

  @Override
  public String toString() {
    return "Notification{" +
            "id='" + id + '\'' +
            ", productId=" + productId +
            ", newPriceInCents=" + newPriceInCents +
            ", oldPriceInCents=" + oldPriceInCents +
            ", notificationType=" + notificationType +
            '}';
  }
}
