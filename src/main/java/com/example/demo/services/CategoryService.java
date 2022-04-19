package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Category;


public interface CategoryService {
public List<Category> getAllCategory();	
	public Category findCategoryById(Long id);
	public void addCategory(Category category);
	public void deleteCategory(Long id);
	public void updateCategory(Long id,Category cat);
}
