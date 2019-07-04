package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

import com.example.demo.service.HelloRemoteService;

@Component
public class HelloRemoteServiceHystrixImpl implements HelloRemoteService{

	@Override
	public String hello(String name) {
		return "hello" +name+", this messge send failed ";
	}

}
