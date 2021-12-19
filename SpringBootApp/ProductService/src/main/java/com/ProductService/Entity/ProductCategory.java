package com.ProductService.Entity;

public class ProductCategory {
	private Product product;
	private String category;

	public ProductCategory(Product product, String category) {
		super();
		this.product = product;
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "PoductCategory [product=" + product + ", category=" + category + "]";
	}

}
