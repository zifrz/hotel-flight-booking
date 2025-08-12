package com.travelbooking.hotelflightbookingservice.dto;

import com.travelbooking.hotelflightbookingservice.model.BookingType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookingDto {
    private Long bookingId;

    private Long itemId;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private BookingType type;

    private String status;

    private Long paymentId;
}
