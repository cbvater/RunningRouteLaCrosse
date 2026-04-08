package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "inArea")

public class InArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inAreaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "areaId")
    private Area area;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routeId")
    private Route route;

    public Long getInAreaId() { return inAreaId; }
    public Area getArea() { return area; }
    public Route getRoute() { return route; }
    public Long getAreaId() { if(area != null){return area.getAreaId();}else{return null;} }
    public Long getRouteId() { if(route != null){return route.getId();}else{return null;} }

}
