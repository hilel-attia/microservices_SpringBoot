package Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;




@SpringBootApplication
@EnableEurekaServer

public class EurekaServerDeploymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerDeploymentApplication.class, args);
	}
	

}
