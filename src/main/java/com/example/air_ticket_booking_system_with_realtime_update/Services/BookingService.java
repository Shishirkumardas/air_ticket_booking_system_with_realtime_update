package com.example.air_ticket_booking_system_with_realtime_update.Services;

import com.example.air_ticket_booking_system_with_realtime_update.Models.Booking;
import com.example.air_ticket_booking_system_with_realtime_update.Models.Flight;
import com.example.air_ticket_booking_system_with_realtime_update.Models.User;
import com.example.air_ticket_booking_system_with_realtime_update.Repository.BookingRepo;
import com.example.air_ticket_booking_system_with_realtime_update.Repository.FlightRepo;
import com.example.air_ticket_booking_system_with_realtime_update.Repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;


import java.time.LocalDateTime;
import java.util.*;
@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private FlightRepo flightRepository;

    // Create a new booking
    public Booking createBooking(Long userId, Long flightId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFlight(flight);
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    // Retrieve a booking by ID
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // Retrieve all bookings for a user
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Retrieve all bookings for a flight
    public List<Booking> getBookingsByFlightId(Long flightId) {
        return bookingRepository.findByFlightId(flightId);
    }

    // Cancel a booking by ID
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
