package com.example.mathService2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class MathService2Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MathService2Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
	}

}




