package com.ecommerce.domain.entity;

import com.ecommerce.domain.valueObject.Price;

import java.util.Currency;
import java.util.List;
import java.util.Optional;

public class Order {
    private final List<Product> checkoutItems;

    public Order(List<Product> products) {
        this.checkoutItems = products;
    }

    public int getSize() {
        return checkoutItems.size();
    }

    public Price calculateCost() {
        Optional<Double> totalCost = this.checkoutItems.stream().
                map(product -> product.getTotalPrice().getValue()).reduce(Double::sum);

        return new Price(totalCost.orElse(-1.0), Currency.getInstance("INR"));

    }
}
