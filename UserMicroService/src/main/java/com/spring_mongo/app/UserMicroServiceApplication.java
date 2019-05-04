package com.spring_mongo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="com.spring_mongo.app")
@EnableSwagger2
public class UserMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroServiceApplication.class, args);
	}

}
