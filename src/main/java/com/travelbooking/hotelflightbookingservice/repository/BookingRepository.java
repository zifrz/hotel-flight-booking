package com.travelbooking.hotelflightbookingservice.repository;

import com.travelbooking.hotelflightbookingservice.model.Booking;
import com.travelbooking.hotelflightbookingservice.model.BookingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByBookingIdAndTypeAndItemIdAndUserId(Long bookingId, BookingType type, Long itemId, Long userId);
}
