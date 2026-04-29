package com.example.demo.model;

// CHUCKS RUNNERS WHO REVIEWED AT LEAST 2 ROUTES, WITH FULL ROUTE AND AREA CONTEXT
public class RunnerReviewStatsDTO {
    public String runnerName;
    public String areaName;
    public Long reviewsWritten;
    public Double avgGivenRating;

    public RunnerReviewStatsDTO(String runnerName, String areaName, Long reviewsWritten, Double avgGivenRating) {
        this.runnerName = runnerName;
        this.areaName = areaName;
        this.reviewsWritten = reviewsWritten;
        this.avgGivenRating = avgGivenRating;
    }
}
