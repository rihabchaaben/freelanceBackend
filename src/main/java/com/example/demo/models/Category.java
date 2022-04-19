package com.example.demo.models;


import java.io.Serializable;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "categories")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;

	  @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  
	  
	  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category(@NotBlank String designation) {
		super();
	
		this.designation = designation;
		
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", designation=" + designation + ", subcategories=" + subcategories + "]";
	}
	
	@NotBlank
	  private String designation;
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(Set<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	

	@JsonIgnore
	  @OneToMany( mappedBy = "category", fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
	private Set<Subcategory> subcategories;

	 
	
	public Category() {}
	
}
