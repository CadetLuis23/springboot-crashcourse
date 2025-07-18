package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void createProductWithId() {

        Product testProduct = new Product((long)101, "Mama Sita's Oyster Sauce", 7);
        assertNotNull(testProduct);
        assertEquals(101, testProduct.getId());
        assertEquals("Mama Sita's Oyster Sauce", testProduct.getName());
        assertEquals(7, testProduct.getPrice());
    }

    @Test
    void createProductWithoutId() {
        Product testProduct = new Product("Knorr Magi Magic Sarap", 4);
        assertNotNull(testProduct);
        assertEquals("Knorr Magi Magic Sarap", testProduct.getName());
        assertEquals(4, testProduct.getPrice());
    }

    @Test
    void changeProductId(){
        Product testProduct = new Product((long) 102, "Nestle All-Purpose Cream", 46.75);
        assertEquals( 102, testProduct.getId());
        testProduct.setId((long) 103);
        assertEquals(103, testProduct.getId());
    }

    @Test
    void changeProductName(){
        Product testProduct = new Product((long) 104, "Lucky Me Pancit Canton Chillimansi", 18);
        assertEquals( "Lucky Me Pancit Canton Chillimansi", testProduct.getName());
        testProduct.setName("Lucky Me Pancit Canton Sweet and Spicy");
        assertEquals("Lucky Me Pancit Canton Sweet and Spicy", testProduct.getName());
    }

    @Test
    void changeProductPrice(){
        Product testProduct = new Product((long) 105, "Tender Juicy Jumbo Hotdog", 114);
        assertEquals( 114, testProduct.getPrice());
        testProduct.setPrice(149);
        assertEquals(149, testProduct.getPrice());
    }

    @Test
    void testProductToString(){
        Product testProduct = new Product((long) 105, "Tender Juicy Jumbo Hotdog", 114);
        assertEquals("Product{id=105, name='Tender Juicy Jumbo Hotdog', price=114.0}", testProduct.toString());
    }

    @Test
    void testObjectEqualsTrue() {
        Product testProduct = new Product((long) 105, "Tender Juicy Jumbo Hotdog", 114);
        Product testProductCopy = new Product((long) 105, "Tender Juicy Jumbo Hotdog", 114);
        assertTrue(testProduct.equals(testProduct));
        assertTrue(testProduct.equals(testProductCopy));
    }

    @Test
    void testHashCode(){
        Product testProduct = new Product((long) 105, "Tender Juicy Jumbo Hotdog", 114);
        assertNotNull(testProduct.hashCode());
    }

}