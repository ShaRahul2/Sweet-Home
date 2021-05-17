package com.upgrad.booking.service;

import com.upgrad.booking.dao.BookingDao;
import com.upgrad.booking.dto.PaymentDto;
import com.upgrad.booking.entities.BookingInfoEntity;
import com.upgrad.booking.exceptions.model.BookingIDNotFoundException;
import com.upgrad.booking.exceptions.model.PaymentModeNotFound;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

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
		//ProduceKafkaMessage(booking);
		return bookingDao.save(booking);
	}

	private static ArrayList<String> getRandomNumbers(int count) {
		Random rand = new Random();
		int upperBound = 100;
		ArrayList<String> numberList = new ArrayList<String>();

		for (int i = 0; i < count; i++) {
			numberList.add(String.valueOf(rand.nextInt(upperBound)));
		}

		return numberList;
	}

	@Override
	public BookingInfoEntity getBookingDetails(int id) {
Optional<BookingInfoEntity> bookingOptional = Optional.of(bookingDao.findById(id).get());
		
		if(! bookingOptional.isPresent()) {
			throw new BookingIDNotFoundException("Invalid Booking Id");
		}	
		return bookingOptional.get();
	}

	@Override
	public BookingInfoEntity updateBookingDetails(int bookingId, PaymentDto paymentDto) {
		System.out.println(paymentDto.getPaymentMode());
		System.out.println("");
//(!paymentDto.getPaymentMode().toLowerCase() == ("upi") || !paymentDto.getPaymentMode().toLowerCase()==("card")) {
//			throw new PaymentModeNotFound("Invalid mode of payment");
//		}
		
		Optional<BookingInfoEntity> bookingOptional = Optional.of(getBookingDetails(bookingId));
		
		if(! bookingOptional.isPresent()) {
			throw new BookingIDNotFoundException("Invalid Booking Id");
		}		
		
		BookingInfoEntity savedBooking = bookingOptional.get();		
		savedBooking.setTransactionId(0);
		bookingDao.save(savedBooking);
		ProduceKafkaMessage(savedBooking);
		return savedBooking;
	}

	private static void ProduceKafkaMessage(BookingInfoEntity bookingInfo) {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "54.242.164.154:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		String message = "Booking confirmed for user with aadhaar number: " + bookingInfo.getAadharNumber()
				+ "    |    " + "Here are the booking details:    " + bookingInfo.toString();

		KafkaProducer kafkaProducer = new KafkaProducer(properties);
		try {
		
			kafkaProducer.send(new ProducerRecord("message", Integer.toString(0), message));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			kafkaProducer.close();
		}
	}

}
