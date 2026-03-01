package com.example.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.category.entity.Product;
import com.example.category.entity.Category;
import com.example.category.repository.ProductRepository;
import com.example.category.repository.CategoryRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private CategoryRepository categoryRepo;   // ✅ Added

    // 🔥 Create
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    // 🔥 Get All (Only Active Products)
    public List<Product> getAllProducts() {
        return repo.findAll()
                   .stream()
                   .filter(p -> p.getStatus() == true)
                   .toList();
    }

    // 🔥 NEW METHOD (Fix for your error)
    public Category getCategoryById(Integer id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // 🔥 Update
    public Product updateProduct(Integer id, Product newProduct) {
        Product product = repo.findById(id).orElseThrow();

        product.setProductName(newProduct.getProductName());
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());
        product.setSku(newProduct.getSku());
        product.setInventoryCount(newProduct.getInventoryCount());
        product.setCategory(newProduct.getCategory());

        return repo.save(product);
    }

    // 🔥 Soft Delete
    public void deleteProduct(Integer id) {
        Product product = repo.findById(id).orElseThrow();
        product.setStatus(false);
        repo.save(product);
    }
}