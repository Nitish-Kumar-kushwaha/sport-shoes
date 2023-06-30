package com.phase3.phase3.service;

import java.util.List;

import com.phase3.phase3.model.Product;

public interface ProductService {
    public String saveProduct(Product prod);
    public List<Product> showProduct();
}
