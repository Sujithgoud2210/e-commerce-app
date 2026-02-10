package com.stschool.ecommerce.repository;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.service.CustomerService;

public class CustomerRepository {
    public Customer addNewCustomer(Customer customer) {
        System.out.println("new customer added");
        System.out.println("customer details :"+customer);
        return customer;
    }
}
