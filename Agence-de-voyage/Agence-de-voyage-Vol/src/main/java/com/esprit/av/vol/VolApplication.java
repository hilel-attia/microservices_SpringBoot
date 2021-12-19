package com.esprit.av.vol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class VolApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolApplication.class, args);
	}
	
	@Autowired
	public VolRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save			
			repository.save(new Vol("Tunisaire", "Tunis", "Paris", "12/12/2021", "12/12/2021", 1, "first_classe", 800));
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}
