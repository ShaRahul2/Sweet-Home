package com.upgrad.booking.dto;

import java.time.LocalDateTime;

public class PaymentDto {
	private String paymentMode;
	private int bookingId;
	private String upiId;
	private String cardNumber;
	private LocalDateTime bookingDate;
	/**
	 * @return the bookingDate
	 */
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the upiId
	 */
	public String getUpiId() {
		return upiId;
	}
	/**
	 * @param upiId the upiId to set
	 */
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
