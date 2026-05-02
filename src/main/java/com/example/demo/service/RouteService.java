package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }


    // CHUCKS TOP 5 HIGHEST RATED ROUTES QUERY
    public List<RouteRatingDTO> getTopRatedRoutes() {
        return routeRepository.findTopRatedRoutes()
                .stream()
                .map(row -> new RouteRatingDTO(
                        (String) row[0],
                        ((Number) row[1]).doubleValue(),
                        ((Number) row[2]).longValue()
                ))
                .collect(Collectors.toList());
    }

    // CHUCKS FAST RUNNER REVIEWS FOR ROUTES CLOSE TO CAMPUS
    public List<FastRunnersReviewsDTO> getFastReviewersRoutes(int milesFromLax){
        return routeRepository.reviewedByFast(milesFromLax)
                .stream()
                .map(row -> new FastRunnersReviewsDTO(
                        (String) row[0],
                        ((Number) row[1]).doubleValue(),
                        (String) row[2],
                        ((Number) row[3]).intValue()
                        )).collect(Collectors.toList());
    }

    // CONNOR TOP THREE ROUTES WITH MOST REVIEWS
    public List<RoutesWithMostReviewsDTO> getRoutesWithMostReviews(int topN) {
        return routeRepository.routesWithMostReviews(topN)
                .stream()
                .map(row -> new RoutesWithMostReviewsDTO(
                        (String) row[0],
                        (String) row[1],
                        ((Number) row[2]).doubleValue(),
                        ((Number) row[3]).intValue()
                        )).collect(Collectors.toList());
    }

    public List<InjuredReviewRouteDTO> getRoutesByInjuryReviews() {
        return routeRepository.findRoutesByInjuryReviews()
                .stream()
                .map(row -> new InjuredReviewRouteDTO(
                        (String) row[0],
                        ((Number) row[1]).intValue(),
                        ((Number) row[2]).doubleValue(),
                        (String) row[3]
                ))
                .collect(Collectors.toList());
    }
}