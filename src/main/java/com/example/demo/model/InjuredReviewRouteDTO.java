package com.example.demo.model;

// CONNOR INJURED REVIEWS QUERY
public class InjuredReviewRouteDTO {
    public String name;
    public int ftGain;
    public Double distance;
    public String surface;

    public InjuredReviewRouteDTO(String name, int ftGain, Double distance, String surface) {
        this.name = name;
        this.ftGain = ftGain;
        this.distance = distance;
        this.surface = surface;
    }
}