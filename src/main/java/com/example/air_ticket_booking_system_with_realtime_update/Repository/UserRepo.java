package com.example.air_ticket_booking_system_with_realtime_update.Repository;

import com.example.air_ticket_booking_system_with_realtime_update.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
