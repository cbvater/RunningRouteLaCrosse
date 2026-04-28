package com.example.demo.model;

public class RunnerRouteDTO {
    public String runnerName;
    public Double totalMiles;
    public String surface;
    public String areaName;

    public RunnerRouteDTO(String runnerName, Double totalMiles, String surface, String areaName) {
        this.runnerName = runnerName;
        this.totalMiles = totalMiles;
        this.surface = surface;
        this.areaName = areaName;
    }
}
