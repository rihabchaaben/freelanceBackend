package com.example.demo.request;

import com.example.demo.models.User;



public class UserMapper {
	public static UserDTO entityToDTO(User user) {
		UserDTO userdto = new UserDTO();
		userdto.setUsername(user.getUsername());                          
		userdto.setEmail(user.getEmail());  
		userdto.setfAdress(user.getfAdress());  
		userdto.setPhoneNum(user.getPhoneNum());
		userdto.setImage(user.getImage());
	

		
    return userdto;
}

public static User dtoToEntity(UserDTO userdto) {
    User user = new User();
    user.setUsername(userdto.getUsername())  ;             
    user.setEmail(userdto.getEmail());
    user.setfAdress(userdto.getfAdress());
    user.setImage(userdto.getImage());
    user.setPassword(userdto.getPassword());
    user.setPhoneNum(userdto.getPhoneNum());

    return user;
}
}

