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

    List<Product> getProductByAvailability(boolean isAvailable);

    List<Product> getProductByCategory();

}
