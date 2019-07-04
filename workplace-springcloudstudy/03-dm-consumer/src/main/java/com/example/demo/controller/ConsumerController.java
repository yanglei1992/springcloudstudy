package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloRemoteService;

@RestController
public class ConsumerController {

	@Autowired
	HelloRemoteService helloRemoteService;

	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name) {
		return helloRemoteService.hello(name);
	}

}
