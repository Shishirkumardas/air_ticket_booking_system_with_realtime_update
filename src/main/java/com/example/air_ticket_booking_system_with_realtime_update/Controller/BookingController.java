package com.example.air_ticket_booking_system_with_realtime_update.Controller;
import com.example.air_ticket_booking_system_with_realtime_update.Models.Booking;

import com.example.air_ticket_booking_system_with_realtime_update.Services.BookingService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping
    public Booking createBooking(@RequestParam Long userId, @RequestParam Long flightId) {
        return bookingService.createBooking(userId, flightId);
    }

    // Retrieve a booking by ID
    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // Retrieve all bookings for a user
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    // Retrieve all bookings for a flight
    @GetMapping("/flight/{flightId}")
    public List<Booking> getBookingsByFlightId(@PathVariable Long flightId) {
        return bookingService.getBookingsByFlightId(flightId);
    }

    // Cancel a booking by ID
    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }
}
