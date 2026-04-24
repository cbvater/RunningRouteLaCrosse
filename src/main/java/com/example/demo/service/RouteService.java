package com.example.demo.service;

import com.example.demo.model.Route;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Route> getTopRatedRoutes(double minRating) {
        return routeRepository.findTopRated(minRating);
    }
}