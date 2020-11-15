package com.couponfinder.couponREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CouponRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponRestApplication.class, args);
	}

}
