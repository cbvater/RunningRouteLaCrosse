package com.example.demo.controller;

import com.example.demo.model.*;
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

    // CHUCK REVIEWED ROUTES BY FASTEST RUNNERS QUERY
    @GetMapping("/fast-reviewers-routes")
    public List<FastRunnersReviewsDTO> getFastReviewersRoutes(@RequestParam int milesFromLax) {
        return routeService.getFastReviewersRoutes(milesFromLax);
    }

    // CONNOR TOP THREE ROUTES WITH MOST REVIEWS
    @GetMapping("/most-reviews-routes")
    public List<RoutesWithMostReviewsDTO> getRoutesWithMostReviews(@RequestParam int topN){
        return routeService.getRoutesWithMostReviews(topN);
    }

    @GetMapping("/injury-reviewed-routes")
    public List<InjuredReviewRouteDTO> getRoutesByInjuryReviews() {
        return routeService.getRoutesByInjuryReviews();
    }
}