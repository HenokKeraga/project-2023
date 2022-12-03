package com.example.springretry.web;

import com.example.springretry.service.DemoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoProxy demoProxy;

    public DemoController(DemoProxy demoProxy) {
        this.demoProxy = demoProxy;
    }

    @GetMapping("/")
    public String demo() {

        return demoProxy.slow();
    }
}
