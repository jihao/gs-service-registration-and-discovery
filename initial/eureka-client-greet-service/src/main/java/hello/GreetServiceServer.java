package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GreetServiceServer {

	public static void main(String[] args) {
		SpringApplication.run(GreetServiceServer.class, args);
	}

}
