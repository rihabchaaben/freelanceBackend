package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
//import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.request.CategoryDTO;
import com.example.demo.request.CategoryMapper;
import com.example.demo.request.UserDTO;
import com.example.demo.request.UserMapper;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value="/api/auth/")

public class UserController {
	
	AuthenticationManager authenticationManager;
	  @Autowired
	  UserRepository userRepository;
	  @Autowired
	  RoleRepository roleRepository;
	  @Autowired
	  AdminRepository adminRepository;
	  @Autowired
	     CustomerRepository customerRepository;
	  @Autowired
	     UserService userService;
	
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 
	 @RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	 ResponseEntity<String>
	  deleteUser(@PathVariable("id") Long id) { 
		 userService.deleteUser(id);
		  return ResponseEntity.ok().body("user deleted with success!");
	  }
	 
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/users")
	  public List<User> getAllusers(){
	      return userService.getAllUsers();
	  }
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	    ResponseEntity<User> findById(@PathVariable("id") Long id) {
		User user=userService.findUserById(id);
	        return ResponseEntity.ok().body(user);
	    }
	 
	  
	  
	  }

