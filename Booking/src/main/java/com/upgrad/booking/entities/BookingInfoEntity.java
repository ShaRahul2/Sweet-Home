package com.upgrad.booking.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@Entity(name = "booking")
@JsonPropertyOrder({ "Id", "fromDate","toDate","aadharNumber","roomNumbers", "roomPrice","transactionId","bookedOn"})
public class BookingInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Column(nullable = true)
    private LocalDateTime fromDate;

    @Column(nullable = true)
    private LocalDateTime toDate;

    @Column(nullable = false)
    private String aadharNumber;

    @Column
    private int numOfRooms;

    @Column
    private String roomNumbers;

    @Column(nullable = false)
    private int roomPrice;

    @Column
    private int transactionId;

    @Column(nullable = true)
    private LocalDateTime bookedOn;

    @JsonProperty("Id")
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

    @JsonIgnore
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
    
    @Override
	public String toString() {
		return "BookingInfoEntity [bookingId=" + bookingId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", aadharNumber=" + aadharNumber + ", roomNumbers=" + roomNumbers
				+ ", roomPrice=" + roomPrice + ", transactionId=" + transactionId + ", bookedOn=" + bookedOn + "]";
	}
}
