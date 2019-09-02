package com.gateway.filter;

import com.gateway.filter.filters.RequestTimeFilter;
import com.gateway.filter.filters.RequestTimeGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterApplication.class, args);
	}

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
		// @formatter:off
		return builder.routes()
				.route(r -> r.path("/customer/**")
						.filters(f -> f.filter(new RequestTimeFilter())
								.addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
						.uri("http://httpbin.org:80/get")
						.order(0)
						.id("customer_filter_router")
				)
				.build();
		// @formatter:on
	}

	//向Spring IOC容器注入RequestTimeGatewayFilterFactory类的Bean
	@Bean
	public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory(){
		return new RequestTimeGatewayFilterFactory();
	}
}
