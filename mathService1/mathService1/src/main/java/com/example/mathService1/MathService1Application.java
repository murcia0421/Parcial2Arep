package com.example.mathService1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class MathService1Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MathService1Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8085"));
		app.run(args);
	}

}
