package com.example.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.category.entity.Category;
import com.example.category.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.createCategory(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAllCategories();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteCategory(id);
    }
}

