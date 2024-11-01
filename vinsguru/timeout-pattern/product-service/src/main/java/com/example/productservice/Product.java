package com.example.productservice;

public record Product(
        Integer productId,
        String description,
        Double price
) {
}
