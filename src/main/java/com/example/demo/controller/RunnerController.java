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

    @GetMapping("/mid-age-mileage")
    public List<RunnerRouteDTO> getMidAgeMileage() {
        return runnerService.getMidAgeMileageRunners();
    }

    @PutMapping("/{id}/pr")
    public Runner updatePR(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        return runnerService.updatePR(id, body.get("pr"));
    }

    @GetMapping("/top-shoes")
    public List<ShoeStatsDTO> getTopShoes() {
        return runnerService.getTopShoesByTerrainRunners();
    }

    // CHUCKS RUNNERS WHO REVIEWED AT LEAST 2 ROUTES, WITH FULL ROUTE AND AREA CONTEXT
    @GetMapping("/active-reviewers")
    public List<RunnerReviewStatsDTO> getActiveReviewers() {
        return runnerService.getActiveReviewers();
    }

}