package com.example.demo.model;

public class ShoeStatsDTO {
    public String shoesWorn;
    public Long runnerCount;
    public Double avg5kPr;
    public Double avgVo2;
    public Double avgTotalMiles;

    public ShoeStatsDTO(String shoesWorn, Long runnerCount, Double avg5kPr, Double avgVo2, Double avgTotalMiles) {
        this.shoesWorn = shoesWorn;
        this.runnerCount = runnerCount;
        this.avg5kPr = avg5kPr;
        this.avgVo2 = avgVo2;
        this.avgTotalMiles = avgTotalMiles;
    }
}