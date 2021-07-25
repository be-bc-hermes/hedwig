package com.hermes.notificationservice.models;

/**
 * @author meverg
 */
public class ProductPriceChangeNotificationMessage extends NotificationMessage {

  private Long productId;

  private ProductPriceChannel productPriceChannel;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public ProductPriceChannel getProductPriceChannel() {
    return productPriceChannel;
  }

  public void setProductPriceChannel(ProductPriceChannel productPriceChannel) {
    this.productPriceChannel = productPriceChannel;
  }

  @Override
  public String toString() {
    return "ProductPriceChangeNotificationMessage{" +
           "productId=" + productId +
           ", productPriceChannel=" + productPriceChannel +
           "} " + super.toString();
  }
}
