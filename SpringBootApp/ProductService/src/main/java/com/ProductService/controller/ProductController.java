package com.ProductService.controller;

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
import org.springframework.web.client.RestTemplate;

import com.ProductService.Entity.Category;
import com.ProductService.Entity.Product;
import com.ProductService.Entity.ProductCategory;
import com.ProductService.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/apiproduct")

public class ProductController {
	private static final Logger L = LogManager.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() {
		try {
			List<Product> productList = productService.getAll();

			if (productList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductCategory> getProductById(@PathVariable("id") long id) {
		Category result = restTemplate.getForObject("http://127.0.0.1:8087/apicategory/category/1", Category.class);
		Product prod = productService.findOneById(id);
		ProductCategory product = new ProductCategory(prod, result.getName());

		return ((productService.findOneById(id) != null) ? new ResponseEntity<>(product, HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PostMapping("/product")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		Category category = restTemplate
				.getForObject("http://127.0.0.1:8888/apicategory/category/" + product.getCategoryId(), Category.class);

		L.info(product.getCategoryId());
		return ((productService.add(product) != null && category.getId() != null)
				? new ResponseEntity<>("product added successfully", HttpStatus.CREATED)
				: new ResponseEntity<>("probleme detected verify your data", HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {

		return ((productService.update(product, id) != null)
				? new ResponseEntity<>(productService.update(product, id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@DeleteMapping("/product/{id}")
	public String deleteEmployee(@PathVariable Long id) {

		return ((productService.delete(id)) ? "product has been deleted successfully" : "product not deleted");
	}

}
