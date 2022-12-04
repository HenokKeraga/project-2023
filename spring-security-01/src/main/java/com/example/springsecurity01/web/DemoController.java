package com.example.springsecurity01.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/demo",produces ="text/plain" )
    public String demo(HttpServletRequest request){
//        var header = request.getHeader();
        return "demo";
    }
}
