package com.example.demo.services;


	import java.util.List;


	import com.example.demo.models.OfferNotif;


	public interface NotifServiceOffer {


		List<OfferNotif> list();
		void addNotifOffer (OfferNotif n);
		void updateNotifOffer(OfferNotif n);
		void deleteNotifOffer(Long id);
		void deleteAll();
	

}
