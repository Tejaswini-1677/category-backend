package com.example.category.controller;

import com.example.category.entity.Wishlist;
import com.example.category.repository.WishlistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin("*")
public class WishlistController {

    private final WishlistRepository repo;

    public WishlistController(WishlistRepository repo) {
        this.repo = repo;
    }

    // Add to wishlist
    @PostMapping
    public Wishlist add(@RequestBody Wishlist wishlist) {
        return repo.save(wishlist);
    }

    // Get wishlist by customer
    @GetMapping("/{customerId}")
    public List<Wishlist> getByCustomer(@PathVariable Integer customerId) {
        return repo.findByCustomerId(customerId);
    }

    // Remove item
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}