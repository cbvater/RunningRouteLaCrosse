package com.example.demo.service;

import com.example.demo.model.ReviewDTO;
import com.example.demo.model.Reviews;
import com.example.demo.model.Route;
import com.example.demo.model.Runner;
import com.example.demo.repository.ReviewsRepository;
import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private RunnerRepository runnerRepository;

    @Autowired
    private RouteRepository routeRepository;

    public Reviews createReview(Long runnerId, Long routeId, double rating, String comment) {
        Runner runner = runnerRepository.findById(runnerId).orElseThrow();
        Route route   = routeRepository.findById(routeId).orElseThrow();

        Reviews review = new Reviews();
        review.setRunner(runner);
        review.setRoute(route);
        review.setRating(rating);
        review.setComment(comment);

        return reviewsRepository.save(review);
    }

    public List<ReviewDTO> getReviewsByRouteName(String name) {
        return reviewsRepository.findByRouteName(name)
                .stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteReview(Long id) {
        reviewsRepository.deleteById(id);
    }
}