package com.example.category.controller;
import com.cloudinary.Cloudinary;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.category.entity.Product;
import com.example.category.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private Cloudinary cloudinary;

    @Autowired
    private ProductService service;

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public Product addProduct(
            @RequestParam String productName,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam Integer inventoryCount,
            @RequestParam Integer categoryId,
            @RequestParam MultipartFile image
    ) throws Exception {

        // Upload image to Cloudinary
        Map uploadResult = cloudinary.uploader()
                .upload(image.getBytes(), Map.of());

        String imageUrl = uploadResult.get("secure_url").toString();

        // Create Product
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setInventoryCount(inventoryCount);
        product.setImageUrl(imageUrl);
        product.setStatus(true);

        // Set Category properly from DB
        product.setCategory(
                service.getCategoryById(categoryId)
        );

        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteProduct(id);
    }
}
