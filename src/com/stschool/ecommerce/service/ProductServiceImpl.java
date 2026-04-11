package com.stschool.ecommerce.service;

import com.stschool.ecommerce.exception.ProductExistException;
import com.stschool.ecommerce.exception.ProductNotFoundException;
import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Override
    public Product save(Product product) throws ProductExistException {
        productRepository.getById(product.getId())
                .ifPresent((p->{
                    throw new ProductExistException("Product already exist exception");
                }));
                return productRepository.save(product);
    }

    @Override
    public Product getById(int id) throws ProductNotFoundException {
        return productRepository.getById(id)
                .orElseThrow(()-> new ProductNotFoundException("product not found exception"));
    }

    @Override
    public List<Product> getAll() throws ProductNotFoundException {
        return productRepository.getAll();
    }

    @Override
    public Product update(int id, Product product) throws ProductNotFoundException {
        return productRepository.getById(id)
                .orElseThrow(()-> new ProductNotFoundException("product not found exception"));
    }

    @Override
    public void delete(int id) throws ProductNotFoundException {
        productRepository.getById(id)
            .orElseThrow(()-> new ProductNotFoundException("product not found exception"));
    }

    @Override
    public List<Product> getProductsByAvailability(boolean isAvailable) {
        return productRepository.getAll().stream()
                .filter(product -> product.isAvailable() == isAvailable)
                .toList();


    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getAll().stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }

    @Override
    public List<Product> getProductsByMaxRetailPriceGreaterThan(double maxRetailPrice) {
        return productRepository.getAll().stream()
                .filter(product->product.getMaxRetailPrice() > maxRetailPrice)
                .toList();
    }

    @Override
    public List<String> getNamesOfAllProducts() {
        return productRepository.getAll().stream()
                .map(Product::getName)
                .toList();
    }

    @Override
    public long countProductsByAvailability(boolean isAvailable) {
        return getProductsByAvailability(isAvailable)
                .size();
    }

    @Override
    public boolean hasProductFromCompany(String company) {
        return productRepository.getAll().stream()
                .anyMatch(product -> product.getCompany().equalsIgnoreCase(company));
    }

    @Override
    public boolean isAllProductsAvailable() {
        return productRepository.getAll().stream()
                .allMatch(Product::isAvailable);
    }

    @Override
    public Optional<Product> getFirstProduct() {
        return productRepository.getAll().stream()
                .findFirst();
    }

    @Override
    public List<String> getAllUniqueCategories() {
        return productRepository.getAll().stream()
                .map(Product::getCategory)
                .distinct().toList();
    }

    @Override
    public List<Product> getTopNExpensiveProducts(int n) {
        return productRepository.getAll().stream()
                .sorted((p1,p2)->Double.compare(p2.getMaxRetailPrice(),p1.getMaxRetailPrice()))
                .limit(n).toList();
    }

    @Override
    public List<Product> getProductByPriceAscending() {
        return productRepository.getAll().stream()
                .sorted(Comparator.comparingDouble(Product::getMaxRetailPrice))
                .toList();
    }

    @Override
    public List<Product> getProductsByNameDescending() {
        return productRepository.getAll().stream()
                .sorted(Comparator.comparing(Product::getName).reversed())
                .toList();
    }

    @Override
    public double getTotalInventoryValue() {
      /*  return productRepository.getAll()
                .stream()
                .map(Product::getMaxRetailPrice)
                .reduce(0.0,Double::sum); */
        return productRepository.getAll()
                .stream()
                .mapToDouble(Product::getMaxRetailPrice)
                .sum();
    }

    @Override
    public double getTotalInventoryDiscountValue() {
        return productRepository.getAll()
                .stream()
                .mapToDouble(p -> p.getMaxRetailPrice() * p.getDiscountPercentage()/100)
                .sum();

    }

    @Override
    public List<Product> getAllProductsGivenYear(int year) {
        return List.of();
    }

    @Override
    public List<Product> getAllAvailableProductsByMaxPrice(double price) {
        return List.of();
    }

    @Override
    public Map<String, List<Product>> groupAllProductByCategory() {
        return productRepository.getAll()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory));

    }

    @Override
    public Map<String, List<Product>> groupAllProductByCompany() {
        return Map.of();
    }

    @Override
    public Map<Boolean, List<Product>> partitionByAvailability() {
        return Map.of();
    }

    @Override
    public Optional<Product> getExpensiveProduct() {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getCheapestProduct() {
        return Optional.empty();
    }

    @Override
    public Map<Integer, Product> mapByIdForProduct() {
        return Map.of();
    }

    @Override
    public Map<String, Long> countProductsInEachCategory() {
        return productRepository.getAll()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    @Override
    public Map<String, List<Product>> groupAllProductByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    // Group all products by company
    @Override
    public Map<String, List<Product>> groupAllProductByCompany() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCompany));
    }

    // Partition products into available and unavailable
    @Override
    public Map<Boolean, List<Product>> partitionByAvailability() {
        return products.stream()
                .collect(Collectors.partitioningBy(Product::isAvailable));
    }

    // Find the most expensive product
    @Override
    public Optional<Product> getExpensiveProduct() {
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice));
    }

    // Find the cheapest product
    @Override
    public Optional<Product> getCheapestProduct() {
        return products.stream()
                .min(Comparator.comparingDouble(Product::getPrice));
    }

    // Create a Map of product ID to Product
    @Override
    public Map<Integer, Product> mapByIdForProduct() {
        return productRepository.stream()
                .collect(Collectors.toMap(
                        Product::getId,
                        product -> product
                ));
    }
}
