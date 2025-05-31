package com.example.controller;

import com.example.entity.Route;
import com.example.entity.Trip;
import com.example.repository.TripRepository;
import com.example.services.TripService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService service;
    private final TripRepository repo;

    public TripController(TripService service, TripRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping("/route/{routeId}")
    public Trip createTrip(@PathVariable Long routeId, @RequestBody Trip trip) {
        Route route = new Route();
        route.setId(routeId);
        trip.setRoute(route);
        return service.saveTrip(trip);
    }

    @PatchMapping("/{id}")
    public Trip updateTimes(@PathVariable Long id, @RequestBody Trip update) {
        Trip trip = repo.findById(id).orElseThrow();
        trip.setDepartureTime(update.getDepartureTime());
        trip.setArrivalTime(update.getArrivalTime());
        return service.saveTrip(trip);
    }
}
