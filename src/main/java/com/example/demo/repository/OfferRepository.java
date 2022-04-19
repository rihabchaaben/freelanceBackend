package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Offer;


public interface OfferRepository extends JpaRepository<Offer, Long> {

}
