package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public class ProductPriceChangeMessage implements Serializable {

  private Long id;

  private ProductPriceChannel priceType;

  private Double oldPrice;

  private Double newPrice;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getOldPrice() {
    return oldPrice;
  }

  public void setOldPrice(Double oldPrice) {
    this.oldPrice = oldPrice;
  }

  public Double getNewPrice() {
    return newPrice;
  }

  public void setNewPrice(Double newPrice) {
    this.newPrice = newPrice;
  }

  public ProductPriceChannel getPriceType() {
    return priceType;
  }

  public void setPriceType(ProductPriceChannel priceType) {
    this.priceType = priceType;
  }

  @Override
  public String toString() {
    return "ProductPriceChangeMessage{" +
           "productId=" + id +
           ", priceChannel=" + priceType +
           ", oldPrice=" + oldPrice +
           ", newPrice=" + newPrice +
           '}';
  }
}
