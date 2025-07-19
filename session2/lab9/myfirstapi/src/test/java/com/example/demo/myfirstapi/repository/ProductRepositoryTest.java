package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void testFindAllWithInitialProducts() {
        List<Product> products = productRepository.findAll();
        assertNotNull(products);
        assertEquals(3, products.size(), "Initial product count should be 3");
    }

    @Test
    void testFindByIdWithExistingProduct() {
        Optional<Product> product = productRepository.findById((long)1);
        assertTrue(product.isPresent());
        assertEquals("Laptop", product.get().getName());
    }

    @Test
    void testFindByIdWithProductNotExist() {
        Optional<Product> product = productRepository.findById((long)999);
        assertFalse(product.isPresent());
    }

    @Test
    void testSaveProductThatAddsNewProductIfNoId() {
        Product newProduct = new Product(null, "Monitor", 300.00);
        Product savedProduct = productRepository.save(newProduct);

        assertNotNull(savedProduct.getId());
        assertEquals("Monitor", savedProduct.getName());

        List<Product> products = productRepository.findAll();
        assertEquals(4, products.size());
        assertTrue(products.stream().anyMatch(p -> "Monitor".equals(p.getName())));
    }

    @Test
    void testSaveProductThatUpdatesProductIfIdExist() {
        Optional<Product> existingProduct = productRepository.findById((long)1);
        assertTrue(existingProduct.isPresent());

        Product productToUpdate = existingProduct.get();
        productToUpdate.setName("Updated Laptop");
        productToUpdate.setPrice(1500.00);

        Product updatedProduct = productRepository.save(productToUpdate);

        assertEquals("Updated Laptop", updatedProduct.getName());
        assertEquals(1500.00, updatedProduct.getPrice());

        Optional<Product> updatedFromRepo = productRepository.findById((long)1);
        assertTrue(updatedFromRepo.isPresent());
        assertEquals("Updated Laptop", updatedFromRepo.get().getName());
    }

    @Test
    void testSaveProductWhenIdIsNotNullButDoesNotExist() {
        Product nonExisting = new Product((long)999, "Ghost", 0.0);
        Product result = productRepository.save(nonExisting);

        assertEquals(999, result.getId());
        assertEquals("Ghost", result.getName());

        // Ensure repository still has original size (3)
        List<Product> products = productRepository.findAll();
        assertEquals(3, products.size(), "Repository size should not change");
    }
}
