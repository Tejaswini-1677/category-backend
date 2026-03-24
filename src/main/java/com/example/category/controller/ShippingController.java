package com.example.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.category.entity.Shipping;
import com.example.category.service.ShippingService;

@RestController
@RequestMapping("/api/shipping")
@CrossOrigin("*")
public class ShippingController {

    @Autowired
    private ShippingService service;

    @PostMapping
    public Shipping create(@RequestBody Shipping s) {
        return service.create(s);
    }

    @GetMapping
    public List<Shipping> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Shipping update(@PathVariable Integer id, @RequestBody Shipping s) {
        return service.update(id, s);
    }
}