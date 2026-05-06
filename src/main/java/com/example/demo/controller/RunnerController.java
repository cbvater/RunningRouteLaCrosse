package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/runners")
@CrossOrigin(origins = "*")
public class RunnerController {

    @Autowired
    private RunnerService runnerService;

    @GetMapping
    public List<Runner> getAllRunners() {
        return runnerService.getAllRunners();
    }

    @GetMapping("/high-elevation-or-above-avg")
    public List<RunnerStatsDTO> getHighElevationOrAboveAvg() {
        return runnerService.getHighElevationOrAboveAvgRunners();
    }

    // JOHNSON QUERY 2
    @GetMapping("/mid-age-mileage")
    public List<RunnerRouteDTO> getMidAgeMileage(@RequestParam double minMiles) {
        return runnerService.getMidAgeMileageRunners(minMiles);
    }

    // UPDATE
    @PutMapping("/{id}/pr")
    public Runner updatePR(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        return runnerService.updatePR(id, body.get("pr"));
    }

    // LOGAN QUERRY 1
    @GetMapping("/top-shoes")
    public List<ShoeStatsDTO> getTopShoes() {
        return runnerService.getTopShoesByTerrainRunners();
    }

    // CHUCKS RUNNERS WHO REVIEWED AT LEAST 2 ROUTES, WITH FULL ROUTE AND AREA CONTEXT
    @GetMapping("/active-reviewers")
    public List<RunnerReviewStatsDTO> getActiveReviewers() {
        return runnerService.getActiveReviewers();
    }

    // CONNOR RUNNERS THAT HAVE REVIEWED MORE THAN 2 ROUTES
    @GetMapping("/runners-with-multiple-reviews")
    public List<RunnerRouteReviewsDTO> getRunnersWithMultipleReviews() {
        return runnerService.getRunnersWithMultipleReviews();
    }
}