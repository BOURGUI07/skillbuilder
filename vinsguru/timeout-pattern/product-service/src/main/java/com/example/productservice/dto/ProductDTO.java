package com.example.productservice.dto;

import lombok.Builder;

@Builder
public record ProductDTO(
        Integer productId,
        String description,
        Double price,
        ProductRating productRating
) {
}
