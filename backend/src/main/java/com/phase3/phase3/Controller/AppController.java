package com.phase3.phase3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase3.phase3.model.Login;
import com.phase3.phase3.model.Register;
import com.phase3.phase3.service.RegisterServiceImplm;

@RestController
@CrossOrigin("*")
public class AppController {

    @Autowired
    public RegisterServiceImplm rs;

    @PostMapping(value = "/adduser")
    public ResponseEntity<String> signup(@RequestBody Register user) {
        String res = rs.AddUser(user);
        if (res == "Success") {
            return new ResponseEntity<String>("Sucess", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Register> login(@RequestBody Login user) {
        System.out.println(user);
        Register user1 = rs.ShowUser(user.getEmail());
        System.out.println(user1);
        if (user1.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<Register>(user1, HttpStatus.OK);
        }
        return new ResponseEntity("false", HttpStatus.OK);
    }

    @GetMapping(value = "/allUsers")
    public ResponseEntity<List<Register>> showAll() {
        List<Register> users = rs.ShowAllUser();
        if (!users.isEmpty()) {
            return new ResponseEntity<List<Register>>(users,  HttpStatus.OK);
        }
        return new ResponseEntity("Not Found...",  HttpStatus.NOT_FOUND);
    }
}
