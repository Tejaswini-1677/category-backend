package com.example.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.category.entity.Review;
import com.example.category.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repo;

    public Review add(Review r) {
        return repo.save(r);
    }

    public List<Review> getApprovedByProduct(Integer productId) {
        return repo.findByProductIdAndStatus(productId, true);
    }

    public Review approve(Integer id) {
        Review r = repo.findById(id).orElseThrow();
        r.setStatus(true);
        return repo.save(r);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}