package com.cloud.servicemiya.controller;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class hello {
    private static final Logger LOG = Logger.getLogger(hello.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String info(){
        LOG.log(Level.INFO,"info is being called");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

    @RequestMapping("/miya")
    public String home(){
        LOG.log(Level.INFO, "calling trace service-miya ");
        return "i'm service-miya";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
