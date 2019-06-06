package com.eureka.register2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Register2Application {

	public static void main(String[] args) {
		SpringApplication.run(Register2Application.class, args);
	}

}
