package com.travelbooking.hotelflightbookingservice.service.impl;

import com.travelbooking.hotelflightbookingservice.model.Booking;
import com.travelbooking.hotelflightbookingservice.model.BookingType;
import com.travelbooking.hotelflightbookingservice.repository.BookingRepository;
import com.travelbooking.hotelflightbookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) {
        booking.setBookingId(bookingId);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public Booking getBookingByDetails(Long bookingId, BookingType type, Long itemId, Long userId) {
        return bookingRepository.findByBookingIdAndTypeAndItemIdAndUserId(bookingId, type, itemId, userId);
    }
}
