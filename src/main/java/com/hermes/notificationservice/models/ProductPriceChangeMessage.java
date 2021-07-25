package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public class ProductPriceChangeMessage implements Serializable {

  private Long productId;

  private String productName;

  private ProductPriceChannel priceChannel;

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

  public ProductPriceChannel getPriceChannel() {
    return priceChannel;
  }

  public void setPriceChannel(ProductPriceChannel priceChannel) {
    this.priceChannel = priceChannel;
  }

  @Override
  public String toString() {
    return "ProductPriceChangeMessage{" +
           "productId=" + productId +
           ", productName='" + productName + '\'' +
           ", priceChannel=" + priceChannel +
           ", oldPrice=" + oldPrice +
           ", newPrice=" + newPrice +
           '}';
  }
}
