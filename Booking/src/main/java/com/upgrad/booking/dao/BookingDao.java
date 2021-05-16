package com.upgrad.booking.dao;


import com.upgrad.booking.entities.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This layer will be used to talk to the databases
 */
public interface BookingDao extends JpaRepository<BookingInfoEntity, Integer> {

}
