package com.example.category.controller;

import org.springframework.web.bind.annotation.*;

import com.example.category.entity.Customer;
import com.example.category.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer){
        return service.register(customer);
    }

    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer){
        return service.login(customer.getEmail(), customer.getPassword());
    }
}