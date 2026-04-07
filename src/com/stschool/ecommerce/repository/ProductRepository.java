package com.stschool.ecommerce.repository;

import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.util.CsvParser;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepository {

    private final List<Product> products;

    public ProductRepository() throws IOException {
        CsvParser csvParser = new CsvParser();
        products = csvParser.getProductsFromCsv();
    }

    public Product save(Product product) {
        this.products.add(product);
        return product;
    }

    public Optional<Product> getById(int id){
       return products.stream()
                .filter(product -> product.getId()==id)
                .findFirst();
    }

    public List<Product> getAll(){
        return this.products;
    }

    public List<Product> getByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // 🔹 2. Price > value
    public List<Product> getByPriceGreaterThan(double price) {
        return products.stream()
                .filter(p -> p.getMaxRetailPrice() > price)
                .toList();
    }

    // 🔹 3. Names
    public List<String> getAllNames() {
        return products.stream()
                .map(Product::getName)
                .toList();
    }

    // 🔹 4. Count available
    public long countAvailable() {
        return products.stream()
                .filter(Product::isAvailable)
                .count();
    }

    // 🔹 5. Any company
    public boolean existsByCompany(String company) {
        return products.stream()
                .anyMatch(p -> p.getCompany().equalsIgnoreCase(company));
    }

    // 🔹 6. All available?
    public boolean allAvailable() {
        return products.stream()
                .allMatch(Product::isAvailable);
    }

    // 🔹 7. First product
    public Optional<Product> getFirst() {
        return products.stream().findFirst();
    }

    // 🔹 8. Unique categories
    public List<String> getUniqueCategories() {
        return products.stream()
                .map(Product::getCategory)
                .distinct()
                .toList();
    }

    // 🔹 9. Top N expensive
    public List<Product> getTopNExpensive(int n) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getMaxRetailPrice).reversed())
                .limit(n)
                .toList();
    }

    // 🔹 10. Sort price asc
    public List<Product> sortByPriceAsc() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getMaxRetailPrice))
                .toList();
    }

    // 🔹 11. Sort name desc
    public List<Product> sortByNameDesc() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName).reversed())
                .toList();
    }

    // 🔹 12. Total inventory value
    public double getTotalValue() {
        return products.stream()
                .mapToDouble(Product::getMaxRetailPrice)
                .sum();
    }

    // 🔹 13. Total after discount
    public double getTotalAfterDiscount() {
        return products.stream()
                .mapToDouble(p -> p.getMaxRetailPrice() * (1 - p.getDiscountPercentage() / 100))
                .sum();
    }

    // 🔹 14. After year
    public List<Product> getAfterYear(int year) {
        return products.stream()
                .filter(p -> p.getManufacturedYear() > year)
                .toList();
    }

    // 🔹 15. Available + price
    public List<Product> getAvailableAndPriceGreater(double price) {
        return products.stream()
                .filter(p -> p.isAvailable() && p.getMaxRetailPrice() > price)
                .toList();
    }

    // 🔹 16. Count by category
    public Map<String, Long> countByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    // 🔹 17. Group by category
    public Map<String, List<Product>> groupByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    // 🔹 18. Group by company
    public Map<String, List<Product>> groupByCompany() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCompany));
    }

    // 🔹 19. Partition
    public Map<Boolean, List<Product>> partitionByAvailability() {
        return products.stream()
                .collect(Collectors.partitioningBy(Product::isAvailable));
    }

    // 🔹 20. Most expensive
    public Optional<Product> getMaxPriceProduct() {
        return products.stream()
                .max(Comparator.comparing(Product::getMaxRetailPrice));
    }

    // 🔹 21. Cheapest
    public Optional<Product> getMinPriceProduct() {
        return products.stream()
                .min(Comparator.comparing(Product::getMaxRetailPrice));
    }

    // 🔹 22. Map ID → Product
    public Map<Integer, Product> mapById() {
        return products.stream()
                .collect(Collectors.toMap(Product::getId, p -> p));
    }

    // 🔹 23. Avg price by category
    public Map<String, Double> avgPriceByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getMaxRetailPrice)
                ));
    }

    // 🔹 24. Top 3 expensive per category
    public Map<String, List<Product>> top3ByCategory() {
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
