package com.stschool.ecommerce.exception;

public class ProductExistException extends RuntimeException{
    public ProductExistException(String message){
        super(message);
    }
}
