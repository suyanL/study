package com.example.springbootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ddup/v3")
public class DemoController {

    @GetMapping("/demo")
    public String demo(){
        return "this a demo!";
    }
}
