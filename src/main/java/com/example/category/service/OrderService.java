package com.example.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.category.entity.Order;
import com.example.category.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order placeOrder(Order order) {
        return repo.save(order);
    }

    public List<Order> getAllOrders() {
        return repo.findAll()
                .stream()
                .filter(o -> o.getStatus())
                .toList();
    }

    public Order updateStatus(Integer id, String status) {
        Order order = repo.findById(id).orElseThrow();
        order.setOrderStatus(status);
        return repo.save(order);
    }

    public void cancelOrder(Integer id) {
        Order order = repo.findById(id).orElseThrow();
        order.setOrderStatus("Cancelled");
        order.setStatus(false);
        repo.save(order);
    }
}
