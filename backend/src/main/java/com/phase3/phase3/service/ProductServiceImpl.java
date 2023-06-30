package com.phase3.phase3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.phase3.Repo.ProductRepo;
import com.phase3.phase3.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo pr;

    @Override
    public String saveProduct(Product prod) {
        Product prod1 = pr.save(prod);
        if (prod1 != null) {
            return "Success";
        }
        return "Error";
    }

    @Override
    public List<Product> showProduct() {
        return pr.findAll();
    }

}
