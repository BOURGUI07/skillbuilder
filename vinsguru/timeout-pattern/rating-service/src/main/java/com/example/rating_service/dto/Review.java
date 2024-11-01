package com.example.rating_service.dto;

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
