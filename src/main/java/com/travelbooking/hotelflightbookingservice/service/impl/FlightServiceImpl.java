package com.travelbooking.hotelflightbookingservice.service.impl;

import com.travelbooking.hotelflightbookingservice.model.Flight;
import com.travelbooking.hotelflightbookingservice.repository.FlightRepository;
import com.travelbooking.hotelflightbookingservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Long flightId, Flight flight) {
        flight.setFlightId(flightId);
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> searchFlights(String airline, String departure, String arrival, Double minPrice, Double maxPrice, Boolean availability) {
        return flightRepository.searchFlights(airline, departure, arrival, minPrice, maxPrice, availability);
    }
}
