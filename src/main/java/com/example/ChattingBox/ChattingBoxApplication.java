package com.example.ChattingBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ChattingBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChattingBoxApplication.class, args);
	}

}
