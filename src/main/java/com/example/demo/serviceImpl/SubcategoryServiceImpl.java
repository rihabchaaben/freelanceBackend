package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.exceptions.SubcategoryNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Subcategory;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.SubCategoryRepository;
import com.example.demo.services.SubcategoryService;
@Service
public class SubcategoryServiceImpl implements SubcategoryService{
	 @Autowired
	  SubCategoryRepository subcategoryRepository;
	 @Autowired
	  CategoryRepository categoryRepository;
	@Override
	public List<Subcategory> getAllSubCategory() {
		// TODO Auto-generated method stub
		return subcategoryRepository.findAll();
	}

	@Override
	public Subcategory findSubcategoryById(Long id) {
		return subcategoryRepository.findById(id).orElseThrow(() -> new
				SubcategoryNotFoundException("subcategory with ID :" + id));
	}

	@Override
	public void addSubcategory(Subcategory subcategory,Long id) {
		// TODO Auto-generated method stub
		/*Subcategory	subcategory=new Subcategory(subcat.getdesignation(),subcat.getCategory());
		subcategory.setdesignation();
		subcategory.setCategory();*/
		Category cat=	 categoryRepository.findById(id).orElseThrow(() -> new
				CategoryNotFoundException("category not found "));
		subcategory.setCategory(cat);
		subcategoryRepository.save(subcategory);
		
	}

	@Override
	public void deleteSubcategory(Long id) {
		Subcategory subcat=	 subcategoryRepository.findById(id).orElseThrow(() -> new
				SubcategoryNotFoundException("subcategory with ID :" + id));
		subcategoryRepository.delete(subcat);
	}
		

	@Override
	public void updateSubCategory(Long id, Subcategory subcat) {
		Subcategory subcategory=	 subcategoryRepository.findById(id).orElseThrow(() -> new
				SubcategoryNotFoundException("subcategory with ID :" + id));
		subcategory.setdesignation(subcat.getdesignation());
	//	subcategory.setCategory(subcat.getCategory());
		subcategoryRepository.save(subcategory);
		
	}

}
