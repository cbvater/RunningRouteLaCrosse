package com.example.demo;

import com.example.demo.model.Route;
import com.example.demo.repository.RouteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RunningRoutes {

	public static void main(String[] args) {
		SpringApplication.run(RunningRoutes.class, args);


	}

}

//C - users can add reviews to route
//R - User inputs route name → returns all reviews for that route
//U - users can update 5k_pr to runner
//D - users can delete reviews to route
//Advanced - User inputs minimum rating (e.g. 4.0) → returns all routes with avg review >= 4.0
