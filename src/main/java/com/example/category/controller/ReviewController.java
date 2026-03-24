package com.example.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.category.entity.Review;
import com.example.category.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public Review add(@RequestBody Review r) {
        return service.add(r);
    }

    @GetMapping("/product/{id}")
    public List<Review> getByProduct(@PathVariable Integer id) {
        return service.getApprovedByProduct(id);
    }

    @PutMapping("/approve/{id}")
    public Review approve(@PathVariable Integer id) {
        return service.approve(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}