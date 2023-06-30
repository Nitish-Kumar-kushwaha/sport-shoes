package com.phase3.phase3.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase3.phase3.model.Product;
import com.phase3.phase3.service.ProductServiceImpl;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    public ProductServiceImpl ps;

    @PostMapping(value = "/product/add")
    public ResponseEntity<String> add(@RequestBody Product prod) {
        String res = ps.saveProduct(prod);
        if (res != "Error") {
            return new ResponseEntity<String>("Product Added", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Product not Added", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/product/show")
    public ResponseEntity<List<Product>> show() {
        System.out.println("enterd in show");
        List<Product> Prod = ps.showProduct();
        System.out.println(Prod);
        if (!Prod.isEmpty()) {
            return new ResponseEntity<List<Product>>(Prod, HttpStatus.OK);
        }
        return new ResponseEntity("Something gone wrong", HttpStatus.NOT_FOUND);

    }

}
