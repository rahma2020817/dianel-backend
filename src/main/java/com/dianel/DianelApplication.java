package com.dianel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dianel.dao")
public class DianelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DianelApplication.class, args);
		System.out.println("Hello all");
	}

}
