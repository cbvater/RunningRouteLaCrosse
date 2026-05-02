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
                                        WHERE miles_from_lax <= :milesFromLax ) )
    """, nativeQuery = true)
    List<Object[]> reviewedByFast(@Param("milesFromLax") int milesFromLax);

    // CONNOR TOP THREE ROUTES WITH MOST REVIEWS
    @Query(value = """
    Select routes.name, routes.surface, avg(routes.runner_rating), count(review_id) as totalReviews
    From routes join reviews on routes.id = reviews.route_id
    Where routes.name Not Like '% %'
    Group by  routes.name, routes.surface
    Order by count(review_id) DESC
    limit :topN;
    """, nativeQuery = true)
    List<Object[]> routesWithMostReviews(@Param("topN") int topN);

    // CONNOR INJURED REVIEWS QUERY
    @Query(value = """
    SELECT r.name, r.ft_gain, r.distance, r.surface
    FROM routes AS r
    WHERE r.id IN (
        SELECT reviews.route_id
        FROM reviews
        WHERE reviews.runner_id IN (
            SELECT runner.runner_id FROM runner WHERE runner.injury = TRUE
        )
        GROUP BY reviews.route_id
        HAVING AVG(reviews.rating) > 5.0
    )
    UNION
    SELECT r.name, r.ft_gain, r.distance, r.surface
    FROM routes AS r
    WHERE r.id IN (
        SELECT reviews.route_id
        FROM reviews
        WHERE reviews.runner_id IN (
            SELECT runner.runner_id FROM runner WHERE runner.injury = FALSE
        )
        GROUP BY reviews.route_id
        HAVING AVG(reviews.rating) > 7.5
    )
    """, nativeQuery = true)
    List<Object[]> findRoutesByInjuryReviews();
}