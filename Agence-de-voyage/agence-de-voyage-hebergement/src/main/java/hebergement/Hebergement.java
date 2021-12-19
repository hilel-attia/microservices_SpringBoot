package hebergement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hebergement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3499397940687711396L;
	
	@Id
	@GeneratedValue
	private int id;
	private String destination, date_arrivee, date_depart;
	private int nbr_personnes, nbr_nuitees, tarif;
	public Hebergement() {
		super();
	}
	public Hebergement(int id) {
		super();
		this.id = id;
	}
	public Hebergement(String destination, String date_arrivee, String date_deepart, int nbr_personnes,
			int nbr_nuitees, int tarif) {
		super();
		this.destination = destination;
		this.date_arrivee = date_arrivee;
		this.date_depart = date_deepart;
		this.nbr_personnes = nbr_personnes;
		this.nbr_nuitees = nbr_nuitees;
		this.tarif = tarif;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate_arrivee() {
		return date_arrivee;
	}
	public void setDate_arrivee(String date_arrivee) {
		this.date_arrivee = date_arrivee;
	}
	public String getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}
	public int getNbr_personnes() {
		return nbr_personnes;
	}
	public void setNbr_personnes(int nbr_personnes) {
		this.nbr_personnes = nbr_personnes;
	}
	public int getNbr_nuitees() {
		return nbr_nuitees;
	}
	public void setNbr_nuitees(int nbr_nuitees) {
		this.nbr_nuitees = nbr_nuitees;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_arrivee == null) ? 0 : date_arrivee.hashCode());
		result = prime * result + ((date_depart == null) ? 0 : date_depart.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + id;
		result = prime * result + nbr_nuitees;
		result = prime * result + nbr_personnes;
		result = prime * result + tarif;
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
		Hebergement other = (Hebergement) obj;
		if (date_arrivee == null) {
			if (other.date_arrivee != null)
				return false;
		} else if (!date_arrivee.equals(other.date_arrivee))
			return false;
		if (date_depart == null) {
			if (other.date_depart != null)
				return false;
		} else if (!date_depart.equals(other.date_depart))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (id != other.id)
			return false;
		if (nbr_nuitees != other.nbr_nuitees)
			return false;
		if (nbr_personnes != other.nbr_personnes)
			return false;
		if (tarif != other.tarif)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Hebergement [id=" + id + ", destination=" + destination + ", date_arrivee=" + date_arrivee
				+ ", date_depart=" + date_depart + ", nbr_personnes=" + nbr_personnes + ", nbr_nuitees=" + nbr_nuitees
				+ ", tarif=" + tarif + "]";
	}
	
	

}
