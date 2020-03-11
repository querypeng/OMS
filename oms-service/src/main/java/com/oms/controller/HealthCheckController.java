package com.oms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangyj
 * @date 2019-07-15 11:07
 */
@RestController
public class HealthCheckController {



    @GetMapping(value = "/health")
    public String healthCheck() {




        return "I am OK ^_^!";


    }
}
