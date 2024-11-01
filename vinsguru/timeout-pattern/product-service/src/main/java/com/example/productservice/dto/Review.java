package com.example.productservice.dto;

import lombok.Builder;

@Builder
public record Review(
        String firstname,
        String lastname,
        Integer productId,
        Integer rating,
        String comment
) {
}
