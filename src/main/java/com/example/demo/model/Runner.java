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
    private String Runner_Name;
    private int age;
    private int height;
    private int weight;
    private String gender;
    private String city;
    private float Runner_PR;
    private double Total_Miles;
    private int Total_Runs;
    private String Favorite_Route;
    private String Favorite_Terrain;
    private String Physical_Condition;
    private String Shoes_Worn;
    private String Watch_Worn;

    //Creates getter methods
    public String getRunnerName() { return Runner_Name; }
    public int getAge() { return age; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
    public float getRunnerPR() { return Runner_PR; }
    public double getTotalMiles() { return Total_Miles; }
    public int getTotalRuns() { return Total_Runs; }
    public String getFavoriteRoute() { return Favorite_Route; }
    public String getFavoriteTerrain() { return Favorite_Terrain; }
    public String getPhysical_Condition() { return Physical_Condition; }
    public String getShoes_Worn() { return Shoes_Worn; }
    public String getWatch_Worn() { return Watch_Worn; }

}