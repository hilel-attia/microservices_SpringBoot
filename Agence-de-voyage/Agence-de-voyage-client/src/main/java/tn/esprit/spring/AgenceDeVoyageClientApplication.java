package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class AgenceDeVoyageClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceDeVoyageClientApplication.class, args);
	}
	@Autowired
	private ClientRepository repository;
	
	@GetMapping("/Main")
	public String Mainapp(){
		return "Main app called ...";
	}
	
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			repository.save(new Client("ahmed","gharbi","ahmedt5areejheh","28609002"));
			
			repository.findAll().forEach(System.out::println);
		};
		
	}

}
