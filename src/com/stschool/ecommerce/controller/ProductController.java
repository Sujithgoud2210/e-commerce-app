package com.stschool.ecommerce.controller;

import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.service.ProductService;

public class ProductController {

        private final ProductService productService;

        public ProductController(ProductService productService) {
            this.productService = productService;
    }
}
