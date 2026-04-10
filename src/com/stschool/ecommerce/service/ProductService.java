package com.stschool.ecommerce.service;

import com.stschool.ecommerce.exception.ProductExistException;
import com.stschool.ecommerce.exception.ProductNotFoundException;
import com.stschool.ecommerce.model.Product;
import java.util.List;

public interface ProductService {

    Product save(Product product) throws ProductExistException;

    Product getById(int id) throws ProductNotFoundException;

    List<Product> getAll() throws ProductNotFoundException;

    Product update(int id,Product product) throws ProductNotFoundException;

    void delete(int id) throws ProductNotFoundException;

    //Get all available products based on availability.
    List<Product> getProductsByAvailability(boolean isAvailable);

    //Get all products belonging to a given category.
    List<Product> getProductsByCategory(String category);

    //Get all products with price greater than a given value.
    List<Product> getProductsByMaxRetailPriceGreaterThan(double maxRetailPrice);

    //Get names of all products.
    List<String> getNamesOfAllProducts();

    //Count products by availability.
    long countProductsByAvailability(boolean isAvailable);

    //Check if there is any product from a given company.
    boolean hasProductFromCompany(String company);

    //Check if all products are available.
    boolean isAllProductsAvailable();

    //Get the first product safely.
    Optional<Product> getFirstProduct();

    //Get all unique categories.
    List<String> getAllUniqueCategories();

    //Get top N most expensive products.
    List<Product> getTopNExpensiveProducts(int n);

    //Sort products by price in ascending order.
    List<Product> getProductByPriceAscending();

    //Sort products by name in descending order.
    List<Product> getProductsByNameDescending();

    //Get total inventory value (sum of all product prices).
    double getTotalInventoryValue();

    //Get total inventory discounts value.
    double getTotalInventoryDiscountValue();

    //Get all products manufactured after a given year.
    List<Product> getAllProductsGivenYear(int year);

    //Get all products that are:
    //
    //- available
    //- and price greater than a given value
    List<Product> getAllAvailableProductsByMaxPrice(double price);

    //Count number of products in each category.
    Map<String, Long> countProductsInEachCategory();

    //Group all products by **category**.
    Map<String, List<Product>> groupAllProductByCategory();

    //Group all products by company.
    Map<String, List<Product>> groupAllProductByCompany();

    //Partition products into:
    //
    //- available
    //- unavailable
    Map<Boolean, List<Product>> partitionByAvailability();

    //Find the most expensive product.
    Optional<Product> getExpensiveProduct();

    //Find the cheapest product.
    Optional<Product> getCheapestProduct();

    //Create a Map of product ID to Product.
    Map<Integer, Product> mapByIdForProduct();

}
