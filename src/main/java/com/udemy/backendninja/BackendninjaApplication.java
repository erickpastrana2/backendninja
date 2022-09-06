package com.udemy.backendninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BackendninjaApplication extends SpringBootServletInitializer{
	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(BackendninjaApplication.class);
	 }
	
	public static void main(String[] args) {
		SpringApplication.run(BackendninjaApplication.class, args);
	}

}
