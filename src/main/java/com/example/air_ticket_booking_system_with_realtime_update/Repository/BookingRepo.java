package com.example.air_ticket_booking_system_with_realtime_update.Repository;

import com.example.air_ticket_booking_system_with_realtime_update.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);

    List<Booking> findByFlightId(Long flightId);
}
