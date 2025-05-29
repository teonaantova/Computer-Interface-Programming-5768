package com.example.services;

import com.example.entity.Trip;
import com.example.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {
    private final TripRepository repo;
    public TripService(TripRepository repo) { this.repo = repo; }

    public Trip saveTrip(Trip trip) {
        if (trip.getDepartureTime().isAfter(trip.getArrivalTime()))
            throw new IllegalArgumentException("Departure must be before arrival");
        List<Trip> overlapping = repo.findByBusNumberAndDepartureTimeLessThanEqualAndArrivalTimeGreaterThanEqual(
                trip.getBusNumber(), trip.getArrivalTime(), trip.getDepartureTime());
        if (!overlapping.isEmpty())
            throw new IllegalStateException("Bus is already booked in this time interval");
        return repo.save(trip);
    }

    public List<Trip> getTripsByRouteAndDate(Long routeId, LocalDate date) {
        return repo.findByRouteIdAndDepartureTimeBetween(routeId, date.atStartOfDay(), date.atTime(23,59));
    }

    public List<Trip> getUpcomingTripsAtStop(LocalDateTime now, LocalDateTime future) {
        return repo.findByDepartureTimeBetween(now, future);
    }
}