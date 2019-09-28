package com.dox.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DoxDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoxDiscoveryServerApplication.class, args);
	}

}
