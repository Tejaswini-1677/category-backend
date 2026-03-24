package com.example.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductIdAndStatus(Integer productId, Boolean status);
}