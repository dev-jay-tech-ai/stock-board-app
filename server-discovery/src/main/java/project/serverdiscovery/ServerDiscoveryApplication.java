package project.serverdiscovery;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class ServerDiscoveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerDiscoveryApplication.class, args);
	}

}
