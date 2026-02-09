package com.stschool.ecommerce.model;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactNo;
    public Customer() {

    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo() {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
