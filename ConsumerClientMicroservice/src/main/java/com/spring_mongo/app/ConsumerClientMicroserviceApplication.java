package com.spring_mongo.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.spring_mongo.app.clientservice"})
@ComponentScan(basePackages = {"com.spring_mongo.app"})
@RibbonClient(name = "bookingmicroservice", configuration = MicroserviceLoadBalancingConfiguration.class)
public class ConsumerClientMicroserviceApplication{
	public static void main(String[] args) {
		SpringApplication.run(ConsumerClientMicroserviceApplication.class, args);
	}


}
