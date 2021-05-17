package com.upgrad.booking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgrad.booking.dto.PaymentDto;
import com.upgrad.booking.entities.BookingInfoEntity;
import com.upgrad.booking.feign.PaymentServiceClient;

@Aspect
@Component
public class PaymentAspect {

	@Autowired
    PaymentServiceClient paymentServiceClient;
	
    @Before(value = "execution(* com.upgrad.booking.service.BookingServiceImpl.updateBookingDetails(..)) and args(bookingId, paymentDto)")
	public void beforeAdvice(JoinPoint joinPoint, int bookingId, PaymentDto paymentDto){
	
    	BookingInfoEntity bookingInfo = paymentServiceClient.getPayment(bookingId, paymentDto);
        if(bookingInfo==null){
            throw new RuntimeException("No booking found !!");
        }
	}
}
