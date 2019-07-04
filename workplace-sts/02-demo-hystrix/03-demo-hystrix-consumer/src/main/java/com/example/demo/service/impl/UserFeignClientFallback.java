
package com.example.demo.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.UserFeignClient;

@Component
public class UserFeignClientFallback implements UserFeignClient {

	@Override
	public String login() {
		return "fegin:异常";
	}

	@Override
	public String upload1(MultipartFile file) {
		return "upload1:异常";
	}

	@Override
	public String upload2(String message, MultipartFile file) {
		return "upload2:异常";
	}

}
