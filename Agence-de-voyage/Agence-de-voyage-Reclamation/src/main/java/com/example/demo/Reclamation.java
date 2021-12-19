package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reclamation implements Serializable {

	
	
	
	@Id
	@GeneratedValue
	private int Id_Rec;
	private int Id_Client;
	private String Titre,Contenu;
	
	
	public Reclamation(int id_Rec, int id_Client, String titre, String contenu) {
		super();
		Id_Rec = id_Rec;
		Id_Client = id_Client;
		Titre = titre;
		Contenu = contenu;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 795450928237931201L;
	
	public int getId_Rec() {
		return Id_Rec;
	}
	public void setId_Rec(int id_Rec) {
		Id_Rec = id_Rec;
	}
	public int getId_Client() {
		return Id_Client;
	}
	public void setId_Client(int id_Client) {
		Id_Client = id_Client;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getContenu() {
		return Contenu;
	}
	public void setContenu(String contenu) {
		Contenu = contenu;
	}
	
	
	
}