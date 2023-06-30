package com.phase3.phase3.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3.phase3.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
