package com.example.springretry.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DemoProxy {

    private final RestTemplateBuilder restTemplateBuilder;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public DemoProxy(RestTemplateBuilder restTemplateBuilder, CircuitBreakerFactory circuitBreakerFactory) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @Retryable(value = RuntimeException.class)
    public String slow() {
        System.out.println("slow )...");
        var restTemplate = restTemplateBuilder.build();
//        if(1==1) throw new RuntimeException(" ex");

        return circuitBreakerFactory
                .create("slow")
                .run(() -> restTemplate.getForObject("/slow", String.class), throwable -> "fallback resilience4j ");
    }
    @Recover
    public String recover(){
        return  "fallback retry";
    }
}
