package com.example.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.category.entity.Coupon;
import com.example.category.repository.CouponRepository;

@Service
public class CouponService {

    @Autowired
    private CouponRepository repo;

    public Coupon create(Coupon c) {
        return repo.save(c);
    }

    public List<Coupon> getAll() {
        return repo.findAll();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
