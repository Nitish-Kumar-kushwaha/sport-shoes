package com.phase3.phase3.service;

import java.util.List;

import com.phase3.phase3.model.Cart;

public interface CartService {
    public String AddToCart(Cart product);

    public List<Cart> ShowProduct( String userName);

    public String UpdateCart(Cart product);

    public int Quantity(String name, String userName);

    public void Delete(Cart product);
}
