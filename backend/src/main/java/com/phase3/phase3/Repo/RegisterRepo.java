package com.phase3.phase3.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3.phase3.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer> {
    public Register findByEmail(String email); 

}
