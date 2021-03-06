package com.ecommerce.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.ecommerce.domain.entity.Cart;
import com.ecommerce.domain.entity.Item;
import com.ecommerce.domain.entity.Product;
import com.ecommerce.domain.valueObject.Price;
import org.junit.jupiter.api.Test;

import java.util.Currency;

class CartTest {
  @Test
  void shouldAddItemToCart() {
    final Product ipadPro = new Product("Ipad Pro", new Price(10000.00, Currency.getInstance("INR")));
    final Product pen = new Product("Hero Ink Pen", new Price(10000.00, Currency.getInstance("INR")));
    final Product bat = new Product("GM Cricket Bat", new Price(10000.00, Currency.getInstance("INR")));

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
    final Product ipadPro = new Product("Ipad Pro", new Price(10000.00, Currency.getInstance("INR")));
    final Item ipadProItem = new Item(1, ipadPro);
    final Cart cart = new Cart();
    cart.add(ipadProItem);

    cart.remove(ipadProItem);

    assertEquals(true,cart.show().isEmpty());
  }

  @Test
  void shouldShowAllRemovedItemFromCart() {
    final Product ipadPro = new Product("Ipad Pro", new Price(10000.00, Currency.getInstance("INR")));
    final Item ipadProItem = new Item(1, ipadPro);
    final Cart cart = new Cart();
    cart.add(ipadProItem);

    cart.remove(ipadProItem);

    assertEquals(ipadPro,cart.showRemovedProducts().get(0));
  }

  @Test
  void shouldShowReturnFalseIfTwoCartsAreDifferent() {
    final Cart cart1 = new Cart();
    final Cart cart2 = new Cart();

    final Item ipadProItem1 = new Item(1, new Product("Ipad Pro", new Price(10000.00, Currency.getInstance("INR"))));
    final Item ipadProItem2 = new Item(1, new Product("Ipad Pro", new Price(10000.00, Currency.getInstance("INR"))));

    cart1.add(ipadProItem1);
    cart2.add(ipadProItem2);


    assertEquals(false, cart1.equals(cart2));
  }

  @Test
  void shouldReturnTrueForSameCart() {
    final Cart cart1 = new Cart();

    final Item ipadProItem1 = new Item(1, new Product("Ipad Pro", new Price(10000.00, Currency.getInstance("INR"))));

    cart1.add(ipadProItem1);


    assertEquals(true, cart1.equals(cart1));
  }
}
