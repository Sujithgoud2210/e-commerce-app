package com.stschool.ecommerce.service;

import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.repository.ProductRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private List<Product> products; // declare list

    public ProductServiceImpl() throws IOException {
        ProductRepository productRepository = new ProductRepository();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Product> getProductsAbovePrice(double price) {
        return products.stream()
                .filter(p -> p.getMaxRetailPrice() > price)
                .toList();
    }

    @Override
    public List<String> getAllProductNames() {
        return products.stream()
                .map(Product::getName)
                .toList();
    }

    @Override
    public long countAvailableProducts() {
        return products.stream()
                .filter(Product::isAvailable)
                .count();
    }

    @Override
    public boolean existsByCompany(String company) {
        return products.stream()
                .anyMatch(p -> p.getCompany().equalsIgnoreCase(company));
    }

    @Override
    public boolean areAllProductsAvailable() {
        return products.stream()
                .allMatch(Product::isAvailable);
    }

    @Override
    public Optional<Product> getFirstProduct() {
        return products.stream().findFirst();
    }

    @Override
    public List<String> getUniqueCategories() {
        return products.stream()
                .map(Product::getCategory)
                .distinct()
                .toList();
    }

    @Override
    public List<Product> getTopNExpensiveProducts(int n) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getMaxRetailPrice).reversed())
                .limit(n)
                .toList();
    }

    @Override
    public List<Product> sortByPriceAsc() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getMaxRetailPrice))
                .toList();
    }

    @Override
    public List<Product> sortByNameDesc() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName).reversed())
                .toList();
    }

    @Override
    public double getTotalInventoryValue() {
        return products.stream()
                .mapToDouble(Product::getMaxRetailPrice)
                .sum();
    }

    @Override
    public double getTotalPriceAfterDiscount() {
        return products.stream()
                .mapToDouble(p -> p.getMaxRetailPrice() * (1 - p.getDiscountPercentage() / 100))
                .sum();
    }

    @Override
    public List<Product> getProductsAfterYear(int year) {
        return products.stream()
                .filter(p -> p.getManufacturedYear() > year)
                .toList();
    }

    @Override
    public List<Product> getAvailableAndPriceGreater(double price) {
        return products.stream()
                .filter(p -> p.isAvailable() && p.getMaxRetailPrice() > price)
                .toList();
    }

    @Override
    public Map<String, Long> countByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    @Override
    public Map<String, List<Product>> groupByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    @Override
    public Map<String, List<Product>> groupByCompany() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCompany));
    }

    @Override
    public Map<Boolean, List<Product>> partitionByAvailability() {
        return products.stream()
                .collect(Collectors.partitioningBy(Product::isAvailable));
    }

    @Override
    public Optional<Product> getMostExpensiveProduct() {
        return products.stream()
                .max(Comparator.comparing(Product::getMaxRetailPrice));
    }

    @Override
    public Optional<Product> getCheapestProduct() {
        return products.stream()
                .min(Comparator.comparing(Product::getMaxRetailPrice));
    }

    @Override
    public Map<Integer, Product> mapById() {
        return products.stream()
                .collect(Collectors.toMap(Product::getId, p -> p));
    }

    @Override
    public Map<String, Double> avgPriceByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getMaxRetailPrice)
                ));
    }

    @Override
    public Map<String, List<Product>> top3ExpensiveByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Product::getMaxRetailPrice).reversed())
                                        .limit(3)
                                        .toList()
                        )
                ));
    }
}
