package com.priyanshu.patient_service.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    public String hello(){
        return "Hello World";
    }
}
