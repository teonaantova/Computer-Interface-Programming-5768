package com.example.services;

import com.example.entity.Route;
import com.example.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository repo;

    public RouteService(RouteRepository repo) {
        this.repo = repo;
    }

    public List<Route> getAll() {
        return repo.findAll();
    }

    public Route save(Route route) {
        return repo.save(route);
    }
}