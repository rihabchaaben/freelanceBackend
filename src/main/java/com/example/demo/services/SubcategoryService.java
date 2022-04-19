package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Category;
import com.example.demo.models.Subcategory;


public interface SubcategoryService {
	public List<Subcategory> getAllSubCategory();	
	public Subcategory findSubcategoryById(Long id);
	public void addSubcategory(Subcategory subcategory,Long id);
	public void deleteSubcategory(Long id);
	public void updateSubCategory(Long id, Subcategory subcategory);
}
