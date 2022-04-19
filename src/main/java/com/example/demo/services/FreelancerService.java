package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Freelancer;



public interface FreelancerService  {
	public List<Freelancer> findFreelancerBySubactegoryId(Long subctatId);
	public List<Freelancer> getAllFreelancer();
	public Freelancer findFreelancerById(Long id);


}
