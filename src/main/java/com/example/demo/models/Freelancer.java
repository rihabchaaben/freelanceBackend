package com.example.demo.models;

import javax.validation.constraints.Email;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.example.demo.utils.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "freelancers")

public class Freelancer extends User {
	

	public Freelancer(float hourPrice2, float sessionPrice2, int rate2,String aboutMe, @Size(max = 20) String username, int phoneNum, @Size(max = 20) String fAdress,
			String image, @Size(max = 50) @Email String email, @Size(max = 120) String password,Subcategory sucategory,Set<Role>  set) {
		super(username, phoneNum, fAdress, image, email, password, set); 
		this.hourPrice=hourPrice2;
		this.sessionPrice=sessionPrice2;
		this.rate=rate2;
		this.aboutMe=aboutMe;
		this.subcategory=sucategory;
		// TODO Auto-generated constructor stub roles
	}



	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	 private Float sessionPrice;
	  
	  private Float hourPrice;
	  @NotBlank
	  private String aboutMe;
	  
	  private int rate;
	  
	  //getters and setters  
	public Float getSessionPrice() {
		return sessionPrice;
	}
	public void setSessionPrice(Float sessionPrice) {
		this.sessionPrice = sessionPrice;
	}
	public Float getHourPrice() {
		return hourPrice;
	}
	public void setHourPrice(Float hourPrice) {
		this.hourPrice = hourPrice;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	 
	// @JsonIgnore is used to ignore the logical property used in serialization and deserialization
	  /*@JsonIgnore*/
	
	//freelancer-subcategory  

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY , cascade=CascadeType.MERGE )
	protected Subcategory subcategory; 
	 
	 

	
	   public Subcategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}


	
	  
	  
	  //offer-freelancer
	@JsonIgnore
	  @OneToMany(mappedBy = "freelancer", cascade=CascadeType.ALL, fetch=FetchType.LAZY
			 )
			private Set<Offer> offers;
	  
	  public Freelancer() {}
	
}

