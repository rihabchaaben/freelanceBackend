package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.OfferNotif;
import com.example.demo.services.NotifServiceOffer;
@RestController
public class NotifOfferController {
	@Autowired
	private NotifServiceOffer ns; 

	@GetMapping("/") 
	public List<OfferNotif> getAllNotifications(){ 
		List<OfferNotif> n = new ArrayList<OfferNotif>();
		n=ns.list();
		return n; 
	}
	@GetMapping("/notificationsVue") 
	public int notificationsVue(){ 
		List<OfferNotif> n = new ArrayList<OfferNotif>();
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			OfferNotif not = n.get(i);
			not.setStatut(true);
			ns.updateNotifOffer(not);				
		}
		return getAllNbNotifications();
	}
	@GetMapping("/nbNotifs") 
	public int getAllNbNotifications(){ 
		List<OfferNotif> n = new ArrayList<OfferNotif>();
		int j =0;
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			OfferNotif not = n.get(i);
			if(!not.isStatut())
				j++;
		}
		return j; 
	}
	@DeleteMapping("/")
	public void deleteAll() {
		ns.deleteAll();
	}
}
