package com.upgrad.booking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RestController
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableAspectJAutoProxy
public class BookingApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
