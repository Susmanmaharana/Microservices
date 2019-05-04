package com.spring_mongo.app.clientservice;

import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@RibbonClient(name="bookingmicroservice")
@FeignClient(name="bookingmicroservice",url="http://192.168.2.18:8762/")
public interface ClientFeignService {
	@GetMapping("/api/read-all")
	public Map<String, Object> readAll();

}
