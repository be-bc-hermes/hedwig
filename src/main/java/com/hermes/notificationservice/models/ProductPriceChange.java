package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public class ProductPriceChange implements Serializable {

  private Long productId;

  private String productName;

  private Integer oldPrice;

  private Integer newPrice;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getOldPrice() {
    return oldPrice;
  }

  public void setOldPrice(Integer oldPrice) {
    this.oldPrice = oldPrice;
  }

  public Integer getNewPrice() {
    return newPrice;
  }

  public void setNewPrice(Integer newPrice) {
    this.newPrice = newPrice;
  }

  @Override
  public String toString() {
    return "ProductPriceChangeMessage{" +
           "productId=" + productId +
           ", productName='" + productName + '\'' +
           ", oldPrice=" + oldPrice +
           ", newPrice=" + newPrice +
           '}';
  }
}
