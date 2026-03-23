package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double distance;
    private String surface;
    private int ftGain;

    @Column(columnDefinition = "TEXT")
    private String routeGeoJson;  // stores the full path as a JSON string

    private Double runnerRating;


    public String getName() { return name; }
    public Double getDistance() { return distance; }
    public Integer getFtGain() { return ftGain; }
    public Double getRunnerRating() { return runnerRating; }
    public String getRouteGeoJson() { return routeGeoJson; }
    public String getSurface() { return surface; }

}
