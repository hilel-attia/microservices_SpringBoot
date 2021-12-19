package com.ProductService.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Product implements Serializable{
	

	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String imgUrl;
	private String description;
	private Float prix;
	private Long categoryId;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String description, Float prix, Long categoryId,String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.prix = prix;
		this.categoryId = categoryId;
		this.imgUrl=imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl + ", description=" + description
				+ ", prix=" + prix + ", categoryId=" + categoryId + "]";
	}
	

	
	
	
	
}

