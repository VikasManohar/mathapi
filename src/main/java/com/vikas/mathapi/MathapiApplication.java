package com.vikas.mathapi;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MathapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathapiApplication.class, args);
	}

	@Bean
	public JSONObject jsonObject() {
		return new JSONObject();
	}

}
