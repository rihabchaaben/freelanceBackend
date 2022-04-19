package com.example.demo.models;

import java.util.HashSet;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Entity

@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="user_type")
@Table(name = "users")
       
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Size(max = 20)
  private String username;
  
private int phoneNum;
  
  @Size(max = 20)
  private String fAdress;

  private String image;
  
 
  
  @Size(max = 50)
  @Email
  private String email;
  
  @Size(max = 120)
  private String password;
  
  
  public User(Long id,  @Size(max = 20) String username, int phoneNum,
		 @Size(max = 20) String fAdress,  String image,
		  @Size(max = 50) @Email String email,  @Size(max = 120) String password,
		Set<Role> roles) {
	super();
	this.id = id;
	this.username = username;
	this.phoneNum = phoneNum;
	this.fAdress = fAdress;
	this.image = image;
	this.email = email;
	this.password = password;
	this.roles = roles;
}
@ManyToMany
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
  
  //constructors
public User(@Size(max = 20) String username2, int phoneNum2, @Size(max = 20) String fAdress2, String image2, @Size(max = 50) @Email String email2, @Size(max = 120) String password2, Set<Role> roles2) {
	this.username = username2;
	  
    this.phoneNum = phoneNum2;
    this.fAdress = fAdress2;
    this.email = email2;
    this.image=image2;
    this.roles=roles2;
    this.password = password2;
    
	
}



public User(String username,  String password ) {
    this.username = username;
  
    this.password = password;
 
}

  public User(String username, String email, String password ,String fAdress,int phoneNum) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.fAdress=fAdress;
    this.phoneNum=phoneNum;
  }
  public User() {}
  
  
  
  
  public User(String username2, String email2, String getfAdress, int phoneNum2, String encode) {
	  this.username=username2;
	  this.email=email2;
	  this.fAdress=getfAdress;
	  this.phoneNum=phoneNum2;
	  this.password=encode;
	// TODO Auto-generated constructor stub
}










//getters and setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
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

public Set<Role> getRoles() {
    return roles;
  }
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
