package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routeId")
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "runnerId")
    private Runner runner;

    private double rating;
    private String comment;

    public Long getReviewId() { return reviewId; }
    public Route getRoute() { return route; }
    public Runner getRunner() { return runner; }
    public double getRating() { return rating; }
    public String getComment() { return comment; }
    public Long getRouteId() { return route != null ? route.getId() : null; }
    public Long getRunnerId() { return runner != null ? runner.getRunnerId() : null; }
}

