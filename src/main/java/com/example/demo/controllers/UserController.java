package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
//import org.springframework.web.bind.annotation.RequestMethod;

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
	 
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 @RequestMapping(value="/currentUser", method=RequestMethod.GET)
	    ResponseEntity<User> findCurrentUser() {
		User user=userService.currentUser();
	        return ResponseEntity.ok().body(user);
	    }
	 
	  
	  }

