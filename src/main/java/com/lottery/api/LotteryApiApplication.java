package com.lottery.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LotteryApiApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(LotteryApiApplication.class, args);
	}
}
