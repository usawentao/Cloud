package com.config.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hi {
    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hello(){
        return foo;
    }
}
