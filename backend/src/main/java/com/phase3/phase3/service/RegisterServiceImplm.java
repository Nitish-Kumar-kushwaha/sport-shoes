package com.phase3.phase3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.phase3.Repo.RegisterRepo;
import com.phase3.phase3.model.Register;

@Service
public class RegisterServiceImplm implements RegisterService {

    @Autowired
    RegisterRepo rr;

    @Override
    public String AddUser(Register user) {
        Register user1 = rr.save(user);
        if (user1 != null) {
            return "Success";
        }
        return "Error";
    }

    @Override
    public Register ShowUser(String email) {
        System.out.println(email);
        Register user = rr.findByEmail(email);
        System.out.println(user);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public List<Register> ShowAllUser() {
        return rr.findAll();
    }

}
