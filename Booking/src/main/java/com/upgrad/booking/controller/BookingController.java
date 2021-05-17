package com.upgrad.booking.controller;

import com.upgrad.booking.dto.BookingDto;
import com.upgrad.booking.dto.PaymentDto;
import com.upgrad.booking.entities.BookingInfoEntity;
import com.upgrad.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	ModelMapper modelMapper;

	/**
	 * Method for creating Booking 127.0.0.1:8080/booking
	 */

	@PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingInfoEntity> createBooking(@RequestBody BookingDto bookingDto) {
		
		BookingInfoEntity newBooking = modelMapper.map(bookingDto, BookingInfoEntity.class);
		BookingInfoEntity savedBooking = bookingService.acceptBooking(newBooking);

		return new ResponseEntity<BookingInfoEntity>(savedBooking, HttpStatus.CREATED);
	}

	/**
	 * Method to fetch Booking details from 127.0.0.1:8080/booking/{id}
	 * pass booking id 
	 * 
	 */
	@GetMapping(value = "/booking/{id}")
	public ResponseEntity<BookingInfoEntity> getMovieBasedOnId(@PathVariable(name = "id") int id) {
		BookingInfoEntity responseBooking = bookingService.getBookingDetails(id);

		return new ResponseEntity<BookingInfoEntity>(responseBooking, HttpStatus.OK);
	}

	/**
	 * Method for updating transaction id in Booking 127.0.0.1:8080/booking
	 */
	@PostMapping(value = "booking/{id}/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingInfoEntity> updateMovieDetails(@PathVariable(name = "id") int id, @RequestBody PaymentDto paymentDto) {

		BookingInfoEntity udpatedBooking = bookingService.updateBookingDetails(id, paymentDto);

		return new ResponseEntity<BookingInfoEntity>(udpatedBooking, HttpStatus.CREATED);
	}
	
	
}
