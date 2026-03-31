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
    private int milesFromLax;
    private int zipCode;
    private String county;
    private String state;

    public String getDescription() { return description; }
    public String getAreaName() { return AreaName; }
    public int getMilesFromLax() { return milesFromLax; }
    public int getZipcode() { return zipCode; }
    public String getCounty() { return county; }
    public String getState() { return state; }
}
