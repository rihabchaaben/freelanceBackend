package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MessageNotif;

@Repository
	public interface notifMessageRepository extends JpaRepository<MessageNotif, Long>{
	

	}




