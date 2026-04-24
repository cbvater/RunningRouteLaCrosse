package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "routeId")
    private Route route;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "runnerId")
    private Runner runner;

    private double rating;
    private String comment;

    public Long getReviewId() {
        return reviewId;
    }

    public Route getRoute() {
        return route;
    }

    public Runner getRunner() {
        return runner;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Long getRouteId() {
        if (route != null) {
            return route.getId();
        } else {
            return null;
        }
    }

    public Long getRunnerId() {
        if (runner != null) {
            return runner.getRunnerId();
        } else {
            return null;
        }
    }
    public void setRoute(Route route) { this.route = route; }
    public void setRunner(Runner runner) { this.runner = runner; }
    public void setRating(double rating) { this.rating = rating; }
    public void setComment(String comment) { this.comment = comment; }
}

