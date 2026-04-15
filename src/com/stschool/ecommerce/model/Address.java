package com.stschool.ecommerce.model;

import java.util.Objects;

public class Address {
    private String houseNo;
    private String streetName;
    private String area;
    private int pinCode;
    private String city;
    private String district;
    private String country;

    public Address() {
    }

    public String getHouseNo() {
        return houseNo;
    }

    public Address setHouseNo(String houseNo) {
        this.houseNo = houseNo;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public Address setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getArea() {
        return area;
    }

    public Address setArea(String area) {
        this.area = area;
        return this;
    }

    public int getPinCode() {
        return pinCode;
    }

    public Address setPinCode(int pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Address setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return pinCode == address.pinCode && Objects.equals(houseNo, address.houseNo) && Objects.equals(streetName, address.streetName) && Objects.equals(area, address.area) && Objects.equals(city, address.city) && Objects.equals(district, address.district) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNo, streetName, area, pinCode, city, district, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo='" + houseNo + '\'' +
                ", streetName='" + streetName + '\'' +
                ", area='" + area + '\'' +
                ", pinCode=" + pinCode +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
