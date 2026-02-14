package com.example.ecommerce.dao;

import java.util.List;

import com.example.ecommerce.model.Product;

public interface ProductDAO {
    void save(Product product);
    Product findById(Long id);
    List<Product> findAll();
}

