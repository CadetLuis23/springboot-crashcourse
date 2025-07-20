package com.example.demo.myfirstapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotBlank(message = "name must not be blank")
    @Size(min = 3, max = 50, message = "name must be 3–50 chars")
    private String name;

    @Min(value = 0, message = "price must be ≥ 0")
    private Double price;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
