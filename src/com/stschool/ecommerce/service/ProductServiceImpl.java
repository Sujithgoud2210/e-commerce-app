package com.stschool.ecommerce.service;

import com.stschool.ecommerce.exception.ProductExistException;
import com.stschool.ecommerce.exception.ProductNotFoundException;
import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.repository.ProductRepository;

import java.util.List;

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


}
