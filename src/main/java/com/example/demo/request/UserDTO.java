package com.example.demo.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.example.demo.models.Role;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	  @Size(max = 20)
	  private String username;
	  
	private int phoneNum;
	  
	  @Size(max = 20)
	  private String fAdress;

	  private String image;
	  
	    private Set<String> role;

	  @Size(max = 50)
	  @Email
	  private String email;
	  
	  @Size(max = 120)
	  private String password;


	//getters and setters

	  public String getUsername() {
	    return username;
	  }
	  public void setUsername(String username) {
	    this.username = username;
	  }
	  public String getEmail() {
	    return email;
	  }
	  public void setEmail(String email) {
	    this.email = email;
	  }
	  public String getPassword() {
	    return password;
	  }
	  public void setPassword(String password) {
	    this.password = password;
	  }
	  public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getfAdress() {
		return fAdress;
	}
	public void setfAdress(String fAdress) {
		this.fAdress = fAdress;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set<String> role) {
		this.role = role;
	}

}
