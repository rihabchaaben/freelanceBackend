package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.exceptions.FreelancerNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
@Service
public class UserServiceImpl implements UserService  {

	
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(() -> new
				  UserNotFoundException("user with ID :" + id));
		}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(long id) {
		User user=	 userRepository.findById(id).orElseThrow(() -> new
				  UserNotFoundException("user with ID :" + id));
		userRepository.delete(user);
		
	}

}
