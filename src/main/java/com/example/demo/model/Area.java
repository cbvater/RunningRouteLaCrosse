package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InArea> inAreas = new ArrayList<>();

    public List<InArea> getInAreas() { return inAreas; }

    private String description;
    private String AreaName;
    private int milesFromLax;
    private int zipCode;
    private String county;
    private String state;

    public Long getAreaId() { return areaId; }
    public String getDescription() { return description; }
    public String getAreaName() { return AreaName; }
    public int getMilesFromLax() { return milesFromLax; }
    public int getZipcode() { return zipCode; }
    public String getCounty() { return county; }
    public String getState() { return state; }
}
