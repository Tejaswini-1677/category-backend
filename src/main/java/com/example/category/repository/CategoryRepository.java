package com.example.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

