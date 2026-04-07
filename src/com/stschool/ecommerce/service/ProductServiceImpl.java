package com.stschool.ecommerce.service;

import com.stschool.ecommerce.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    private List<Product> productList;

    @Override
    public List<Product> getAllProducts() {
        return productList.stream()
                .collect(Collectors.toList();
    }
}

}
