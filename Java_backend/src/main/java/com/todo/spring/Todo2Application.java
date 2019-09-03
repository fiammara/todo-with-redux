package com.todo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.todo.spring")
public class Todo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Todo2Application.class, args);
	}
	
}
