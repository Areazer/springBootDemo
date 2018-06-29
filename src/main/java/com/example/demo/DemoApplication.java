package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@MapperScan("com.example.mapper")
public class DemoApplication {
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}





}
