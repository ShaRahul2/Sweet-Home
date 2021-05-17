package com.upgrad.booking.service;

import com.upgrad.booking.dto.PaymentDto;
import com.upgrad.booking.entities.BookingInfoEntity;

public interface BookingService {

    public BookingInfoEntity acceptBooking(BookingInfoEntity movie);

    public BookingInfoEntity getBookingDetails(int id);

    public BookingInfoEntity updateBookingDetails(int id, PaymentDto paymentDto );
}
