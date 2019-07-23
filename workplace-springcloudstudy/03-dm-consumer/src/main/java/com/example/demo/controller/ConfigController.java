package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	@Value("${token}")
	private boolean token;

	@RequestMapping("hello")
	public boolean name() {
		return token;
	}
}
