package com.example.demo.model;

// CONNOR RUNNERS THAT HAVE REVIEWED MORE THAN 2 ROUTES
public class RunnerRouteReviewsDTO {
    public String runnerName;
    public String routeName;
    public Long totalReviews;

    public RunnerRouteReviewsDTO(String runnerName, String routeName, Long totalReviews) {
        this.runnerName = runnerName;
        this.routeName = routeName;
        this.totalReviews = totalReviews;
    }
}
