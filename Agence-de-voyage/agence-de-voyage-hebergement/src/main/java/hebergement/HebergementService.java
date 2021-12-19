package hebergement;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HebergementService {
	
private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(HebergementService.class);
	
	@Autowired
	private HebergementRepository hebergementRepository;

	public Hebergement addHebergement(Hebergement hebergement) {
		return hebergementRepository.save(hebergement);
	}
	
	public Hebergement updateHebergement(int id, Hebergement newHebergement) {
		if (hebergementRepository.findById(id).isPresent()) {
			Hebergement existingHebergement = hebergementRepository.findById(id).get();
			existingHebergement.setId(newHebergement.getId());

			return hebergementRepository.save(existingHebergement);
		} else
			return null;
	}
	
	public String deleteHebergement(int id) {
		if (hebergementRepository.findById(id).isPresent()) {
			hebergementRepository.deleteById(id);
			return "hebergement supprimé";
		} else
			return "hebergement non supprimé";
	}
	public List<Hebergement> retrieveAllReservations() {
		List<Hebergement> hebergements= (List<Hebergement>) hebergementRepository.findAll();
		for (Hebergement hebergement : hebergements){
			l.debug("Hebergement ++++ : "+hebergement);
		}
		return hebergements;
	}
	
}
