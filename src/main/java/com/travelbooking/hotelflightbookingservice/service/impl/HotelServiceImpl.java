package com.travelbooking.hotelflightbookingservice.service.impl;

import com.travelbooking.hotelflightbookingservice.model.Hotel;
import com.travelbooking.hotelflightbookingservice.repository.HotelRepository;
import com.travelbooking.hotelflightbookingservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long hotelId, Hotel hotel) {
        hotel.setHotelId(hotelId);  // Set the ID for updating
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public List<Hotel> getHotelsByLocation(String location) {
        return hotelRepository.findByLocationIgnoreCase(location);
    }
}
