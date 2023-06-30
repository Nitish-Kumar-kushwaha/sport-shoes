package com.phase3.phase3.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3.phase3.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart , Integer> {
    public List<Cart> findByName(String name);
    public List<Cart>findByUserName(String userName);
}
