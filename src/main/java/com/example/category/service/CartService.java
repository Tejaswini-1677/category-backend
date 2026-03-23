package com.example.category.service;

import com.example.category.entity.Cart;
import com.example.category.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    public Cart addToCart(Cart cart) {
        return repo.save(cart);
    }

    public List<Cart> getAllCartItems() {
        return repo.findAll();
    }

    public Cart updateCart(Long id, Cart updated) {
        Cart cart = repo.findById(id).orElseThrow();
        cart.setQuantity(updated.getQuantity());
        cart.setTotalPrice(updated.getTotalPrice());
        return repo.save(cart);
    }

    public void deleteCart(Long id) {
        repo.deleteById(id);
    }
}