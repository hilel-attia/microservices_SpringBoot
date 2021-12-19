package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService {
	
	@Autowired
	private ReclamationRepository reclamationRepository;

	public Reclamation addReclamation(Reclamation reclamation) {
		return reclamationRepository.save(reclamation);
	}
	
	public Reclamation updateReclamation(int id, Reclamation newReclamation) {
		if (reclamationRepository.findById(id).isPresent()) {
			Reclamation existingReclamation = reclamationRepository.findById(id).get();
			existingReclamation.setTitre(newReclamation.getTitre());
			existingReclamation.setContenu(newReclamation.getContenu());

			return reclamationRepository.save(existingReclamation);
		} else
			return null;
	}
	
	public String deleteReclamation(int id_Rec) {
		if (reclamationRepository.findById(id_Rec).isPresent()) {
			reclamationRepository.deleteById(id_Rec);
			return "Reclamation supprimé";
		} else
			return "Reclamation non supprimé";
	}
}
