package com.example.category.service;

import org.springframework.stereotype.Service;

import com.example.category.entity.Customer;
import com.example.category.repository.CustomerRepository;

@Service
public class AuthService {

    private final CustomerRepository repo;

    public AuthService(CustomerRepository repo){
        this.repo = repo;
    }

    public Customer register(Customer customer){

        customer.setRole("CUSTOMER");
        customer.setStatus(true);

        return repo.save(customer);
    }

    public Customer login(String email, String password){

        Customer dbUser = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(dbUser.getPassword().equals(password)){
            return dbUser;
        }

        throw new RuntimeException("Invalid Credentials");
    }
}