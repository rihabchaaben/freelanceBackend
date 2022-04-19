package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Freelancer;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FreelancerRepository;
import com.example.demo.services.FreelancerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/auth")
public class MarkateplaceController {
	
	AuthenticationManager authenticationManager;
	  @Autowired
	  FreelancerRepository freelancerRepository;
	  @Autowired
	  CategoryRepository categoryRepository;
	  @Autowired
	FreelancerService  freelancerService;
	  
	  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_FREELANCER')")
		@RequestMapping(value = "/freelancers", method = RequestMethod.GET)
		@ResponseBody public List<Freelancer> getAllfreelancers(){
			return freelancerService.getAllFreelancer();
		}
		
		/**
		 * findEnseignentsBySubCategory
		 * @param subcatId
		 * @return
		 */
	
	 @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_FREELANCER')")
		@RequestMapping(value = "/freelancersBySubcategory/{subctatId}", method = RequestMethod.GET)
		@ResponseBody public List<Freelancer> findEnseignentsByEcole(@PathVariable("subctatId") Long subctatId){
			return freelancerService.findFreelancerBySubactegoryId(subctatId);
		}
		
		
		/* findEnseignentById
		 * @param id
		 * @return
		 */
	  @PreAuthorize("hasAnyRole('ROLE_ADMIN''ROLE_CUSTOMER','ROLE_FREELANCER')")
		@RequestMapping(value = "/freelancer/{id}", method = RequestMethod.GET)
		@ResponseBody public Freelancer findFreelancerById(@PathVariable("id") Long id){
			return freelancerService.findFreelancerById(id);
		}
		
}