package com.example.demoeurekaprovider2.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception{
        return "用户已验证,这是第二个服务";
    }
}