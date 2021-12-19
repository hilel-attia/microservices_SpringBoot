package com.esprit.av.vol;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id_vol;
	private String compagnie_aerienne, depart, destination, date_depart, date_arrivee;
	private int duree;
	private String classe;
	private int Tarif;
	
	public Vol() {
		super();
	}

	public Vol(int id_vol) {
		super();
		this.id_vol = id_vol;
	}

	public Vol(String compagnie_aerienne, String départ, String destination, String date_depart,
			String date_arrivee, int duree, String classe, int tarif) {
		super();
		this.compagnie_aerienne = compagnie_aerienne;
		this.depart = depart;
		this.destination = destination;
		this.date_depart = date_depart;
		this.date_arrivee = date_arrivee;
		this.duree = duree;
		this.classe = classe;
		Tarif = tarif;
	}

	public Vol(int id_vol, String compagnie_aerienne, String départ, String destination, String date_depart,
			String date_arrivee, int duree, String classe, int tarif) {
		super();
		this.id_vol = id_vol;
		this.compagnie_aerienne = compagnie_aerienne;
		this.depart = départ;
		this.destination = destination;
		this.date_depart = date_depart;
		this.date_arrivee = date_arrivee;
		this.duree = duree;
		this.classe = classe;
		Tarif = tarif;
	}

	public int getId_vol() {
		return id_vol;
	}

	public void setId_vol(int id_vol) {
		this.id_vol = id_vol;
	}

	public String getCompagnie_aerienne() {
		return compagnie_aerienne;
	}

	public void setCompagnie_aerienne(String compagnie_aerienne) {
		this.compagnie_aerienne = compagnie_aerienne;
	}

	public String getDépart() {
		return depart;
	}

	public void setDépart(String départ) {
		this.depart = départ;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate_depart() {
		return date_depart;
	}

	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}

	public String getDate_arrivee() {
		return date_arrivee;
	}

	public void setDate_arrivee(String date_arrivee) {
		this.date_arrivee = date_arrivee;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getTarif() {
		return Tarif;
	}

	public void setTarif(int tarif) {
		Tarif = tarif;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_vol;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vol other = (Vol) obj;
		if (id_vol != other.id_vol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vol [id_vol=" + id_vol + ", compagnie_aerienne=" + compagnie_aerienne + ", départ=" + depart
				+ ", destination=" + destination + ", date_depart=" + date_depart + ", date_arrivee=" + date_arrivee
				+ ", duree=" + duree + ", classe=" + classe + ", Tarif=" + Tarif + "]";
	}

}