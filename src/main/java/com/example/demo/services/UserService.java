package com.example.demo.services;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {
	public User findUserById(long id);
	public List <User>getAllUsers();
	public void deleteUser(long id);


}
