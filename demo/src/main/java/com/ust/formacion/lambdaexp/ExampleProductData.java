package com.ust.formacion.lambdaexp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ExampleProductData {

      private static final List<Product> PRODUCTS = Arrays.asList(
            new Product(Category.FOOD, "Apple", BigDecimal.valueOf(0.99)),
            new Product(Category.FOOD, "Bread", BigDecimal.valueOf(1.49)),
            new Product(Category.UTENSILS, "Spoon", BigDecimal.valueOf(2.99)),
            new Product(Category.CLEANING, "Detergent", BigDecimal.valueOf(5.49)),
            new Product(Category.OFFICE, "Notebook", BigDecimal.valueOf(3.99)),
            new Product(Category.FOOD, "Banana", BigDecimal.valueOf(0.79)),
            new Product(Category.UTENSILS, "Fork", BigDecimal.valueOf(2.49)),
            new Product(Category.CLEANING, "Soap", BigDecimal.valueOf(1.99)),
            new Product(Category.OFFICE, "Pen", BigDecimal.valueOf(1.29))
        );

    public static List<Product> getProducts() {
            return PRODUCTS;
        }
}
