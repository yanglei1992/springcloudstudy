package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserFeignClient;

@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("userlogin")
    public String login() {
        return "userlogin:" + userFeignClient.login();
    }
}
