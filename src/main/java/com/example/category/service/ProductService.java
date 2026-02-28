package com.example.category.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.category.entity.Product;
import com.example.category.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product createProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll()
                   .stream()
                   .filter(p -> p.getStatus() == true)
                   .toList();
    }

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

    public void deleteProduct(Integer id) {
        Product product = repo.findById(id).orElseThrow();
        product.setStatus(false);  // Soft delete
        repo.save(product);
    }
}