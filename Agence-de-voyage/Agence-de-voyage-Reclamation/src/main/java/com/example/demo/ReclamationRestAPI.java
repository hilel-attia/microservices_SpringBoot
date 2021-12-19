package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/reclamation")
public class ReclamationRestAPI {
   
	private String title="Hello , I'm the reclamation Microservice";
	
    @Autowired
	private ReclamationService reclamationService;
    
    @Autowired
	private ReclamationRepository recRep;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		
		return title;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reclamation> createCandidat(@RequestBody Reclamation reclamation) {
		return new ResponseEntity<>(reclamationService.addReclamation(reclamation), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable(value = "id") int id,
    										@RequestBody Reclamation reclamation){
		return new ResponseEntity<>(reclamationService.updateReclamation(id, reclamation), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReclamation(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(reclamationService.deleteReclamation(id), HttpStatus.OK);
	}
	
	@RequestMapping("/all")
	public List<Reclamation> show() {
		return this.recRep.findAll();
		
		
	}
	
	

}
