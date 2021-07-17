package com.hermes.notificationservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author meverg
 */
@Entity
public class Notification {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  private Long productId;

  private Integer newPriceInCents;

  private Integer oldPriceInCents;

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
           "id=" + id +
           ", productId=" + productId +
           ", newPriceInCents=" + newPriceInCents +
           ", oldPriceInCents=" + oldPriceInCents +
           '}';
  }
}
