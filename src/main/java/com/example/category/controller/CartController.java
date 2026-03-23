package com.example.category.controller;

import com.example.category.entity.Cart;
import com.example.category.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping
    public Cart add(@RequestBody Cart cart) {
        return service.addToCart(cart);
    }

    @GetMapping
    public List<Cart> getAll() {
        return service.getAllCartItems();
    }

    @PutMapping("/{id}")
    public Cart update(@PathVariable Long id, @RequestBody Cart cart) {
        return service.updateCart(id, cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCart(id);
    }
}