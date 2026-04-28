package com.example.demo.model;

public class RunnerStatsDTO {
    public String runnerName;
    public String city;
    public String favoriteRoute;
    public Double totalMiles;
    public Integer vo2;

    public RunnerStatsDTO(String runnerName, String city, String favoriteRoute, Double totalMiles, Integer vo2) {
        this.runnerName = runnerName;
        this.city = city;
        this.favoriteRoute = favoriteRoute;
        this.totalMiles = totalMiles;
        this.vo2 = vo2;
    }
}