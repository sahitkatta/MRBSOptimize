package com.comakeit.mrbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.comakeit.mrbs")
@EnableJpaRepositories
public class MRBSApplication {

	public static void main(String[] args) {

		SpringApplication.run(MRBSApplication.class, args);

	}

}
