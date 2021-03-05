package com.ecommerce.domain;

public class Item {
  private final int quantity;
  private final Product product;

  public Item(int quantity, Product product) {
    this.quantity = quantity;
    this.product = product;
  }

  public Product getProduct() {
    return this.product;
  }
}
