package com.LivraisonService;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livraison implements Serializable {


	private static final long serialVersionUID = -8671240745100317475L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long user_id;
	private Long command_id;
	private String destination;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	

	public Livraison() {
		super();
	}


	public Livraison(Long id, Long user_id, Long command_id, String destination, String description, Date date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.command_id = command_id;
		this.destination = destination;
		this.description = description;
		this.date = date;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getUser_id() {
		return user_id;
	}
	
	
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
	public Long getCommand_id() {
		return command_id;
	}
	
	
	public void setCommand_id(Long command_id) {
		this.command_id = command_id;
	}
	
	
	public String getDestination() {
		return destination;
	}
	
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Livraison [id=" + id + ", user_id=" + user_id + ", command_id=" + command_id + ", destination="
				+ destination + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	

}
