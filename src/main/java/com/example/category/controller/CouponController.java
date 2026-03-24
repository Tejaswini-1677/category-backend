package com.example.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.category.entity.Coupon;
import com.example.category.service.CouponService;

@RestController
@RequestMapping("/api/coupons")
@CrossOrigin("*")
public class CouponController {

    @Autowired
    private CouponService service;

    @PostMapping
    public Coupon create(@RequestBody Coupon c) {
        return service.create(c);
    }

    @GetMapping
    public List<Coupon> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}