package com.appdong.parting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${spring.profiles.active:}")
    private String profile;

    @ResponseBody
    @GetMapping("/")
    public String hello() {
        System.out.println(profile);
        return profile;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String realHello() {
        return "Hello, world!";
    }
}
