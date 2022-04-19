package com.example.demo.controllers;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Role;
import com.example.demo.models.Subcategory;
import com.example.demo.models.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.FreelancerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.SubCategoryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.models.Admin;
import com.example.demo.models.Customer;
import com.example.demo.models.Erole.ERole;
import com.example.demo.models.Freelancer;
import com.example.demo.request.FreelancerDTO;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.SignupRequest;
import com.example.demo.response.MessageResponse;
import com.example.demo.response.UserInfoResponse;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailImpl;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
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
  SubCategoryRepository subcategoryRepository;
  @Autowired
  FreelancerRepository freelancerRepository;
  @Autowired
  PasswordEncoder encoder;
  @Autowired
  JwtUtils jwtUtils;
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();
    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        .body(new UserInfoResponse(userDetails.getId(),
                                   userDetails.getUsername(),
                                   userDetails.getEmail(),
                                   roles));
  }
  
  
  
  
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }
    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            signUpRequest.getfAdress(),
            signUpRequest.getPhoneNum(),
            encoder.encode(signUpRequest.getPassword()));
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
    if (strRoles == null) {
      Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(customerRole);
     // Customer customer =new Customer(signUpRequest.getUsername(),signUpRequest.getPhoneNum(), encoder.encode(signUpRequest.getPassword()),roles);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);
          Admin admin =new Admin(signUpRequest.getUsername(),
        		  signUpRequest.getPhoneNum(),
        		  signUpRequest.getfAdress(),
        		  signUpRequest.getImage(),
        		  signUpRequest.getEmail(),
        		  encoder.encode(signUpRequest.getPassword()),
        		  roles);
          adminRepository.save(admin);
          break;
        case "freelancer":
          Role freelancerRole = roleRepository.findByName(ERole.ROLE_FREELANCER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(freelancerRole);
         
      
          Freelancer freelancer=new Freelancer(signUpRequest.getHourPrice(),
        		  signUpRequest.getSessionPrice(),
        		  signUpRequest.getRate(),
        		  signUpRequest.getAboutMe(),
        		  signUpRequest.getUsername(), 
        		  signUpRequest.getPhoneNum(),
        		  signUpRequest.getfAdress(),
        		  signUpRequest.getImage(),
        		  signUpRequest.getEmail(), 
          encoder.encode(signUpRequest.getPassword()),
          signUpRequest.getSubcategory(),
        		 roles
        		 ); 
       
          
        		  freelancerRepository.save(freelancer);
          
          break;
        default:
          Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(customerRole);
          Customer customer =new Customer(signUpRequest.getUsername(),
        		  signUpRequest.getPhoneNum(),
        		  signUpRequest.getfAdress(),
        		  signUpRequest.getImage(),
        		  signUpRequest.getEmail(),
        		  encoder.encode(signUpRequest.getPassword()),
        		  roles);

          customerRepository.save(customer);
        }
      });
    }
   // user.setRoles(roles);
   // userRepository.save(user);
    //System.out.println("id subcategory:"+signUpRequest.getSubcategory().getId());
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
  
 
  
}
