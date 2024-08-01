package com.example.air_ticket_booking_system_with_realtime_update.Controller;

import com.example.air_ticket_booking_system_with_realtime_update.Services.BookingService;
import com.example.air_ticket_booking_system_with_realtime_update.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class DialogflowController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> handleDialogflowWebhook(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> queryResult = (Map<String, Object>) request.get("queryResult");
        if (queryResult != null && queryResult.get("intent") instanceof Map) {
            Map<String, Object> intent = (Map<String, Object>) queryResult.get("intent");
            String intentName = (String) intent.get("displayName");

            switch (intentName) {
                case "BookFlight":
                    response = handleBookFlightIntent(queryResult);
                    break;
                case "CheckFlightStatus":
                    response = handleCheckFlightStatusIntent(queryResult);
                    break;
                // Add more intents as needed
            }
        } else {
            response.put("fulfillmentText", "Sorry, I didn't understand that.");
        }

        return ResponseEntity.ok(response);
    }

    private Map<String, Object> handleBookFlightIntent(Map<String, Object> queryResult) {
        // Extract parameters from the query result and call flightService to book flight
        // Example response
        Map<String, Object> response = new HashMap<>();
        response.put("fulfillmentText", "Your flight has been booked!");
        return response;
    }

    private Map<String, Object> handleCheckFlightStatusIntent(Map<String, Object> queryResult) {
        // Extract parameters from the query result and call flightService to check flight status
        // Example response
        Map<String, Object> response = new HashMap<>();
        response.put("fulfillmentText", "Your flight is on time!");
        return response;
    }
}