package com.ecommerce.domain.entity;

public class Weight {

    private final String unit;
    private double value;

    public Weight(double value) {
        this.value = value;
        this.unit = "grams";
    }

    public double getValue() {
        return this.value;
    }
}
