package com.travelbooking.hotelflightbookingservice.service;

import com.travelbooking.hotelflightbookingservice.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> getAllHotels();

    Optional<Hotel> getHotelById(Long hotelId);

    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(Long hotelId, Hotel hotel);

    void deleteHotel(Long hotelId);
}
