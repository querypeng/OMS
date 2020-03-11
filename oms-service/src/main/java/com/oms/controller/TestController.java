package com.oms.controller;


import com.oms.api.TestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class TestController implements TestApi {

}
