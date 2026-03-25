package com.example.demo.model;

import jakarta.persistence.*;

//Creates table
@Entity
@Table(name = "runner")
public class Runner {

    //Creates table key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RunnerId;

    //Creates variables
    private String RunnerName;
    private float RunnerPR;
    private double TotalMiles;
    private int TotalRuns;
    private String FavoriteRoute;
    private String FavoriteTerrain;

    //Creates getter methods
    public String getRunnerName() { return RunnerName; }
    public float getRunnerPR() { return RunnerPR; }
    private double getTotalMiles() { return TotalMiles; }
    private int getTotalRuns() { return TotalRuns; }
    private String getFavoriteRoute() { return FavoriteRoute; }
    private String getFavoriteTerrain() { return FavoriteTerrain; }

}
