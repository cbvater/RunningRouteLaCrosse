package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "inArea")

public class InArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;
    private String areaName;

    public Long getAreaId(){return areaId;}
    public String getAreaName(){return areaName;}
}
