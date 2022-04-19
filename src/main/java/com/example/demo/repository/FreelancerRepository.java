package com.example.demo.repository;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Freelancer;


@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
	
	@Query("SELECT f from Freelancer f INNER JOIN FETCH f.subcategory where f.subcategory.id = :subctatId")
 List<Freelancer> findFreelancerBySubactegoryId(@Param("subctatId")Long subctatId);

	

	}


