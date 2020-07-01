package com.healthmgmt.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.healthmgmt.app.dao.ProductRepository;
import com.healthmgmt.app.dao.UserRepository;
import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.Appuser;

@Service
public class LoginService {

    @Autowired
    private UserRepository repo;
	
    public boolean validateUser(String userid, String password) {
        //default login
        return userid.equalsIgnoreCase("test")
                && password.equalsIgnoreCase("test");
    }

    public Appuser checkUser(String uname) {
        return repo.findByusername(uname);
    }
}