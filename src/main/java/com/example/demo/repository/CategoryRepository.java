package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
		//  List<Category> findByPublished(String published);
	 // Optional<Category> findByUsername(String designation);
		  List<Category> findBydesignationContaining(String designation);
		}

