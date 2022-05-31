package com.example.demo.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.example.demo.models.OfferNotif;
	

	

	@Repository
	public interface notifRepository extends JpaRepository<OfferNotif, Long>{
	

	}


