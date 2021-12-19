package com.ProductService.repository;

import org.springframework.data.repository.CrudRepository;

import com.ProductService.Entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
