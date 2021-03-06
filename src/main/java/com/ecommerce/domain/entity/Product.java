package com.ecommerce.domain.entity;

import com.ecommerce.domain.valueObject.Price;

import java.util.Currency;

public class Product {
  private final String name;
  private Price basicPrice;
  private Weight weight;

  public Product(String name, Price basicPrice, Weight weight) {
    this.name = name;
    this.basicPrice = basicPrice;
    this.weight = weight;
  }


  public Price getBasicPrice() {
    return this.basicPrice;
  }

  public Price getTotalPrice() {
    return new Price(this.basicPrice.getValue() + (this.weight.getValue() * 0.1), Currency.getInstance("INR"));
  }
}
