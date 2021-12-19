package com.CategoryService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CategoryService.entities.Category;
import com.CategoryService.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category add(Category category) {
		return categoryRepository.save(category);

	}

	@Override
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();

	}

	@Override
	public Category update(Category category, Long idCategory) {
		Category cat = categoryRepository.findById(idCategory).orElse(null);
		if (cat != null) {
			cat.setName(category.getName());

			categoryRepository.save(cat);
			return cat;
		}

		return cat;
	}

	@Override
	public boolean delete(Long idCategory) {
		Optional<Category> cat = categoryRepository.findById(idCategory);
		if (cat.isPresent()) {
			categoryRepository.deleteById(idCategory);
			return true;
		}

		return false;
	}

	@Override
	public Category findOneById(Long idCategory) {
		return categoryRepository.findById(idCategory).orElse(null);
	}

}
