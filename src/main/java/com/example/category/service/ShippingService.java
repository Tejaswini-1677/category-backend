package com.example.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.category.entity.Shipping;
import com.example.category.repository.ShippingRepository;


@Service
public class ShippingService {

    @Autowired
    private ShippingRepository repo;

    public Shipping create(Shipping s) {
        return repo.save(s);
    }

    public List<Shipping> getAll() {
        return repo.findAll();
    }

    public Shipping update(Integer id, Shipping s) {
        Shipping existing = repo.findById(id).orElseThrow();
        existing.setCourierService(s.getCourierService());
        existing.setTrackingNumber(s.getTrackingNumber());
        existing.setShippingStatus(s.getShippingStatus());
        existing.setShippingCost(s.getShippingCost());
        return repo.save(existing);
    }
}
