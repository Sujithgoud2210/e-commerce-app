package ecommerce.service;

import ecommerce.model.Customer;
import ecommerce.repository.CustomerRepository;

public class CustomerService {

    public CustomerRepository customerRepository;

    public CustomerService(){
        customerRepository = new CustomerRepository();
    }

    public Customer handleSignup(Customer customer){
        System.out.println("Customer Service : " + customer);
        return customerRepository.addNewCustomer(customer);
    }

    public void displayCustomerDetails(Customer customer){
        System.out.println("-------------------------");
        System.out.println("ID : " + customer.getId());
        System.out.println("First Name : " + customer.getFirstName());
        System.out.println("Last Name : " + customer.getLastName());
        System.out.println("Email " + customer.getEmail());
        System.out.println("Contact No : " + customer.getContactNo());
        System.out.println("----------------------------");
    }

    public void displayAllCustomerDetails(Customer[] customers){
        for(Customer customer : customers){
            displayCustomerDetails(customer);
        }
    }

    public Customer[] getAllCustomers(){

        return customerRepository.getAllCustomers();
    }
}