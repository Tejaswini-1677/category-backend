package com.example.category.repository;

import com.example.category.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> findByCustomerId(Integer customerId);
}