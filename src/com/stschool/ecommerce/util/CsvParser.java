package com.stschool.ecommerce.util;

import com.stschool.ecommerce.enums.Gender;
import com.stschool.ecommerce.enums.Membership;
import com.stschool.ecommerce.enums.Status;
import com.stschool.ecommerce.model.Address;
import com.stschool.ecommerce.model.Product;
import com.stschool.ecommerce.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class CsvParser {

//   public List<Product> getProductsFromCsv() throws IOException {
//       List<Product> products=new ArrayList<>();
//        File file= new File("C://products.csv");
//        BufferedReader br=new BufferedReader(new FileReader(file));
//        br.readLine();
//        String productData=br.readLine();
//        while(productData!=null){
//            String[] split=productData.split(",");
//            Product product=new Product();
//            product.setId(Integer.parseInt(split[0]))
//                    .setName(split[1])
//                    .setMaxRetailPrice(Double.parseDouble(split[2]))
//                    .setDiscountPercentage(Double.parseDouble(split[3]))
//                    .setAvailable(Boolean.parseBoolean(split[4]))
//                    .setCompany(split[5])
//                    .setCategory(split[6])
//                    .setManufacturedYear(Integer.parseInt(split[7]));
//            products.add(product);
//        }
//        return products;
//    }

    public List<Customer> getCustomersFromCsv() throws IOException {
        List<Customer> customers=new ArrayList<>();
        File file=new File("C://customer.csv");
        BufferedReader br=new BufferedReader(new FileReader(file));
        br.readLine();
        String customerData=br.readLine();
        private Address parseAddress(String addressStr) {
            String[] addr = addressStr.split(":");

            return new Address()
                    .setHouseNo(addr[0])
                    .setStreetName(addr[1])
                    .setArea(addr[2])
                    .setPinCode(Integer.parseInt(addr[3]))
                    .setCity(addr[4])
                    .setDistrict(addr[5])
                    .setCountry(addr[6]);
        }
        while (customerData!=null){
            String[] split=customerData.split(",");
            Customer customer=new Customer();
            customer.setId(split[0])
                    .setName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setContactNumber(Integer.parseInt(split[4]))
                    .setGender(Gender.valueOf(split[5].trim().toUpperCase()))
                    .setMembership(Membership.valueOf(split[6].trim().toUpperCase()))
                    .setStatus(Status.valueOf(split[7].trim().toUpperCase()))
                    .setAge(Byte.parseByte(split[8]))
                    .setResidentialAddress()
        }

        return customers;
    }
}
