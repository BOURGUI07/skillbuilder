package com.example.rating_service.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ProductRating(
        Double averageRating,
        List<Review> reviews
) {
}
