package com.example.demo.controller;

import com.example.demo.model.Runner;
import com.example.demo.model.ShoeStatsDTO;
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

    @PutMapping("/{id}/pr")
    public Runner updatePR(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        return runnerService.updatePR(id, body.get("pr"));
    }

    @GetMapping("/top-shoes")
    public List<ShoeStatsDTO> getTopShoes() {
        return runnerService.getTopShoesByTerrainRunners();
    }
}