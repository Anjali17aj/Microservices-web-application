package com.gateway.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("jwt-service", r -> r.path("/auth/")
						.uri("lb://jwt-service"))
				.route("user-service", r -> r.path("/user/")
						.uri("lb://QUESTION-SERVICE"))
				.route("product-service", r -> r.path("/products/")
						.uri("lb://QUIZ-SERVICE"))
				.build();
	}

}
