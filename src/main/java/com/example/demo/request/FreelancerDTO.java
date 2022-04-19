package com.example.demo.request;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.example.demo.models.Subcategory;

public class FreelancerDTO implements Serializable{



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 


	
	@Size(min = 3, max = 20)
    private String username;

	@Size(min = 6, max = 40)
    private String password;
    private int phoneNum;
   

	@Size(max = 20)
    private String fAdress;
  private float sessionPrice;
    private float hourPrice;
    
    @Size(max = 50)
    @Email
    private String email;
    private Set<String> role;
    private String aboutMe;
    
    
    
    public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	
private String image;

    public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}


   

	

	public float getSessionPrice() {
		return sessionPrice;
	}

	public void setSessionPrice(float sessionPrice) {
		this.sessionPrice = sessionPrice;
	}

	public float getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(float hourPrice) {
		this.hourPrice = hourPrice;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	private int rate;
    
    
  
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
    
    public Set<String> getRole() {
        return this.role;
      }
      
      public void setRole(Set<String> role) {
        this.role = role;
      }
}
