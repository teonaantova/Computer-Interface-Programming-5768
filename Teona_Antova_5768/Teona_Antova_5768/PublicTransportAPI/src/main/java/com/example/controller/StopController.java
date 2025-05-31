package com.example.controller;

import com.example.entity.Stop;
import com.example.entity.Trip;
import com.example.services.StopService;
import com.example.services.TripService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/stops")
public class StopController {
    private final StopService service;
    private final TripService tripService;

    public StopController(StopService service, TripService tripService) {
        this.service = service;
        this.tripService = tripService;
    }

    @GetMapping
    public List<Stop> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Stop save(@RequestBody Stop s) {
        return service.save(s);
    }

    @GetMapping("/{id}/trips")
    public List<Trip> upcomingTrips(@PathVariable Long id, @RequestParam int within) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusMinutes(within);
        return tripService.getUpcomingTripsAtStop(now, future);
    }
}