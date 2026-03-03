package com.example.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}