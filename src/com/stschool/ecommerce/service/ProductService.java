package com.stschool.ecommerce.service;

import com.stschool.ecommerce.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();
    public List<Product> getProductsByCategory(String category);
    public List<Product> getProductsAbovePrice(double price);
    public List<String> getAllProductNames();
    public long countAvailableProducts();
    public boolean existsByCompany(String company);
    public boolean areAllProductsAvailable();
    public Optional<Product> getFirstProduct();

    public List<String> getUniqueCategories();
    public List<Product> getTopNExpensiveProducts(int n);
    public List<Product> sortByPriceAsc();
    public List<Product> sortByNameDesc();
    public double getTotalInventoryValue();
    public double getTotalPriceAfterDiscount();
    public List<Product> getProductsAfterYear(int year);
    public List<Product> getAvailableAndPriceGreater(double price);
    public Map<String, Long> countByCategory();

    public Map<String, List<Product>> groupByCategory();
    public Map<String, List<Product>> groupByCompany();
    public Map<Boolean, List<Product>> partitionByAvailability();
    public Optional<Product> getMostExpensiveProduct();
    public Optional<Product> getCheapestProduct();
    public Map<Integer, Product> mapById();
    public Map<String, Double> avgPriceByCategory();
    public Map<String, List<Product>> top3ExpensiveByCategory();
}
