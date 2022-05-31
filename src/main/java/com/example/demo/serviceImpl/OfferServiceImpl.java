package com.example.demo.serviceImpl;

import java.time.LocalDate;

import java.time.LocalTime;
import java.time.ZoneId;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.FreelancerNotFoundException;
import com.example.demo.exceptions.OfferNotFoundException;
import com.example.demo.models.Freelancer;
import com.example.demo.models.Offer;
import com.example.demo.models.User;
import com.example.demo.repository.FreelancerRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.services.OfferService;
import com.example.demo.services.UserService;
@Service
public class OfferServiceImpl implements OfferService{
	
	 @Autowired
	  FreelancerRepository freelancerRepository;
	 @Autowired
	  OfferRepository offerRepository;
	 @Autowired
	 UserService userservice;
	@Override
	public List<Offer> getAllOffers() {
		// TODO Auto-generated method stub
		return offerRepository.findAll();
	}

	@Override
	public Offer findOfferById(Long id) {
		// TODO Auto-generated method stub
		return offerRepository.findById(id).orElseThrow(() -> new
				OfferNotFoundException("offer with ID :" + id));
	}

	@Override
	public void addOffer(Offer offer) throws Exception{
		// TODO Auto-generated method stub
		User user=userservice.currentUser();
		Freelancer free=freelancerRepository.findById(user.getId()).orElseThrow(() -> new
				FreelancerNotFoundException("freelancer not found "));
		System.out.println("freelancer id"+free.getId());
		offer.setFreelancer(free); 
		offerRepository.save(offer);
		/*sDate1=offer.getEndDate();
		sDate2=offer.getEndDate();
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);  */

	
		
		
	}

	@Override
	public void deleteOffer(Long id) {
		// TODO Auto-generated method stub
		Offer offer=	 offerRepository.findById(id).orElseThrow(() -> new
				OfferNotFoundException("offer with ID :" + id));
		offerRepository.delete(offer);
	}

	@Override
	public void updateOffer(Long id, Offer offer) {
		Offer offerr=offerRepository.findById(id).orElseThrow(() -> new
				OfferNotFoundException("offer with ID :" + id));
		offerr.setDescription(offer.getDescription());
		offerr.setEndDate(offer.getEndDate());
		offerr.setPrice(offer.getPrice());
		offerr.setStartDate(offer.getStartDate());
		offerr.setTitle(offer.getTitle());
		offerRepository.save(offerr);
		
	}

	@Override
	public void deleteExpiredOffer() {
		// TODO Auto-generated method stub
		List<Offer> offers=getAllOffers();
		LocalDate localDate = LocalDate.now();
	for (Offer off:offers ) {
		
		LocalDate offerendDate=off.getEndDate().toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
int res=offerendDate.compareTo(localDate);
		if( res< 0) {
			offerRepository.delete(off);

		}
	
	
	}
		
	}

}
