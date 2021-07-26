package com.hermes.notificationservice.models;

import java.io.Serializable;

/**
 * @author meverg
 */
public class ProductServiceMessageWrapper implements Serializable {

  ProductPriceChangeMessage message;

  public ProductPriceChangeMessage getMessage() {
    return message;
  }

  public void setMessage(ProductPriceChangeMessage message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ProductServiceMessageWrapper{" +
           "message=" + message +
           '}';
  }
}
