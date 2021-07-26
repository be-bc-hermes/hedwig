package com.hermes.notificationservice.models;

/**
 * @author meverg
 */
public class ProductPriceChangeNotificationMessage extends NotificationMessage {

  private Long productId;

  private ProductPriceChannel priceChannel;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public ProductPriceChannel getPriceChannel() {
    return priceChannel;
  }

  public void setPriceChannel(ProductPriceChannel priceChannel) {
    this.priceChannel = priceChannel;
  }

  @Override
  public String toString() {
    return "ProductPriceChangeNotificationMessage{" +
           "productId=" + productId +
           ", productPriceChannel=" + priceChannel +
           "} " + super.toString();
  }
}
