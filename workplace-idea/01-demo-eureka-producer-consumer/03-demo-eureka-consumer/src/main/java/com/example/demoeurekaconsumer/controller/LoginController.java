package com.example.demoeurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("userlogin")
    public String login() {
        return "userlogin:" + userFeignClient.login();
    }
}
