package com.example.demo.request;

import com.example.demo.models.Freelancer;

public class FreelancerMapper {
	
	
	
	public static Freelancer dtoToEntity(SignupRequest userdto) {
	    Freelancer user = new Freelancer();
	    user.setUsername(userdto.getUsername())  ;             
	    user.setEmail(userdto.getEmail());
	    user.setfAdress(userdto.getfAdress());
	    user.setImage(userdto.getImage());
	    user.setPassword(userdto.getPassword());
	    user.setPhoneNum(userdto.getPhoneNum());

	    return user;
	}
}
