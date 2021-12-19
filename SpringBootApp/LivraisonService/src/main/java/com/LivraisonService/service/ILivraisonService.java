package com.LivraisonService.service;

import java.util.List;

import com.LivraisonService.Livraison;



public interface ILivraisonService {
	
	public Livraison add(Livraison livraison);
	public List<Livraison> getAll();
	public Livraison update(Livraison livraison,Long idLivraison);
	public boolean delete(Long idLivraison);
	public Livraison findOneById(Long idLivraison);

}
