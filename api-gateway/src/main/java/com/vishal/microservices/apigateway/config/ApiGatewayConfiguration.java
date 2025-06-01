package com.vishal.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator getewayRouter(RouteLocatorBuilder routeLocatorBuilder) {


        return routeLocatorBuilder.routes()
                .route(p-> p.path("/get")
                    .filters(f-> f.addRequestHeader("MYHeader","MYURI")
                            .addRequestParameter("Param","MyValue")
                    )
                    .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**")
                    .uri("lb://currency-exchange-service"))
                .route(p -> p.path("/currency-conversion/**")
                    .uri("lb://currency-conversion-service"))
                .build();
    }
}
