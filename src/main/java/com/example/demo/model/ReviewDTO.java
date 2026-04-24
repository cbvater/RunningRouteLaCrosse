package com.example.demo.model;

public class ReviewDTO {
    public String runnerName;
    public String routeName;
    public double rating;
    public String comment;

    public ReviewDTO(Reviews r) {
        this.runnerName = r.getRunner().getRunnerName();
        this.routeName  = r.getRoute().getName();
        this.rating     = r.getRating();
        this.comment    = r.getComment();
    }
}