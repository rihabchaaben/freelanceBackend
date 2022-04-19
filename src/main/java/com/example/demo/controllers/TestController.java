package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }
  @PreAuthorize("hasRole('CUSTOMER') or hasRole('FREELANCER') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }
  @GetMapping("/freelancer")
  @PreAuthorize("hasRole('FREELANCER')")
  public String freelancerAccess() {
    return "freelancer Board.";
  }
  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
    
  }
  @GetMapping("/customer")
  @PreAuthorize("hasRole('CUSTOMER')")
  public String customerAccess() {
    return "customer Board.";
  }
}

