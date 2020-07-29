package com.example.demo.controller;

import com.example.demo.ceva.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class Controller {

    @Autowired
    MyUserDetailsService service;

    @Value("${name}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/name")
    public String hello1() {
        String name1 = service.loadUserByUsername("tudor1").getUsername();
        return name1;

    }
}
