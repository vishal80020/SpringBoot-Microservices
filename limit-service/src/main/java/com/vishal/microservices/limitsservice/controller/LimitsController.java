package com.vishal.microservices.limitsservice.controller;

import com.vishal.microservices.limitsservice.bean.Limits;
import com.vishal.microservices.limitsservice.configuration.CustomConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private CustomConfiguration configuration;

    @GetMapping("/limits")
    public Limits retrieve() {
//        return new Limits(1,1000);
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
