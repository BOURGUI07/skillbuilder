package com.example.productservice;

import com.example.productservice.dto.ProductRating;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

@Service
public class RatingServiceClient {

    @Value("${rating.service.endpoint}")
    private String ratingServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @TimeLimiter(name = "ratingService", fallbackMethod = "getDefault")
    public CompletionStage<ProductRating> getProductRatingDto(int productId){
        Supplier<ProductRating> supplier = () ->
                this.restTemplate.getForEntity(this.ratingServiceUrl + productId, ProductRating.class)
                        .getBody();
        return CompletableFuture.supplyAsync(supplier);
    }

    private CompletionStage<ProductRating> getDefault(int productId, Throwable throwable){
        return CompletableFuture.supplyAsync(() -> new ProductRating(0.0, Collections.emptyList()));
    }
}
