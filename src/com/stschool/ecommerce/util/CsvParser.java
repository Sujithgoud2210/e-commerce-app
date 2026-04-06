package com.stschool.ecommerce.util;

import com.stschool.ecommerce.model.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

   public List<Product> getProductsFromCsv() throws IOException {
       List<Product> products=new ArrayList<>();
        File file= new File("C://products.csv");
        BufferedReader br=new BufferedReader(new FileReader(file));
        br.readLine();
        String productData=br.readLine();
        while(productData!=null){
            String[] split=productData.split(",");
            Product product=new Product();
            product.setId(Integer.parseInt(split[0]))
                    .setName(split[1])
                    .setMaxRetailPrice(Double.parseDouble(split[2]))
                    .setDiscountPercentage(Double.parseDouble(split[3]))
                    .setAvailable(Boolean.parseBoolean(split[4]))
                    .setCompany(split[5])
                    .setCategory(split[6])
                    .setManufacturedYear(Integer.parseInt(split[7]));
            products.add(product);
        }
        return products;
    }
}
