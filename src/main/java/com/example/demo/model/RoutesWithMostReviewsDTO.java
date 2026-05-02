package com.example.demo.model;


// CONNOR TOP THREE ROUTES WITH MOST REVIEWS
public class RoutesWithMostReviewsDTO {
    public String name;
    public String surface;
    public Double ratingAvg;
    public int count;

    public RoutesWithMostReviewsDTO(String name, String surface, Double ratingAvg, int count) {
        this.name = name;
        this.surface = surface;
        this.ratingAvg = ratingAvg;
        this.count = count;
    }
}
