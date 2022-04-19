package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Offer;

public interface OfferService {
	public List<Offer> getAllOffers();	
	public Offer findOfferById(Long id);
	public void addOffer(Offer offer,Long id) throws Exception;
	public void deleteOffer(Long id);
	public void updateOffer(Long id, Offer offer);
}
