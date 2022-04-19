package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;
import com.example.demo.models.Subcategory;
@Repository
public interface SubCategoryRepository extends JpaRepository<Subcategory, Long> {
	  List<Category> findBydesignationContaining(String designation);
		  }
