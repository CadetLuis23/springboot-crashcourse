package com.example.demo.myfirstapi.controller;

import com.example.demo.myfirstapi.dto.ProductRequest;
import com.example.demo.myfirstapi.model.Product;
import com.example.demo.myfirstapi.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product p = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Product not found with id " + id
                ));
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequest req) {
        Product newProduct = new Product(req.getName(), req.getPrice());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
