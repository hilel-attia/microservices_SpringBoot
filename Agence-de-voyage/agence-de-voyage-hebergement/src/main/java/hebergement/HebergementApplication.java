package hebergement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HebergementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HebergementApplication.class, args);
	}
	
	@Autowired
	public HebergementRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save			
			repository.save(new Hebergement("Sousse", "10/02/2021", "12/02/2021",2,2, 800));
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}
