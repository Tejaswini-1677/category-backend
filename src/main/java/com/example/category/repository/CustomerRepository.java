package com.example.category.repository;

import com.example.category.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

    Optional<Customer> findByEmail(String email);

}
