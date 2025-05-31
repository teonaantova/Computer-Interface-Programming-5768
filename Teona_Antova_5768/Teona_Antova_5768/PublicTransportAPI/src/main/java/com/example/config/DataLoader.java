package com.example.config;

import com.example.entity.Route;
import com.example.entity.Stop;
import com.example.entity.Trip;
import com.example.repository.RouteRepository;
import com.example.repository.StopRepository;
import com.example.repository.TripRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader {
    private final RouteRepository routeRepo;
    private final StopRepository stopRepo;
    private final TripRepository tripRepo;

    public DataLoader(RouteRepository r, StopRepository s, TripRepository t) {
        this.routeRepo = r; this.stopRepo = s; this.tripRepo = t;
    }

    @PostConstruct
    public void load() {
        List<Stop> stops = stopRepo.saveAll(List.of(
                new Stop("S1", "Central", 41.9981, 21.4254),
                new Stop("S2", "East Station", 42.0, 21.45),
                new Stop("S3", "West End", 41.99, 21.41),
                new Stop("S4", "North Park", 42.01, 21.43),
                new Stop("S5", "South Gate", 41.98, 21.44)
        ));

        Route r1 = routeRepo.save(new Route("R1", "Line 1"));
        Route r2 = routeRepo.save(new Route("R2", "Line 2"));

        tripRepo.save(new Trip(LocalDateTime.now().plusMinutes(5), LocalDateTime.now().plusMinutes(35), "B1"));
        tripRepo.save(new Trip(LocalDateTime.now().plusMinutes(10), LocalDateTime.now().plusMinutes(45), "B2"));
    }
}