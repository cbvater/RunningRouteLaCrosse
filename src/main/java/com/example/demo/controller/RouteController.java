package com.example.demo.controller;

import com.example.demo.model.FastRunnersReviewsDTO;
import com.example.demo.model.Route;
import com.example.demo.model.RouteRatingDTO;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }


    // CHUCKS TOP 5 HIGHEST RATED ROUTES QUERY
    @GetMapping("/top-rated-summary")
    public List<RouteRatingDTO> getTopRatedSummary() {
        return routeService.getTopRatedRoutes();
    }

    @GetMapping("/fast-reviewers-routes")
    public List<FastRunnersReviewsDTO> getFastReviewersRoutes() {
        return routeService.getFastReviewersRoutes();
    }
}