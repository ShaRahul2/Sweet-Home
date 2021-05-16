package com.upgrad.booking.dto;

import java.time.LocalDateTime;

public class BookingDto {
    private int bookingId;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String aadharNumber;
    private int numOfRooms;
    private String roomNumbers;
    private int roomPrice;
    private int transactionId;
    private LocalDateTime bookedOn;

    /**
	 * @param bookingId
	 * @param fromDate
	 * @param toDate
	 * @param aadharNumber
	 * @param numOfRooms
	 * @param roomNumbers
	 * @param roomPrice
	 * @param transactionId
	 * @param bookedOn
	
	public BookingDto(int bookingId, LocalDateTime fromDate, LocalDateTime toDate, String aadharNumber, int numOfRooms,
			String roomNumbers, int roomPrice, int transactionId, LocalDateTime bookedOn) {
		super();
		this.bookingId = bookingId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.aadharNumber = aadharNumber;
		this.numOfRooms = numOfRooms;
		this.roomNumbers = roomNumbers;
		this.roomPrice = roomPrice;
		this.transactionId = transactionId;
		this.bookedOn = bookedOn;
	}
 */
	public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(LocalDateTime bookedOn) {
        this.bookedOn = bookedOn;
    }
}
