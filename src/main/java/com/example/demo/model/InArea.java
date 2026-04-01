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
    public Long getAreaId() { return area != null ? area.getAreaId() : null; }
    public Long getRouteId() { return route != null ? route.getId() : null; }

}
