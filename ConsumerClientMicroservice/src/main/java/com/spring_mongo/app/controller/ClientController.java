package com.spring_mongo.app.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring_mongo.app.clientservice.ClientFeignService;

@RestController
@RequestMapping("/app")
public class ClientController {
	@Autowired
	private LoadBalancerClient loadBalancer;
	@Autowired
	private ClientFeignService clientFeignService;
	

	@GetMapping("/read-all")
	public Map<String, Object> getData(@RequestHeader("Client-Id")String clientId) {
		return clientFeignService.readAll();
	}
	
	@GetMapping("/read-all-by-lb")
	public ResponseEntity<String> getData2(@RequestHeader("Client-Id")String clientId){
		ServiceInstance serviceInstance=loadBalancer.choose("bookingmicroservice");
		String baseUrl=serviceInstance.getUri().toString();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl+"/api/read-all",HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return new ResponseEntity<>(response.getBody(), HttpStatus.ACCEPTED);
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	/**
	 * Client side Load Balancing Using Spring cloud ribbon Ref URL : https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-ribbon.html
	 */

}
