
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.UserFeignClient;

@RestController
public class UserController {

	@Autowired
	private UserFeignClient userFeignClient;

	@RequestMapping("userlogin")
	public String login() {
		return "userlogin:" + userFeignClient.login();
	}

	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String upload1(@RequestPart(value = "file") MultipartFile file) {
		return "upload1:" + userFeignClient.upload1(file);
	}
	
	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public String upload2(@RequestParam(value = "message")String message, @RequestPart(value = "file") MultipartFile file) {
		return "upload2:" + userFeignClient.upload2(message, file);
	}

}
