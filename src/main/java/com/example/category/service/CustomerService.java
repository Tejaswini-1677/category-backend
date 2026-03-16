package com.example.category.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.category.entity.Customer;
import com.example.category.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo){
        this.repo = repo;
    }

    // register
    public Customer register(Customer c){

        c.setStatus(true);
        c.setRole("CUSTOMER");
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());

        return repo.save(c);
    }

    // get all
    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }

    // get by id
    public Customer getCustomerById(Long id){
        return repo.findById(id).orElseThrow();
    }

    // admin add
    public Customer addCustomer(Customer c){

        c.setStatus(true);
        c.setCreatedAt(LocalDateTime.now());
        c.setUpdatedAt(LocalDateTime.now());

        return repo.save(c);
    }

    // update
    public Customer updateCustomer(Long id, Customer customer){

        Customer existing = repo.findById(id).orElseThrow();

        existing.setFirstName(customer.getFirstName());
        existing.setLastName(customer.getLastName());
        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());

        existing.setUpdatedAt(LocalDateTime.now());

        return repo.save(existing);
    }

    // delete
    public void deleteCustomer(Long id){
        repo.deleteById(id);
    }

    // deactivate
    public Customer deactivate(Long id){

        Customer c = repo.findById(id).orElseThrow();

        c.setStatus(false);

        return repo.save(c);
    }
}