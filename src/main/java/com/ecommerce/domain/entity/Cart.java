package com.ecommerce.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Cart {
  private final List<Item> items = new ArrayList<>();
  private final List<Product> removedProducts = new ArrayList<>();
  private UUID id;

  public Cart() {
    this.id = UUID.randomUUID();
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cart cart = (Cart) o;
    return Objects.equals(id, cart.id);

  }

}
