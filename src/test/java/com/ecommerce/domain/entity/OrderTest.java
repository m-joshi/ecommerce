package com.ecommerce.domain.entity;

import com.ecommerce.domain.valueObject.Price;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    @Test
    void shouldReturnTotalCostOfOrder() {
        final Product ipadPro = new Product("Ipad Pro", new Price(10000.00, Currency.getInstance("INR")),
                new Weight(100));
        final Product pen = new Product("Hero Ink Pen", new Price(10000.00, Currency.getInstance("INR")),
                new Weight(100));
        final Product bat = new Product("GM Cricket Bat", new Price(10000.00, Currency.getInstance("INR")),
                new Weight(100));
        final Product bat2 = new Product("GM Cricket Bat", new Price(10000.00, Currency.getInstance("INR")),
                new Weight(100));

        List<Product> products = new ArrayList<>();
        products.add(ipadPro);
        products.add(ipadPro);
        products.add(pen);
        products.add(bat);
        products.add(bat2);

        Order order = new Order(products);

        Price cost = order.calculateCost();

        assertEquals(50050.0, cost.getValue());

    }
}


