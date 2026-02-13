package ecommerce.main;

import ecommerce.controller.CustomerController;
import ecommerce.model.Customer;
import ecommerce.repository.CustomerRepository;
import ecommerce.service.CustomerService;
import ecommerce.ui.CustomerMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        CustomerService customerService = new CustomerService();
        CustomerRepository customerRepository = new CustomerRepository();


        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Signup");
        System.out.println("2. Display All Customers");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                CustomerMenu customerMenu = new CustomerMenu();
                Customer customer = customerMenu.inputCustomerSignupData();
                Customer newCustomer = customerController.handleSignup(customer);
                System.out.println("You have sucessfully Registeed::");
                //  System.out.println("Your details :");
                //CustomerService customerService = new CustomerService();
                //customerService.displayCustomerDetails(newCustomer);
                break;
            // inpu

            case 2:
                // Customer[] customers = customerRepository.getAllCustomers();
                Customer[] customers = customerController.getAllCustomers();
                //  customerService.displayAllCustomerDetails(customers);

                for(Customer cust : customers){
                    System.out.println(" -------------------");
                    System.out.println("Id : " + cust.getId());
                    System.out.println("First Name : " + cust.getFirstName());
                    System.out.println("Last Name : " + cust.getLastName());
                    System.out.println("Email : " + cust.getEmail() );
                    System.out.println("Password : " + cust.getPassword());
                    System.out.println("Contact No : " + cust.getContactNo());
                }
                break;
        }
        scanner.close();

        //Print all Customer Details


    }
}