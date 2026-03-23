package com.example.category.service;

import com.example.category.entity.Payment;
import com.example.category.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public Payment createPayment(Payment payment) {
        return repo.save(payment);
    }

    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    public Payment refundPayment(Long id) {
        Payment payment = repo.findById(id).orElseThrow();
        payment.setPaymentStatus("REFUNDED");
        return repo.save(payment);
    }
}
