package com.example.demo.service;

import com.example.demo.model.FastRunnersReviewsDTO;
import com.example.demo.model.Route;
import com.example.demo.model.RouteRatingDTO;
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
    public List<FastRunnersReviewsDTO> getFastReviewersRoutes(){
        return routeRepository.reviewedByFast()
                .stream()
                .map(row -> new FastRunnersReviewsDTO(
                        (String) row[0],
                        ((Number) row[1]).doubleValue(),
                        (String) row[2],
                        ((Number) row[3]).intValue()
                        )).collect(Collectors.toList());
    }
}