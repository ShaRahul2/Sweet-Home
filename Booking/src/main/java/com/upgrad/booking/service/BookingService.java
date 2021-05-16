package com.upgrad.booking.service;

import com.upgrad.booking.entities.BookingInfoEntity;

public interface BookingService {

    public BookingInfoEntity acceptBooking(BookingInfoEntity movie);

    public BookingInfoEntity getBookingDetails(int id);

    public BookingInfoEntity updateBookingDetails(int id );
}
