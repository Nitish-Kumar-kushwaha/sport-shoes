package com.phase3.phase3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RegisterUser")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(unique = true)
    private String email;
    private String userName;
    private String password;
    private String confirmPassword;

    public Register(String email, String userName, String password, String confirmPassword) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Register() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
