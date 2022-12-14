package com.example.scgateway.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder
                .routes()
                .route(predicateSpec -> predicateSpec.path("/get").uri("http://localhost:8500"))
                .route(predicateSpec -> predicateSpec.path("/get").uri("https://jsonplaceholder.typicode.com/users"))
                .build();
    }
}
