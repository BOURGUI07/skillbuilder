package com.example.rating_service;

import com.example.rating_service.dto.ProductRating;
import com.example.rating_service.dto.Review;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RatingService {
    private Map<Integer, ProductRating> map;

    @PostConstruct
    public void init() {
        var productRating1 = ProductRating.builder()
                .averageRating(4.5)
                .reviews(
                        List.of(Review.builder()
                                        .rating(4)
                                        .productId(1)
                                        .comment("good")
                                        .firstname("youness")
                                        .lastname("bourgui")
                                .build(),
                                Review.builder()
                                        .rating(5)
                                        .productId(1)
                                        .comment("good")
                                        .firstname("sara")
                                        .lastname("hoko")
                                        .build()
                                )
                ).build();

        var productRating2 = ProductRating.builder()
                .averageRating(2.5)
                .reviews(
                        List.of(Review.builder()
                                        .rating(2)
                                        .productId(2)
                                        .comment("bad")
                                        .firstname("youness")
                                        .lastname("bourgui")
                                        .build(),
                                Review.builder()
                                        .rating(3)
                                        .productId(2)
                                        .comment("bad")
                                        .firstname("sara")
                                        .lastname("hoko")
                                        .build()
                        )
                ).build();

        this.map = Map.of(1,productRating1,2,productRating2);

    }

    public ProductRating getRating(int productId) {
        return map.getOrDefault(productId, ProductRating.builder().build());
    }
}
