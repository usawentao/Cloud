package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		String httpUri = "http://httpbin.org:80";
		//使用RouteLocatorBuilder的bean创建路由
		return builder.routes()
				.route(p -> p
					.path("/get")
					//会将请求添加一个header，key为hello，value为world
					.filters(f -> f.addRequestHeader("Hello", "World"))
					//将请求转发到以下url
					.uri("http://httpbin.org:80"))
				.route(p -> p
					.path("/post")
					.filters(f -> f.addRequestHeader("Style","post"))
					.uri("http://httpbin.org:80"))
				.route(p -> p
					.host("*.histrix.com")
					.filters(f->f
						.hystrix(config -> config
							.setName("mycmd")
							.setFallbackUri("forward:/fallback")))
					.uri(httpUri)
				)
				.build();
	}
	@RequestMapping("/falllback")
	public Mono<String> fallback(){
		return Mono.just("fullback")
	}
}
