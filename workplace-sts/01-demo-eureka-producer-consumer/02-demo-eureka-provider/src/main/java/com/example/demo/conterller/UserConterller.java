package com.example.demo.conterller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConterller {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception{
        return "用户已验证";
    }
}
