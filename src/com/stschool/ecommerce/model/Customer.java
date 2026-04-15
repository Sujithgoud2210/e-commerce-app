package com.stschool.ecommerce.model;

import com.stschool.ecommerce.enums.Gender;
import com.stschool.ecommerce.enums.Membership;
import com.stschool.ecommerce.enums.Status;

import java.util.Objects;

public class Customer {

    private String id;
    private String name;
    private String email;
    private String password;
    private int contactNumber;
    private Gender gender;
    private Membership membership;
    private Status status;
    private byte age;
    private Address residentialAddress;
    private Address shippingAddress;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public Customer setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public Customer setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Customer setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Membership getMembership() {
        return membership;
    }

    public Customer setMembership(Membership membership) {
        this.membership = membership;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Customer setStatus(Status status) {
        this.status = status;
        return this;
    }

    public byte getAge() {
        return age;
    }

    public Customer setAge(byte age) {
        this.age = age;
        return this;
    }

    public Address getResidentialAddress() {
        return residentialAddress;
    }

    public Customer setResidentialAddress(Address residentialAddress) {
        this.residentialAddress = residentialAddress;
        return this;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Customer setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return contactNumber == customer.contactNumber && age == customer.age && Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && gender == customer.gender && membership == customer.membership && status == customer.status && Objects.equals(residentialAddress, customer.residentialAddress) && Objects.equals(shippingAddress, customer.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, contactNumber, gender, membership, status, age, residentialAddress, shippingAddress);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber=" + contactNumber +
                ", gender=" + gender +
                ", membership=" + membership +
                ", status=" + status +
                ", age=" + age +
                ", residentialAddress=" + residentialAddress +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
