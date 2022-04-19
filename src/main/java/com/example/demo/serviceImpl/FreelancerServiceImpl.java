package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.FreelancerNotFoundException;
import com.example.demo.models.Freelancer;
import com.example.demo.repository.FreelancerRepository;
import com.example.demo.services.FreelancerService;
@Service
public class FreelancerServiceImpl implements FreelancerService{
	@Autowired
	private FreelancerRepository freelancerRepository;
	
	
	@Override
	public List<Freelancer> findFreelancerBySubactegoryId(Long subctatId) {
		// TODO Auto-generated method stub
		return freelancerRepository.findFreelancerBySubactegoryId(subctatId);
	}

	@Override
	public List<Freelancer> getAllFreelancer() {
		// TODO Auto-generated method stub
		return freelancerRepository.findAll();
	}

	@Override
	public Freelancer findFreelancerById(Long id) {
		// TODO Auto-generated method stub
		return freelancerRepository.findById(id).orElseThrow(() -> new
				  FreelancerNotFoundException("freelancer with ID :" + id));
	}

}
