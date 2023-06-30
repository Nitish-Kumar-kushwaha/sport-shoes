package com.phase3.phase3.service;

import java.util.List;

import com.phase3.phase3.model.Register;

public interface RegisterService {

    public String AddUser(Register user);

    public Register ShowUser(String email);

    public List<Register> ShowAllUser();

}
