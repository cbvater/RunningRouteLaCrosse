package com.example.demo.repository;

import com.example.demo.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long> {

    @Query(value = """
    SELECT r.shoes_worn,
           COUNT(*) AS runner_count,
           AVG(r.runner_5kpr) AS avg_5k_pr,
           AVG(r.vo2) AS avg_vo2,
           AVG(r.total_miles) AS avg_total_miles
    FROM runner r
    WHERE r.favorite_terrain ILIKE 'gravel'
       OR r.favorite_terrain ILIKE 'dirt'
    GROUP BY r.shoes_worn
    ORDER BY avg_5k_pr ASC
    LIMIT 5
    """, nativeQuery = true)
    List<Object[]> findTopShoesByTerrainRunners();

    @Query(value = """
    SELECT r.runner_name, r.total_miles, ro.surface, a.area_name
    FROM runner r
    LEFT OUTER JOIN routes ro ON r.favorite_route = ro.name
    LEFT OUTER JOIN in_area ia ON ro.id = ia.route_id
    LEFT OUTER JOIN area a ON ia.area_id = a.area_id
    WHERE r.age BETWEEN 18 AND 40
    GROUP BY r.runner_name, r.total_miles, ro.surface, a.area_name
    HAVING r.total_miles > 200
    ORDER BY r.total_miles DESC
    OFFSET 5
    """, nativeQuery = true)
    List<Object[]> findMidAgeMileageRunners();

    @Query(value = """
    SELECT r.runner_name, r.city, r.favorite_route, r.total_miles, r.vo2
    FROM runner r
    WHERE r.favorite_route IN (
        SELECT ro.name FROM routes ro WHERE ro.ft_gain > 800
    )
    UNION
    SELECT r.runner_name, r.city, r.favorite_route, r.total_miles, r.vo2
    FROM runner r
    WHERE r.total_miles > (
        SELECT AVG(r2.total_miles) FROM runner r2 WHERE r2.city = r.city
    )
    ORDER BY city, total_miles DESC
    """, nativeQuery = true)
    List<Object[]> findHighElevationOrAboveAvgRunners();
}
