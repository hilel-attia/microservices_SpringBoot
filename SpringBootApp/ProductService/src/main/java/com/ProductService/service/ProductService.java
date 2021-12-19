package com.ProductService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductService.Entity.Product;
import com.ProductService.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Override
	public Product add(Product product) {
		
		return productRepository.save(product) ;
	}

	@Override
	public List<Product> getAll() {
		
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product update(Product product,Long idProduct) {
		Product prod=productRepository.findById(idProduct).orElse(null);
		if(prod!=null)
		{
			prod.setDescription(product.getDescription());
			prod.setName(product.getName());
			prod.setPrix(product.getPrix());
			prod.setImgUrl(product.getImgUrl());
			productRepository.save(prod);
			return prod;
		}
		
		return null;
	}

	@Override
	public boolean delete(Long idProduct) {
		Product prod=productRepository.findById(idProduct).orElse(null);
		if(prod!=null)
		{
			productRepository.deleteById(idProduct);
			return true;
		}
		return false;
	}

	@Override
	public Product findOneById(Long idProduct) {
		
		return productRepository.findById(idProduct).orElse(null);

	}

}
