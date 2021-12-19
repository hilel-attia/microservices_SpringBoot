package com.CategoryService.service;

import java.util.List;

import com.CategoryService.entities.Category;


public interface ICategoryService {
	
	public Category add(Category category);
	public List<Category> getAll();
	public Category update(Category category,Long idCategory);
	public boolean delete(Long idCategory);
	public Category findOneById(Long idCategory);

}
