package com.stschool.ecommerce.service;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.repository.CustomerRepository;

public class CustomerService {
    public Customer handleSignup(Customer customer){
        System.out.println("customer service : "+customer);
        CustomerRepository customerRepository=new CustomerRepository();
        return customerRepository.addNewCustomer(customer);
    }
    public void displayCustomerDetails(Customer customer){
        System.out.println("customer id "+customer.getId());
        System.out.println("customer first name "+ customer.getFirstName());
        System.out.println("customer last name "+ customer.getLastName());
        System.out.println("customer email "+ customer.getEmail());
        System.out.println("customer contact number "+customer.getContactNo());
    }
}
