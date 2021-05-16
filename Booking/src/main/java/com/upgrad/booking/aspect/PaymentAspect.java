package com.upgrad.booking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgrad.booking.entities.BookingInfoEntity;
import com.upgrad.booking.feign.PaymentServiceClient;

@Aspect
@Component
public class PaymentAspect {

	@Autowired
    PaymentServiceClient paymentServiceClient;
	
    @Before(value = "execution(* com.upgrad.booking.service.BookingServiceImpl.updateBookingDetails(..)) and args(bookingId)")
	public void beforeAdvice(JoinPoint joinPoint, int bookingId){
	
    	BookingInfoEntity bookingInfo = paymentServiceClient.getPayment(bookingId);
        if(bookingInfo==null){
            throw new RuntimeException("No booking found !!");
        }
	}
}
