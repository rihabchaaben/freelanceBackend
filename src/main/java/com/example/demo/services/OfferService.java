package com.example.demo.services;

import java.util.List;


import com.example.demo.models.Offer;

public interface OfferService {
	public List<Offer> getAllOffers();	
	public Offer findOfferById(Long id);
	public void addOffer(Offer offer) throws Exception;
	public void deleteOffer(Long id);
	public void deleteExpiredOffer();
	public void updateOffer(Long id, Offer offer);
}
