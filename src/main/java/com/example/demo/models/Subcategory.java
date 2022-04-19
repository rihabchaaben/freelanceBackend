package com.example.demo.models;

import javax.validation.constraints.NotBlank;

import com.example.demo.utils.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table(name = "subcategories")
	public class Subcategory implements Serializable{
		  /**
		 * 
		 */
	private static final long serialVersionUID = 1L;

		public Subcategory( Long id ,@NotBlank String designation, Set<Freelancer> freelancers, Category category) {
			super();
		this.id=id;
			this.designation = designation;
			this.freelancers = freelancers;
			this.category = category;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		  private Long id;
		  @NotBlank
		  private String designation;
	public String getdesignation() {
			return designation;
		}
		public void setdesignation(String designation) {
			this.designation = designation;
		}
		

	
	//freelancer-subcategories
	  
		  
		  @JsonIgnore
	  @OneToMany(mappedBy = "subcategory",fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
	
			private Set<Freelancer> freelancers;
	
	  
	public Set<Freelancer> getFreelancers() {
		return freelancers;
	}

	public void setFreelancers(Set<Freelancer> freelancers) {
		this.freelancers = freelancers;
	}

	//categories-subcategories
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	protected Category category;

	public Category getCategory() {
		return category;
	}

	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Subcategory() {
		super();
	}
	}
