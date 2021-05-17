//package com.upgrad.booking.feign;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.upgrad.booking.dto.PaymentDto;
//import com.upgrad.booking.entities.BookingInfoEntity;
//
//@FeignClient(name = "payment-service",url = "http://localhost:8083")
//public interface PaymentServiceClient {
//
//	 // @RequestMapping(value = "/booking/{id}/payment", method = RequestMethod.POST)
//	    public BookingInfoEntity getPayment(@PathVariable(name = "id") int id, @RequestBody PaymentDto paymentDto);
//}
