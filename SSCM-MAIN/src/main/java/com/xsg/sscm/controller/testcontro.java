package com.xsg.sscm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class testcontro {

    @GetMapping(value = "/test1")
    public String test(){
        return "test success";
    }
}
