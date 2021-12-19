package com.LivraisonService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.LivraisonService.Livraison;
import com.LivraisonService.service.LivraisonService;


@RestController
@RequestMapping("/apilivraison")
public class LivraisonController {
	
	@Autowired
	LivraisonService livraisonService;
	
	
	@GetMapping("/livraisons")
	public ResponseEntity<List<Livraison>> getAllLivraisons() {
		try {
			List<Livraison> LivraisonList = livraisonService.getAll();

			if (LivraisonList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(LivraisonList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/livraison/{id}")
	public ResponseEntity<Livraison> getLivraisonById(@PathVariable("id") long id) {
		return ((livraisonService.findOneById(id) != null)
				? new ResponseEntity<>(livraisonService.findOneById(id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PostMapping("/livraison")
	public ResponseEntity<Livraison> createLivraison(@RequestBody Livraison Livraison) {
		return ((livraisonService.add(Livraison) != null)
				? new ResponseEntity<>(livraisonService.add(Livraison), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PutMapping("/livraison/{id}")
	public ResponseEntity<Livraison> updateLivraison(@PathVariable("id") long id, @RequestBody Livraison Livraison) {
		return ((livraisonService.update(Livraison, id) != null)
				? new ResponseEntity<>(livraisonService.update(Livraison, id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@DeleteMapping("/livraison/{id}")
	public ResponseEntity<Livraison> deleteLivraison(@PathVariable("id") long id) {
		return ((livraisonService.delete(id))
				? new ResponseEntity<>(null, HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
