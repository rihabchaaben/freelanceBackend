package com.example.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "offers")
public class Offer {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	
	  private String title;	
	
	  private String description;	
	
	  private float price;
	  
	  @JsonFormat(pattern="yyyy-MM-dd")
	 private Date startDate;
	  
	     @JsonFormat(pattern="yyyy-MM-dd")
	 private Date endDate;
	
	
	//getters and setters
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	  
	  public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	// freelancer-offer
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	protected Freelancer freelancer;
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
	public Offer(Long id, @NotBlank String title, @NotBlank String description, float price, Date startDate,
			Date endDate, Freelancer freelancer) {
		super();
		this.id = id;
		title = title;
		this.description = description;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.freelancer = freelancer;
	}
	public Offer() {
		super();
	}
	

}
