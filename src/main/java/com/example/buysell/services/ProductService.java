package com.example.buysell.services;

import com.example.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "Iphone 12", "Phone", 32000, "Kiev", "Andrey"));
        products.add(new Product(++ID, "MacBook", "LapTop", 53000, "Odessa", "Igor"));
        products.add(new Product(++ID, "Mazda", "Car", 24000, "Kharkiv", "Vika"));
        products.add(new Product(++ID, "Iphone 14", "Phone", 44000, "Chernigow", "Vasa"));
    }

    public List<Product> listProducts() { return products; }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
