package com.example.demo.request;

import java.io.Serializable;
import java.util.Set;

import com.example.demo.models.Subcategory;

public class CategoryDTO implements Serializable{



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	 private Set<Subcategory> subcategories;
	 
	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(Set<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	private String designation;
	 
}