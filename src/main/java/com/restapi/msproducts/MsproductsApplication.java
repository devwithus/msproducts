package com.restapi.msproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MsproductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsproductsApplication.class, args);
	}

}
