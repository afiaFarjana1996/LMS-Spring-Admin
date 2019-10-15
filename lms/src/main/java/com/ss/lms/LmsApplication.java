package com.ss.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LmsApplication {


	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

}
