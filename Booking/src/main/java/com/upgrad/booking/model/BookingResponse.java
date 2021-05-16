package com.upgrad.booking.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "Id", "fromDate","toDate","aadharNumber","roomNumbers", "roomPrice","transactionId","bookedOn"})
public class BookingResponse {
	
	
	private int bookingId;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String aadharNumber;   
    private String roomNumbers;
    private int roomPrice;
    private int transactionId;
    private LocalDateTime bookedOn;
	
    /**
	 * @param bookingid
	 * @param fromDate
	 * @param toDate
	 * @param aadharNumber
	 * @param roomNumbers
	 * @param roomPrice
	 * @param transactionId
	 * @param bookedOn
	
	public BookingResponse(int bookingid, LocalDateTime fromDate, LocalDateTime toDate, String aadharNumber,
			String roomNumbers, int roomPrice, int transactionId, LocalDateTime bookedOn) {
		super();
		this.bookingid = bookingid;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.aadharNumber = aadharNumber;
		this.roomNumbers = roomNumbers;
		this.roomPrice = roomPrice;
		this.transactionId = transactionId;
		this.bookedOn = bookedOn;
	}
	 */
    
    /**
	 * @return the id
	 */
    @JsonProperty("Id")
	public int getbookingid() {
		return bookingId;
	}
	/**
	 * @param id the id to set
	 */
	public void setbookingid(int id) {
		this.bookingId = id;
	}
	/**
	 * @return the fromDate
	 */
	public LocalDateTime getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public LocalDateTime getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the aadharNumber
	 */
	public String getAadharNumber() {
		return aadharNumber;
	}
	/**
	 * @param aadharNumber the aadharNumber to set
	 */
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	/**
	 * @return the roomNumbers
	 */
	public String getRoomNumbers() {
		return roomNumbers;
	}
	/**
	 * @param roomNumbers the roomNumbers to set
	 */
	public void setRoomNumbers(String roomNumbers) {
		this.roomNumbers = roomNumbers;
	}
	/**
	 * @return the roomPrice
	 */
	public int getRoomPrice() {
		return roomPrice;
	}
	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the bookedOn
	 */
	public LocalDateTime getBookedOn() {
		return bookedOn;
	}
	/**
	 * @param bookedOn the bookedOn to set
	 */
	public void setBookedOn(LocalDateTime bookedOn) {
		this.bookedOn = bookedOn;
	}
	
}
