package com.example.air_ticket_booking_system_with_realtime_update.Repository;

import com.example.air_ticket_booking_system_with_realtime_update.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {}
