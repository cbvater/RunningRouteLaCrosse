package com.example.demo.model;


// CHUCKS TOP 5 HIGHEST RATED ROUTES QUERY
public class RouteRatingDTO {
    public String name;
    public Double avgRating;
    public Long reviewCount;

    public RouteRatingDTO(String name, Double avgRating, Long reviewCount) {
        this.name = name;
        this.avgRating = avgRating;
        this.reviewCount = reviewCount;
    }
}