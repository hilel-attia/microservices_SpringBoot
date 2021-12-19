package com.CategoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CategoryService.service.CategoryService;
import com.CategoryService.entities.Category;

@RestController
@RequestMapping("/apicategory")

public class CategoryController {

	@Autowired
	CategoryService categoryservice;

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllProduct() {
		try {
			List<Category> productList = categoryservice.getAll();

			if (productList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getProductById(@PathVariable("id") long id) {
		return ((categoryservice.findOneById(id) != null)
				? new ResponseEntity<>(categoryservice.findOneById(id), HttpStatus.CREATED)
				: new ResponseEntity<>(new Category(null, null), HttpStatus.CREATED));

	}

	@PostMapping("/category")
	public ResponseEntity<Category> createProduct(@RequestBody Category Category) {
		return ((categoryservice.add(Category) != null)
				? new ResponseEntity<>(categoryservice.add(Category), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateProduct(@PathVariable("id") long id, @RequestBody Category Category) {
		return ((categoryservice.update(Category, id) != null)
				? new ResponseEntity<>(categoryservice.update(Category, id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@DeleteMapping("/category/{id}")
	public String deleteEmployee(@PathVariable Long id) {

		return ((categoryservice.delete(id)) ? "category has been deleted successfully" : "category not deleted");
	}

}
