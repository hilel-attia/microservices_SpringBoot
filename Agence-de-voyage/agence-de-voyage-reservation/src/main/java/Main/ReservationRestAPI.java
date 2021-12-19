package Main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationRestAPI {
	private String title="Hello , I'm the reservations Microservice";

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	
	
	
	@GetMapping("/retrieve-reservations")
	@ResponseBody
	public List<Reservation> getReservations() {
		List<Reservation>  list =  reservationService.retrieveAllReservations(); 
		return list;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reservation> createResrvation(@RequestBody Reservation reservation){
		return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
		
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") int id,
    										@RequestBody Reservation reservation){
		return new ResponseEntity<>(reservationService.updateReservation(id, reservation), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReservation(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
	}
	
}