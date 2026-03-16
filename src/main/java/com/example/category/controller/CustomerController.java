package com.example.category.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.category.entity.Customer;
import com.example.category.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    // Get all customers
    @GetMapping
    public List<Customer> getCustomers(){
        return service.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return service.getCustomerById(id);
    }

    // Admin add customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    // Admin update customer
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer customer){
        return service.updateCustomer(id, customer);
    }

    // Admin delete customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
    }

    // deactivate
    @PutMapping("/{id}/deactivate")
    public Customer deactivate(@PathVariable Long id){
        return service.deactivate(id);
    }
}