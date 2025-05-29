package com.example.services;

import com.example.entity.Stop;
import com.example.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {
    private final StopRepository repo;

    public StopService(StopRepository repo) {
        this.repo = repo;
    }

    public List<Stop> getAll() {
        return repo.findAll();
    }

    public Stop save(Stop stop) {
        return repo.save(stop);
    }
}