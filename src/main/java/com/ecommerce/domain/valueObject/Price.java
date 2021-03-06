package com.ecommerce.domain.valueObject;

import java.util.Currency;

public class Price {
    private double value;
    private Currency currency;

    public Price(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return this.value;
    }
}
