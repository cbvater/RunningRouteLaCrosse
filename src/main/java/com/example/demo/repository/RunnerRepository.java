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
}
