package com.example.air_ticket_booking_system_with_realtime_update.Services;

import com.example.air_ticket_booking_system_with_realtime_update.Models.Flight;
import com.example.air_ticket_booking_system_with_realtime_update.Repository.FlightRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepository;

    // Create a new flight
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Retrieve a flight by ID
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    // Retrieve all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Update flight information
    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setOrigin(flightDetails.getOrigin());
        flight.setDestination(flightDetails.getDestination());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        return flightRepository.save(flight);
    }

    // Delete a flight by ID
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
