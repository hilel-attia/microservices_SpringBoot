package com.CategoryService.repository;
import org.springframework.data.repository.CrudRepository;

import com.CategoryService.entities.Category;


public interface CategoryRepository extends CrudRepository<Category,Long> {

}
