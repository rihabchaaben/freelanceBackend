package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	

	@Override
	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new
				  CategoryNotFoundException("category with ID :" + id));
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);	
	}



	@Override
	public void deleteCategory(Long id) {
	Category cat=	 categoryRepository.findById(id).orElseThrow(() -> new
	  CategoryNotFoundException("category with ID :" + id));
	categoryRepository.delete(cat);
	}
	public void updateCategory (Long id,Category category) {
		Category cat=	 categoryRepository.findById(id).orElseThrow(() -> new
					  CategoryNotFoundException("category with ID :" + id));
		cat.setDesignation(category.getDesignation());
		categoryRepository.save(cat);
		}

	
}
