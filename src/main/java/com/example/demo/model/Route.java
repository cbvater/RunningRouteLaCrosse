package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int distance;
    private String surface;
    private int ftGain;

    @Column(columnDefinition = "TEXT")
    private String routeGeoJson;  // stores the full path as a JSON string

    private double runnerRating;
}
