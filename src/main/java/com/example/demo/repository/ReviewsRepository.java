package com.example.demo.repository;

import com.example.demo.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

    @Query(value = "SELECT * FROM reviews WHERE route_id = (SELECT id FROM routes WHERE name = :name)", nativeQuery = true)
    List<Reviews> findByRouteName(@Param("name") String name);
}