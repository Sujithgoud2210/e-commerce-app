package com.stschool.ecommerce.service;

import com.stschool.ecommerce.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl {
    public List<Product> getAvailableProducts(Product product) {
        return Product.stream()
                .filter(Product::isAvailable)
                .collect(Collectors.toList());
    }

}
