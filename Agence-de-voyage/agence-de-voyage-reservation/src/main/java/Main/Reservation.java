package Main;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 795450928237931201L;
	
	@Id
	@GeneratedValue
	private int id;
	private String id_client, id_vol , id_hebergement , Date_reserv;
	public int getId() {
		return id;
	}
	public String getId_client() {
		return id_client;
	}
	public void setId_client(String id_client) {
		this.id_client = id_client;
	}
	public String getId_vol() {
		return id_vol;
	}
	public void setId_vol(String id_vol) {
		this.id_vol = id_vol;
	}
	public String getId_hebergement() {
		return id_hebergement;
	}
	public void setId_hebergement(String id_hebergement) {
		this.id_hebergement = id_hebergement;
	}
	public String getDate_reserv() {
		return Date_reserv;
	}
	public void setDate_reserv(String date_reserv) {
		Date_reserv = date_reserv;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Reservation(String id_client, String id_vol, String id_hebergement, String date_reserv) {
		super();
		this.id_client = id_client;
		this.id_vol = id_vol;
		this.id_hebergement = id_hebergement;
		Date_reserv = date_reserv;
	}
	public Reservation() {
		super();
		
	}
	
	
	
	
	
	
	
	
	
	
}