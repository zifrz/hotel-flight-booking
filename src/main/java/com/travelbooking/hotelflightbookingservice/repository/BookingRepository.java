package com.travelbooking.hotelflightbookingservice.repository;

import com.travelbooking.hotelflightbookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
