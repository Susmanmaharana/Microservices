package com.sd;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



public interface Client1FeignService {

	@FeignClient(name = "client2")
	public interface DataStoreFeignClient{
		@GetMapping("/callFromClient1")
		public String getClientData();
	}
}
