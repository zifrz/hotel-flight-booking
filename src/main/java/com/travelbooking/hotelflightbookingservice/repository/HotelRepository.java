package com.travelbooking.hotelflightbookingservice.repository;

import com.travelbooking.hotelflightbookingservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
