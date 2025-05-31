package com.example.repository;

import com.example.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByRouteIdAndDepartureTimeBetween(Long routeId, LocalDateTime start, LocalDateTime end);
    List<Trip> findByDepartureTimeBetween(LocalDateTime now, LocalDateTime future);
    List<Trip> findByBusNumberAndDepartureTimeLessThanEqualAndArrivalTimeGreaterThanEqual(String busNumber, LocalDateTime end, LocalDateTime start);
}
