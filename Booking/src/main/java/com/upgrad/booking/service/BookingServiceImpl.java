package com.upgrad.booking.service;

import com.upgrad.booking.dao.BookingDao;
import com.upgrad.booking.entities.BookingInfoEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private RestTemplate restTemplate;

	@Override
	public BookingInfoEntity acceptBooking(BookingInfoEntity booking) {
		
		booking.setBookedOn(java.time.LocalDateTime.now());
		long noOfDays = ChronoUnit.DAYS.between(booking.getFromDate(), booking.getToDate());
		booking.setRoomPrice((int) (1000 * booking.getNumOfRooms() * (noOfDays)));
		String str = getRandomNumbers(booking.getNumOfRooms()).stream().collect(Collectors.joining(","));
		booking.setRoomNumbers(str);
		return bookingDao.save(booking);
	}
	
    private static ArrayList<String> getRandomNumbers(int count){                
        Random rand = new Random();                
        int upperBound = 100;                
        ArrayList<String>numberList = new ArrayList<String>();                

       for (int i=0; i<count; i++){                
                   numberList.add(String.valueOf(rand.nextInt(upperBound)));                
        }                

         return numberList;                
    }
    
    @Override
    public BookingInfoEntity getBookingDetails(int id) {
        return bookingDao.findById(id).get();
    }

    @Override
    public BookingInfoEntity updateBookingDetails(int bookingId) {
    	BookingInfoEntity savedBooking = getBookingDetails(bookingId);
        savedBooking.setTransactionId(0);
        bookingDao.save(savedBooking);

        return savedBooking;
    }
    
}
