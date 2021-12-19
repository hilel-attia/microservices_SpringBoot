package Main;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ReservationService.class);
	
	public Reservation addReservation(Reservation reservation){
		Reservation reservationsaved = reservationRepository.save(reservation);
		return reservationsaved;
	}
	
	public List<Reservation> retrieveAllReservations() {
		List<Reservation> reservations= (List<Reservation>) reservationRepository.findAll();
		for (Reservation reservation : reservations){
			l.debug("Reservation ++++ : "+reservation);
		}
		return reservations;
	}
	
	
	public Reservation updateReservation(int id , Reservation newReservation){
		if(reservationRepository.findById(id).isPresent()){
			Reservation existingReservation = reservationRepository.findById(id).get();
			existingReservation.setId_client(newReservation.getId_client());   
			existingReservation.setId_vol(newReservation.getId_vol());    
			existingReservation.setId_hebergement(newReservation.getId_hebergement());  
			existingReservation.setDate_reserv(newReservation.getDate_reserv());  
			
			return reservationRepository.save(existingReservation);
		}
		else
			return null;
	}
	
	
	public String deleteReservation(int id){
		
		if(reservationRepository.findById(id).isPresent()){
			reservationRepository.deleteById(id);
			return " Reservation";
		} else 
			return "Reservation";
		}
	
}
