package com.stschool.ecommerce.controller;

import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.service.ProductService;

public class ProductController {

        private final ProductService productService;

        public ProductController(ProductService productService) {
            this.productService = productService;
        }

        // ✅ Save Product
        @PostMapping
        public Product save(@RequestBody Product product) throws ProductExistException {
            return productService.save(product);
        }

        // ✅ Get Product by ID
        @GetMapping("/{id}")
        public Product getById(@PathVariable int id) throws ProductNotFoundException {
            return productService.getById(id);
        }

        // ✅ Get All Products
        @GetMapping
        public List<Product> getAll() {
            return productService.getAll();
        }

        // ✅ Delete Product
        @DeleteMapping("/{id}")
        public String delete(@PathVariable int id) throws ProductNotFoundException {
            productService.delete(id);
            return "Product deleted successfully";
        }

        // ✅ Get by Availability
        @GetMapping("/availability/{status}")
        public List<Product> getByAvailability(@PathVariable boolean status) {
            return productService.getProductsByAvailability(status);
        }

        // ✅ Get by Category
        @GetMapping("/category/{category}")
        public List<Product> getByCategory(@PathVariable String category) {
            return productService.getProductsByCategory(category);
        }

        // ✅ Group by Category
        @GetMapping("/group/category")
        public Map<String, List<Product>> groupByCategory() {
            return productService.groupAllProductByCategory();
        }

        // ✅ Group by Company
        @GetMapping("/group/company")
        public Map<String, List<Product>> groupByCompany() {
            return productService.groupAllProductByCompany();
        }

        // ✅ Partition by Availability
        @GetMapping("/partition")
        public Map<Boolean, List<Product>> partitionByAvailability() {
            return productService.partitionByAvailability();
        }

        // ✅ Most Expensive Product
        @GetMapping("/expensive")
        public Optional<Product> getExpensiveProduct() {
            return productService.getExpensiveProduct();
        }

        // ✅ Cheapest Product
        @GetMapping("/cheapest")
        public Optional<Product> getCheapestProduct() {
            return productService.getCheapestProduct();
        }

        // ✅ Map by ID
        @GetMapping("/map")
        public Map<Integer, Product> mapById() {
            return productService.mapByIdForProduct();
        }
    }
}
