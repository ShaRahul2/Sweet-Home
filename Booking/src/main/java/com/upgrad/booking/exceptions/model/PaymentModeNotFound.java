package com.upgrad.booking.exceptions.model;

/**
 * @author Rahul Sharma
 * 
 * */
public class PaymentModeNotFound extends RuntimeException {
	
	public PaymentModeNotFound(String message) {
		super(message);
	}
}
