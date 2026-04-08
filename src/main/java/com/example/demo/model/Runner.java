package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    private int VO2;
    private float Runner_5KPR;
    private double Total_Miles;
    private int Total_Runs;
    private String Favorite_Route;
    private String Favorite_Terrain;
    private Boolean injury;
    private String Shoes_Worn;
    private String Watch_Worn;

    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reviews> reviews = new ArrayList<>();

    public List<Reviews> getReviews() { return reviews; }

    //Creates getter methods
    public String getRunnerName() { return Runner_Name; }
    public int getAge() { return age; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
    public int getVO2() { return VO2; }
    public float getRunner5KPR() { return Runner_5KPR; }
    public double getTotalMiles() { return Total_Miles; }
    public int getTotalRuns() { return Total_Runs; }
    public String getFavoriteRoute() { return Favorite_Route; }
    public String getFavoriteTerrain() { return Favorite_Terrain; }
    public Boolean getInjury() { return injury; }
    public String getShoes_Worn() { return Shoes_Worn; }
    public String getWatch_Worn() { return Watch_Worn; }
    public Long getRunnerId() { return RunnerId; }
}