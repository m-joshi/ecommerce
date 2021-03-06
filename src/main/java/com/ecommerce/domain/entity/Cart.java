package com.ecommerce.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cart {
  private final List<Item> items = new ArrayList<>();
  private final List<Product> removedProducts = new ArrayList<>();
  private UUID id;
  private boolean isCheckedOut;

  public Cart() {
    this.id = UUID.randomUUID();
    this.isCheckedOut = false;
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

  public Order checkout() {
    this.isCheckedOut = true;
    List<Product> products = new ArrayList<>();
    items.forEach(item -> {
      if(item.getQuantity() > 1) {
        for (int i = 0; i < item.getQuantity(); i++) {
           products.add(item.getProduct());
        }
      } else
      products.add(item.getProduct());
    });
    return new Order(products);
  }

  public boolean getCheckoutStatus() {
    return this.isCheckedOut;
  }
}
