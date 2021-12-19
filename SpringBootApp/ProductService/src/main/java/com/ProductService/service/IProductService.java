package com.ProductService.service;

import java.util.List;

import com.ProductService.Entity.Product;

public interface IProductService {
	
	public Product add(Product product);
	public List<Product> getAll();
	public Product update(Product product,Long idProduct);
	public boolean delete(Long idProduct);
	public Product findOneById(Long idProduct);

	

}
