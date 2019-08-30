package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		//使用RouteLocatorBuilder的bean创建路由
		return builder.routes()
				.route(p -> p
					.path("/get")
					//会将请求添加一个header，key为hello，value为world
					.filters(f -> f.addRequestHeader("Hello", "World"))
					//将请求转发到以下url
					.uri("http://httpbin.org:80"))
				.build();
	}
}
