package com.example.rating_service;

import com.example.rating_service.dto.ProductRating;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @GetMapping("/{productId}")
    public ProductRating getRating(@PathVariable Integer productId) throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(10,10000));
        return ratingService.getRating(productId);
    }
}
