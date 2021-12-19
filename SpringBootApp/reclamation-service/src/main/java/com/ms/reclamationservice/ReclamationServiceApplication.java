package com.ms.reclamationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RestController
@RequestMapping("/api/reclamation")
@RefreshScope
@EnableEurekaClient
public class ReclamationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationServiceApplication.class, args);
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String findAll() {
        return "Louay Hello !";
    }

}
