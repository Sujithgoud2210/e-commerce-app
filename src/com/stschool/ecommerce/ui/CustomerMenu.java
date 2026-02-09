package com.stschool.ecommerce.ui;
import com.stschool.ecommerce.model.Customer;

import java.util.Scanner;

public class CustomerMenu {
    public Customer inputCustomerSignUpData(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter id");
        String id=scanner.next();
        System.out.println("enter first name");
        String firstName=scanner.next();
        System.out.println("enter last name");
        String lastName=scanner.next();
        System.out.println("enter email");
        String email=scanner.next();
        System.out.println("enter password");
        String password=scanner.next();
        System.out.println("enter contact number");
        String contactNo=scanner.next();
        Customer customer=new Customer();
        customer.setId();
        customer.setFirstName();
        customer.setLastName();
        customer.setEmail();
        customer.setPassword();
        customer.setContactNo();
        scanner.close();
        return customer;
    }
}
