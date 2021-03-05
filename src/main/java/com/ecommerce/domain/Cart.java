package com.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private final List<Item> items = new ArrayList<>();
  private final List<Product> removedProducts = new ArrayList<>();

  public void add(Item item) {
    this.items.add(item);
    System.out.println("Added");
  }

  public List<Item> show() {
    return this.items;
  }

  public void remove(Item item) {
    this.items.remove(item);
    this.removedProducts.add(item.getProduct());
  }

  public List<Product> showRemovedProducts() {
    return this.removedProducts;
  }
}
