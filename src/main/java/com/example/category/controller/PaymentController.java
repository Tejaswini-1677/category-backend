package com.example.category.controller;

import com.example.category.entity.Payment;
import com.example.category.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return service.createPayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @PutMapping("/{id}/refund")
    public Payment refundPayment(@PathVariable Long id) {
        return service.refundPayment(id);
    }
}