package com.ecommerce.domain.domain_service;

import com.ecommerce.domain.valueObject.Price;

import java.util.Currency;
import java.util.HashMap;

public class ProductPriceCalculator {
    HashMap productPriceMap = new HashMap<String, Price>();

    public void addProductPrice(String product, Price price) {
        productPriceMap.put("Ipad Pro", new Price(100, Currency.getInstance("INR")));
    }


    public Price calculate(String productName) {
        Price marketPrice;
            marketPrice = (Price) productPriceMap.get(productName);
        return new Price(marketPrice.getValue() * 0.9, Currency.getInstance("INR"));
    }
}
