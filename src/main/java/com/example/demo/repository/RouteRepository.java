package com.example.demo.repository;

import com.example.demo.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query(value = "SELECT * FROM routes", nativeQuery = true)
    List<Route> findNameOfAllRoutes();

    @Query(value = "SELECT * FROM routes WHERE runner_rating >= :minRating ORDER BY runner_rating DESC", nativeQuery = true)
    List<Route> findTopRated(@Param("minRating") double minRating);

}