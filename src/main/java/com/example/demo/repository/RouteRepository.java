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

    // CHUCKS TOP 5 HIGHEST RATED ROUTES QUERY
    @Query(value = """
    SELECT ro.name, AVG(r.rating) AS avg_rating, COUNT(r.review_id) AS review_count
    FROM routes ro
    JOIN reviews r ON ro.id = r.route_id
    GROUP BY ro.id, ro.name
    ORDER BY avg_rating DESC
    LIMIT 5
    """, nativeQuery = true)
    List<Object[]> findTopRatedRoutes();


    // CHUCKS ALL ROUTES REVIEWED BY FAST RUNNERS(sub 20 5k) UNION ROUTES IN AREAS CLOSE TO CAMPUS
    @Query(value = """
    SELECT name, distance, surface, ft_gain
    FROM routes
    WHERE id IN ( SELECT route_id 
                    FROM reviews 
                    WHERE runner_id IN ( SELECT runner_id FROM runner WHERE runner_5kpr < 20 ) ) 
    INTERSECT 
    SELECT name, distance, surface, ft_gain 
    FROM routes 
    WHERE id IN ( SELECT route_id 
                    FROM in_area 
                    WHERE area_id IN ( SELECT area_id 
                                        FROM area 
                                        WHERE miles_from_lax = 0 ) )
    """, nativeQuery = true)
    List<Object[]> reviewedByFast();
}