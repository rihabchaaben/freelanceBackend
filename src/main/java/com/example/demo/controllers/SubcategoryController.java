package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Subcategory;
import com.example.demo.repository.SubCategoryRepository;
import com.example.demo.services.SubcategoryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/auth")
public class SubcategoryController {
	  @Autowired
	  SubCategoryRepository subcategoryRepository;
	  
	  @Autowired
	  SubcategoryService subcategoryService;
	  
	  
	  
	  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_FREELANCER')")

		@RequestMapping(value = "/subcategories", method = RequestMethod.GET)
		public List<Subcategory> findAll() {
			return subcategoryService.getAllSubCategory();
		}
		
	  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_FREELANCER')")

		@RequestMapping(value = "/subcategory/{id}", method = RequestMethod.GET)
	  ResponseEntity<Subcategory> findById(@PathVariable("id") Long id) {
	      Subcategory subcat = subcategoryService.findSubcategoryById(id);
	      return ResponseEntity.ok().body(subcat);
	  }
		

		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/subcategory/create/{id}", method = RequestMethod.POST)

		  ResponseEntity<?>CreateSubCategory(@Valid @RequestBody Subcategory subcategory,@PathVariable("id") Long id) {
			subcategoryService.addSubcategory(subcategory,id);
			//System.out.println("l id de category est"+subcategory.getCategory().getId());
			return ResponseEntity.ok().body("subcategory added with success!");
		  }
		  

		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/subcategory/update/{id}", method = RequestMethod.PUT)
		ResponseEntity<String>
		  updateSubCategory(@PathVariable("id") Long id, @RequestBody Subcategory subcategory) { 		  
			subcategoryService.updateSubCategory(id,subcategory);
			   return ResponseEntity.ok().body("subcategory modified with success!");
		  
		  }
		  

		  @PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/subcategory/delete/{id}", method = RequestMethod.DELETE)
	 ResponseEntity<String> deleteSubCategory(@PathVariable("id") Long id) { 
			  subcategoryService.deleteSubcategory(id);
			  return ResponseEntity.ok().body("subcategory deleted with success!");
		  }
	  
	}
