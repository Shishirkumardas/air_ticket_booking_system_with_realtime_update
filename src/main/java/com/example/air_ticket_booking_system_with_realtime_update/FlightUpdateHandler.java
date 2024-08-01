package com.example.air_ticket_booking_system_with_realtime_update;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class FlightUpdateHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<String> messages = Flux.interval(Duration.ofSeconds(1))
                .map(i -> "Real-time flight update " + i);

        return session.send(messages.map(session::textMessage));
    }
}