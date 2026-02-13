package ecommerce.controller;

import ecommerce.model.Customer;
import ecommerce.service.CustomerService;

public class CustomerController {

    CustomerService customerService;

    public CustomerController() {
        customerService = new CustomerService();
    }


    public Customer handleSignup(Customer customer) {
        System.out.println("Handling Signup for : " + customer);
        //handle validation logic
        return customerService.handleSignup(customer);

    }

    public Customer[] getAllCustomers() {
        return customerService.getAllCustomers();
    }
}