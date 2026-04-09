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

	@Bean
	public CommandLineRunner run(RouteRepository routeRepository) {
		return args -> {
			List<Route> routes = routeRepository.findNameOfAllRoutes();
			routes.forEach(System.out::println);
		};
	}
}
