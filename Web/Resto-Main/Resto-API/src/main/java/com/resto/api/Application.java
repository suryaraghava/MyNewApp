package com.resto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Munisekhar
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.resto.service","com.resto.repository","com.resto.api"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
