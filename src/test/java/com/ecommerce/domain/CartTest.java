package com.ecommerce.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

class CartTest {
  @Test
  void shouldAddItemToCart() {
    final Product ipadPro = new Product("Ipad Pro");
    final Product pen = new Product("Hero Ink Pen");
    final Product bat = new Product("GM Cricket Bat");

    final Item ipadProItem = new Item(1, ipadPro);
    final Item penItem = new Item(1, pen);
    final Item batItem = new Item(2, bat);

    final Cart cart = new Cart();
    cart.add(ipadProItem);
    cart.add(penItem);
    cart.add(batItem);

    assertEquals(ipadProItem, cart.show().get(0));
    assertEquals(penItem, cart.show().get(1));
    assertEquals(batItem, cart.show().get(2));
  }

  @Test
  void shouldRemoveItemFromCart() {
    final Product ipadPro = new Product("Ipad Pro");
    final Item ipadProItem = new Item(1, ipadPro);
    final Cart cart = new Cart();
    cart.add(ipadProItem);

    cart.remove(ipadProItem);

    assertEquals(true,cart.show().isEmpty());
  }

  @Test
  void shouldShowAllRemovedItemFromCart() {
    final Product ipadPro = new Product("Ipad Pro");
    final Item ipadProItem = new Item(1, ipadPro);
    final Cart cart = new Cart();
    cart.add(ipadProItem);

    cart.remove(ipadProItem);

    assertEquals(ipadPro,cart.showRemovedProducts().get(0));
  }
}
