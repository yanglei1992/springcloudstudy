package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.impl.HelloRemoteServiceHystrixImpl;

@FeignClient(name = "spring-cloud-producer", fallback = HelloRemoteServiceHystrixImpl.class)
public interface HelloRemoteService {

	@RequestMapping(value = "/hello")
	public String hello(@RequestParam(value = "name") String name);
}
