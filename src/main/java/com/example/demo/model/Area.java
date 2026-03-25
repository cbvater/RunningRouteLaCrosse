package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AreaId;

    private String description;
    private String AreaName;
    private int distFromLax;

    public String getDescription() { return description; }
    public String getAreaName() { return AreaName; }
    public int getDistFromLax() { return distFromLax; }
}
