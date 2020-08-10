package com.example.EzPassSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({ "com.example.control" })
@SpringBootApplication
public class EzPassSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzPassSpringBootApplication.class, args);
	}

}
