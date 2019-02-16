package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

import com.example.demo.service.UserFeignClient;

@Component
public class UserFeignClientFallback implements UserFeignClient{

	@Override
	public String login() {
		return "fegin:异常";
	}

}
