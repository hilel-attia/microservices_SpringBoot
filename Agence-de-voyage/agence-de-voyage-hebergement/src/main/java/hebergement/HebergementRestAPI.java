package hebergement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/hebergements")
public class HebergementRestAPI {
	
private String title="Hello , I'm the hebergement Microservice";
	
    @Autowired
	private HebergementService hebergementService;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		
		return title;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Hebergement> createHebergement(@RequestBody Hebergement hebergement) {
		return new ResponseEntity<>(hebergementService.addHebergement(hebergement), HttpStatus.OK);
	}
	
	@GetMapping("/retrieve-reservations")
	@ResponseBody
	public List<Hebergement> getReservations() {
		List<Hebergement>  list =  hebergementService.retrieveAllReservations(); 
		return list;
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Hebergement> updateCandidat(@PathVariable(value = "id") int id, @RequestBody Hebergement hebergement){
		return new ResponseEntity<>(hebergementService.updateHebergement(id, hebergement), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteHebergement(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(hebergementService.deleteHebergement(id), HttpStatus.OK);
	}

}
