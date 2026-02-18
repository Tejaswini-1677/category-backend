package com.example.category.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.category.entity.Category;
import com.example.category.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category createCategory(Category category) {
        return repo.save(category);
    }

    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    public Category updateCategory(Integer id, Category newCategory) {
        Category category = repo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setCategoryName(newCategory.getCategoryName());
        category.setDescription(newCategory.getDescription());
        category.setUpdatedAt(java.time.LocalDateTime.now());
        return repo.save(category);
    }

    public void deleteCategory(Integer id) {
        Category category = repo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setStatus(false); // Soft delete
        repo.save(category);
    }
}

