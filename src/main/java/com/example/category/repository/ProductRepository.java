package com.example.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.category.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}