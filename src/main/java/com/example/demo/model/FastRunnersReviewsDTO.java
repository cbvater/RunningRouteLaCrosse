package com.example.demo.model;

public class FastRunnersReviewsDTO {
    public String name;
    public double distance;
    public String surface;
    public int ft_gain;

    public FastRunnersReviewsDTO(String name, double distance, String surface, int ft_gain) {
        this.distance = distance;
        this.name = name;
        this.surface = surface;
        this.ft_gain = ft_gain;
    }
}
