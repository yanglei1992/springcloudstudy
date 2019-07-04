package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserConterller {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		return "用户已验证";
	}

	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String upload1(@RequestPart(value = "file") MultipartFile file) {
		System.out.println("upload1");
		return file.getOriginalFilename();
	}

	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public String upload2(@RequestParam(value = "message")String message,  @RequestPart(value = "file") MultipartFile file) {
		System.out.println("upload2");
		return message + ":" + file.getOriginalFilename();
	}

}
