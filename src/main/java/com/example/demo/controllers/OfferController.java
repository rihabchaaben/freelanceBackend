package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Offer;
import com.example.demo.repository.OfferRepository;
import com.example.demo.services.OfferService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/auth")
public class OfferController {
	  @Autowired
	  OfferRepository offerRepository;
	  
	  @Autowired
	  OfferService offerService;
	  
	  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_FREELANCER','ROLE_CUSTOMER')")

		@RequestMapping(value = "/offers", method = RequestMethod.GET)
		public List<Offer> findAll() {
			return offerService.getAllOffers();
		}
		
	  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_FREELANCER')")

		@RequestMapping(value = "/offer/{id}", method = RequestMethod.GET)
	  ResponseEntity<Offer> findById(@PathVariable("id") Long id) {
	      Offer offer = offerService.findOfferById(id);
	      return ResponseEntity.ok().body(offer);
	  }
		

		@PreAuthorize("hasAnyRole('ROLE_FREELANCER','ROLE_ADMIN')")
		@RequestMapping(value = "/offer/create/{id}", method = RequestMethod.POST)

		  ResponseEntity<?>CreateOffer(@Valid @RequestBody Offer offer,@PathVariable("id") Long id) throws Exception{
			offerService.addOffer(offer,id);
			//System.out.println("l id de category est"+subcategory.getCategory().getId());
			return ResponseEntity.ok().body("offer added with success!");
		  }
		  

		@PreAuthorize("hasAnyRole('ROLE_FREELANCER','ROLE_ADMIN')")
		@RequestMapping(value = "/offer/update/{id}", method = RequestMethod.PUT)
		ResponseEntity<String>
		  updateOffer(@PathVariable("id") Long id, @RequestBody Offer offer) { 		  
			offerService.updateOffer(id,offer);
			   return ResponseEntity.ok().body("offer modified with success!");
		  
		  }
		  

		@PreAuthorize("hasAnyRole('ROLE_FREELANCER','ROLE_ADMIN')")
		@RequestMapping(value = "/offer/delete/{id}", method = RequestMethod.DELETE)
	 ResponseEntity<String> deleteSubCategory(@PathVariable("id") Long id) { 
			  offerService.deleteOffer(id);
			  return ResponseEntity.ok().body("offer deleted with success!");
		  }
	  
	  
	  
}
