package com.example.controller;

import com.example.entity.Route;
import com.example.entity.Trip;
import com.example.services.RouteService;
import com.example.services.TripService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteService service;
    public RouteController(RouteService service) { this.service = service; }

    @GetMapping
    public List<Route> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Route save(@RequestBody Route r) {
        return service.save(r);
    }

    @GetMapping("/{id}/trips")
    public List<Trip> tripsByRoute(@PathVariable Long id, @RequestParam LocalDate date, TripService tripService) {
        return tripService.getTripsByRouteAndDate(id, date);
    }
}
