package com.feedback.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 404059452688853613L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long user_id;
	private Long product_id;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	
	public Comment() {
		super();
	}
	public Comment(Long id, Long user_id, Long product_id, String description, Date date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.description = description;
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
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", description="
				+ description + ", date=" + date + "]";
	}
	
	
	

}
