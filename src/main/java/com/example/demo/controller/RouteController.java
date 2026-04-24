package com.example.demo.controller;

import com.example.demo.model.Route;
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

    @GetMapping("/top-rated")
    public List<Route> getTopRated(@RequestParam double minRating) {
        return routeService.getTopRatedRoutes(minRating);
    }
}