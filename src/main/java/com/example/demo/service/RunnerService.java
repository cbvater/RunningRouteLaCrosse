package com.example.demo.service;

import com.example.demo.model.Runner;
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
}