package com.travelbooking.hotelflightbookingservice.controller;

import com.travelbooking.hotelflightbookingservice.dto.BookingDto;
import com.travelbooking.hotelflightbookingservice.model.Booking;
import com.travelbooking.hotelflightbookingservice.model.BookingType;
import com.travelbooking.hotelflightbookingservice.service.BookingService;
import com.travelbooking.hotelflightbookingservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final JwtUtil jwtUtil;

    @Autowired
    private BookingService bookingService;

    public BookingController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/{bookingId}")
    @PreAuthorize("hasRole('TRAVELER') or hasRole('HOTEL_MANAGER') or hasRole('TRAVEL_AGENT') or hasRole('ADMIN')")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    @PreAuthorize("hasRole('TRAVELER') or hasRole('HOTEL_MANAGER') or hasRole('TRAVEL_AGENT') or hasRole('ADMIN')")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping
    @PreAuthorize("hasRole('TRAVELER')")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @PutMapping("/{bookingId}")
    @PreAuthorize("hasRole('TRAVELER')")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBooking(bookingId, booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{bookingId}")
    @PreAuthorize("hasRole('TRAVELER')")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/hasBooked")
    @PreAuthorize("hasRole('TRAVELER')")
    public ResponseEntity<Boolean> hasBooked(@RequestBody BookingDto bookingDto) {
        Booking booking = bookingService.getBookingByDetails(
                bookingDto.getBookingId(),
                bookingDto.getType(),
                bookingDto.getItemId(),
                bookingDto.getUserId());

        return ResponseEntity.ok(booking != null);
    }
}
