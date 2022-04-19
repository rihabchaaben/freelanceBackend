package com.example.demo.controllers;
import java.net.URI;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.SubCategoryRepository;
import com.example.demo.services.CategoryService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/auth")
 public class CategoryController { 
	
  @Autowired
 CategoryRepository categoryRepository;
  @Autowired
  SubCategoryRepository subcategoryRepository;
  
  @Autowired
  CategoryService categoryService;
  
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_FREELANCER')")

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<Category> findAll() {
		return categoryService.getAllCategory();
	}
	
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_FREELANCER')")

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
  ResponseEntity<Category> findById(@PathVariable("id") Long id) {
      Category cat = categoryService.findCategoryById(id);
      return ResponseEntity.ok().body(cat);
  }
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/category/create", method = RequestMethod.POST)

	  ResponseEntity<?>CreateCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		return ResponseEntity.ok().body("category added with success!");
	  }
	  

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/category/update/{id}", method = RequestMethod.PUT)
	ResponseEntity<String>
	  updateCategory(@PathVariable("id") Long id, @RequestBody Category category) { 		  
		  categoryService.updateCategory(id,category);
		   return ResponseEntity.ok().body("category modified with success!");
	  
	  }
	  

	  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_FREELANCER')")
	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.DELETE)
 ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) { 
		categoryService.deleteCategory(id);
		  return ResponseEntity.ok().body("category deleted with success!");
	  }
  
}