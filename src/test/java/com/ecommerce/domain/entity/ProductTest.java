package com.ecommerce.domain.entity;

import com.ecommerce.domain.domain_service.ProductPriceCalculator;
import com.ecommerce.domain.valueObject.Price;
import org.junit.jupiter.api.Test;

import java.util.Currency;

class ProductTest {

    @Test
    void shouldCreateProductWith10PercentLessThanMarket() {
        ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator();
        productPriceCalculator.addProductPrice("Ipad Pro", new Price(100, Currency.getInstance("INR")));

        new Product("Ipad Pro", productPriceCalculator.calculate("Ipad Pro"), new Weight(100));

    }

}