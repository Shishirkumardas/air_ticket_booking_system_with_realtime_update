package com.example.air_ticket_booking_system_with_realtime_update.Controller;

import com.example.air_ticket_booking_system_with_realtime_update.Models.FlightUpdate;
import org.springframework.beans.factory.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightUpdateController {

    private final SimpMessagingTemplate template;

    @Autowired
    public FlightUpdateController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 5000)
    public void sendFlightUpdates() {
        // Here, fetch real-time flight data and send it to the clients
        FlightUpdate flightUpdate = new FlightUpdate(/* real-time data */);
        template.convertAndSend("/topic/flightUpdates", flightUpdate);
    }
}
