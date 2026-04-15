package com.stschool.ecommerce.controller;

import com.stschool.ecommerce.exception.ProductExistException;
import com.stschool.ecommerce.exception.ProductNotFoundException;
import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductController {

        private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;

    }
    public Product save(Product product) throws ProductExistException {
        return productService.save(product);
    }
    public Product getById(int id) throws ProductNotFoundException {
        return productService.getById(id);
    }
    public List<Product> getAll() {
        return productService.getAll();
    }


    public Product update(int id, Product product) throws ProductNotFoundException {
        return productService.update(id, product);
    }


    public void delete(int id) throws ProductNotFoundException {
        productService.delete(id);
    }
    public List<Product> getProductsByAvailability(boolean isAvailable) {
        return  productService.getProductsByAvailability(isAvailable);
    }
    public List<Product> getProductsByCategory(String category) {
        return productService.getProductsByCategory(category);
    }
    public List<Product> getProductsByMaxRetailPriceGreaterThan(double maxRetailPrice) {
        return productService.getProductsByMaxRetailPriceGreaterThan(maxRetailPrice);
    }
    public List<String> getNamesOfAllProducts() {
        return productService.getNamesOfAllProducts();
    }
    public long countProductsByAvailability(boolean isAvailable) {
        return productService.countProductsByAvailability(isAvailable);
    }
    public boolean hasProductFromCompany(String company) {
        return productService.hasProductFromCompany(company);
    }
    public boolean isAllProductsAvailable() {
        return productService.isAllProductsAvailable();
    }
    public Optional<Product> getFirstProduct() {
        return productService.getFirstProduct();
    }
    public List<String> getAllUniqueCategories() {
        return productService.getAllUniqueCategories();
    }
    public List<Product> getTopNExpensiveProducts(int n) {
        return productService.getTopNExpensiveProducts(n);
    }

    public List<Product> getProductByPriceAscending() {
        return productService.getProductByPriceAscending();
    }
    public List<Product> getProductsByNameDescending() {
        return productService.getProductsByNameDescending();

    }
    public double getTotalInventoryValue() {
        return productService.getTotalInventoryValue();
    }
    public double getTotalInventoryDiscountValue() {
        return productService.getTotalInventoryDiscountValue();
    }
    public List<Product> getAllProductsGivenYear(int year){
        return productService.getAllProductsGivenYear(year);
    }
    public List<Product> getAllAvailableProductsByMaxPrice(double price){
        return productService.getAllAvailableProductsByMaxPrice(price);
    }
    public Map<String, List<Product>> groupAllProductByCategory() {
        return productService.groupAllProductByCategory();
    }
    public Map<Boolean, List<Product>> partitionByAvailability(){
        return productService.partitionByAvailability();
    }
    public Optional<Product> getExpensiveProduct(){
        return productService.getExpensiveProduct();
    }
    public Optional<Product> getCheapestProduct() {
        return productService.getCheapestProduct();
    }
    public Map<Integer, Product> mapByIdForProduct(){
        return productService.mapByIdForProduct();
    }
    public Map<String, Long> countProductsInEachCategory() {
        return productService.countProductsInEachCategory();
    }
}
