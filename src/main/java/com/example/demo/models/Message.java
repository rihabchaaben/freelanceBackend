
package com.example.demo.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;



//@Entity
@Table(name = "messages")
public class Message {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	
	
	  //getters and setters
	 public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	@NotBlank
	  private String sender;	
	@NotBlank
	  private String reciever;	
	@NotBlank
	  private String content;	
	@NotBlank
	  private Date date;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
	
}



