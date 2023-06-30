package com.phase3.phase3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.phase3.Repo.CartRepo;
import com.phase3.phase3.model.Cart;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepo cr;

    @Override
    public String AddToCart(Cart product) {
        Cart product1 = cr.save(product);
        if (product1 != null) {
            return "Success";
        }
        return "Error";
    }

    @Override
    public List<Cart> ShowProduct(String UserName) {

        return cr.findByUserName(UserName);
    }

    @Override
    public String UpdateCart(Cart product) {
        Cart productUpdated = cr.save(product);
        if (productUpdated != null) {
            return "Success";
        }
        return "Error";
    }

    @Override
    public int Quantity(String name, String userName) {
        List<Cart> product = cr.findByName(name);
        System.out.println(product);

        if (!product.isEmpty()) {
            for (Cart prod : product) {
                if (prod.getUserName().equals(userName)) {
                    return prod.getQuantity();
                }
            }
        }

        // if (product != null) {
        // return product.getQuantity();
        // }
        if (product.isEmpty()) {
            return 1;
        }

        return 1;
    }

    @Override
    public void Delete(Cart product) {
        
        cr.delete(product);
        System.out.println("deleted.!!!!");

    }

}
