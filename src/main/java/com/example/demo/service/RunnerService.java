package com.example.demo.service;

import com.example.demo.model.Runner;
import com.example.demo.model.RunnerRouteDTO;
import com.example.demo.model.RunnerStatsDTO;
import com.example.demo.model.ShoeStatsDTO;
import com.example.demo.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RunnerService {

    @Autowired
    private RunnerRepository runnerRepository;

    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

    public Runner updatePR(Long id, Double pr) {
        Runner runner = runnerRepository.findById(id).orElseThrow();
        runner.setRunner5KPR(pr.floatValue());
        return runnerRepository.save(runner);
    }

    public List<RunnerRouteDTO> getMidAgeMileageRunners() {
        return runnerRepository.findMidAgeMileageRunners()
                .stream()
                .map(row -> new RunnerRouteDTO(
                        (String) row[0],
                        ((Number) row[1]).doubleValue(),
                        (String) row[2],
                        (String) row[3]
                ))
                .collect(Collectors.toList());
    }

    public List<ShoeStatsDTO> getTopShoesByTerrainRunners() {
        return runnerRepository.findTopShoesByTerrainRunners()
                .stream()
                .map(row -> new ShoeStatsDTO(
                        (String) row[0],
                        ((Number) row[1]).longValue(),
                        ((Number) row[2]).doubleValue(),
                        ((Number) row[3]).doubleValue(),
                        ((Number) row[4]).doubleValue()
                ))
                .collect(Collectors.toList());
    }

    public List<RunnerStatsDTO> getHighElevationOrAboveAvgRunners() {
        return runnerRepository.findHighElevationOrAboveAvgRunners()
                .stream()
                .map(row -> new RunnerStatsDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        ((Number) row[3]).doubleValue(),
                        ((Number) row[4]).intValue()
                ))
                .collect(Collectors.toList());
    }
}