package com.travelbooking.hotelflightbookingservice.service;


import com.travelbooking.hotelflightbookingservice.model.Booking;
import com.travelbooking.hotelflightbookingservice.model.BookingType;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> getAllBookings();

    Optional<Booking> getBookingById(Long bookingId);

    Booking addBooking(Booking booking);

    Booking updateBooking(Long bookingId, Booking booking);

    void deleteBooking(Long bookingId);

    Booking getBookingByDetails(Long bookingId, BookingType type, Long itemId, Long userId);
}
