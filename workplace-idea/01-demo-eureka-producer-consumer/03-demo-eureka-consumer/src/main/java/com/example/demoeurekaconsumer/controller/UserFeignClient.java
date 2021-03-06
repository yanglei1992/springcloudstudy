package com.example.demoeurekaconsumer.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-eureka-provider")
public interface UserFeignClient {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login();
}
