package com.ecommerce.domain.entity;

import com.ecommerce.domain.valueObject.Price;

public class Product {
  private final String name;

  public Product(String name, Price inr) {
    this.name = name;
  }

}
