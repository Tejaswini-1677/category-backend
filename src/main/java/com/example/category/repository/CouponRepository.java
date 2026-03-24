package com.example.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}