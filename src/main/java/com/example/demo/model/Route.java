package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RouteId;

    private String name;

    private double distance;
    private String surface;
    private int ftGain;
    private int minFromCampus;

    @Column(columnDefinition = "TEXT")
    private String routeGeoJson;  // stores the full path as a JSON string

    private Double runnerRating;

    @OneToOne(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private InArea inArea;

    public InArea getInArea() { return inArea; }
    public Area getArea() { return inArea != null ? inArea.getArea() : null; }

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public List<Review> getReviews() { return reviews; }

    public String getName() { return name; }
    public Double getDistance() { return distance; }
    public Integer getFtGain() { return ftGain; }
    public Double getRunnerRating() { return runnerRating; }
    public String getRouteGeoJson() { return routeGeoJson; }
    public String getSurface() { return surface; }
    public Long getId() { return RouteId; }
    public int getMinFromCampus() {return minFromCampus; }

}
