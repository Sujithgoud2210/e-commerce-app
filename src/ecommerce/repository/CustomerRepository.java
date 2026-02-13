package ecommerce.repository;

import ecommerce.model.Customer;

public class CustomerRepository {

    Customer[] customers;
    int index = 0;

    public CustomerRepository(){
        customers = new Customer[3];
        initialCustomers();
    }

    public Customer addNewCustomer(Customer customer){
        System.out.println("New Customer Addeed Successfully");
        System.out.println("Customer Details: " + customer);

        customers[++index] = customer;
        return customer;
    }

    public Customer[] getAllCustomers(){
        return customers;
    }
    public void initialCustomers(){
        customers[index] = new Customer();
        customers[index].setId("Cust-111");
        customers[index].setFirstName("Cust-111");
        customers[index].setLastName("Cust-111");
        customers[index].setEmail("customer1@gmail.com");
        customers[index].setPassword("customer1");
        customers[index].setContactNo("1111111111");
        index++;
        customers[index] = new Customer();
        customers[index].setId("Cust-222");
        customers[index].setFirstName("Cust-222");
        customers[index].setLastName("Cust-222");
        customers[index].setEmail("customer222@gmail.com");
        customers[index].setPassword("customer222");
        customers[index].setContactNo("2222222");
        index++;
        customers[index] = new Customer();
        customers[index].setId("Cust-333");
        customers[index].setFirstName("Cust-333");
        customers[index].setLastName("Cust-333");
        customers[index].setEmail("customer3@gmail.com");
        customers[index].setPassword("customer333");
        customers[index].setContactNo("3333333");


    }
}