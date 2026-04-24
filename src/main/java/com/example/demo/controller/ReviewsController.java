package com.example.demo.controller;

import com.example.demo.model.ReviewDTO;
import com.example.demo.model.Reviews;
import com.example.demo.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping
    public Reviews createReview(@RequestBody Map<String, Object> body) {
        Long runnerId = Long.valueOf(body.get("runnerId").toString());
        Long routeId  = Long.valueOf(body.get("routeId").toString());
        double rating = Double.parseDouble(body.get("rating").toString());
        String comment = body.get("comment").toString();
        return reviewsService.createReview(runnerId, routeId, rating, comment);
    }

    @GetMapping("/route")
    public List<ReviewDTO> getReviewsByRoute(@RequestParam String name) {
        return reviewsService.getReviewsByRouteName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewsService.deleteReview(id);
    }
}