package com.LivraisonService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LivraisonService.Livraison;
import com.LivraisonService.repository.LivraisonRepository;

@Service
public class LivraisonService implements ILivraisonService {
	
	@Autowired
	LivraisonRepository livraisonRepository;

	@Override
	public Livraison add(Livraison livraison) {
		return livraisonRepository.save(livraison) ;
	}

	@Override
	public List<Livraison> getAll() {
		return (List<Livraison>) livraisonRepository.findAll();
	}

	@Override
	public Livraison update(Livraison livraison, Long idLivraison) {
		Livraison liv=livraisonRepository.findById(idLivraison).orElse(null);
		if(liv!=null)
		{
			liv.setDescription(livraison.getDescription());
			//liv.setDate(livraison.getDate());
			liv.setDestination(livraison.getDestination());
			livraisonRepository.save(liv);
			return liv;
		}
		
		return null;
	}

	@Override
	public boolean delete(Long idLivraison) {
		Livraison prod=livraisonRepository.findById(idLivraison).get();
		if(prod!=null)
		{
			livraisonRepository.deleteById(idLivraison);
			return true;
		}
		return false;
	}

	@Override
	public Livraison findOneById(Long idLivraison) {
		return livraisonRepository.findById(idLivraison).orElse(null);
	}

}
