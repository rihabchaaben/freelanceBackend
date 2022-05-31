package com.example.demo.serviceImpl;

	import java.util.List;
	

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	

	import com.example.demo.models.OfferNotif;
	import com.example.demo.repository.notifRepository;
import com.example.demo.services.NotifServiceOffer;
	

	@Service
	 public class NotifServiceOfferImpl  implements NotifServiceOffer {
		
		@Autowired
		notifRepository repo;
		@Override
		public List<OfferNotif> list() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}
	

		@Override
		public void addNotifOffer(OfferNotif n) {
			// TODO Auto-generated method stub
			repo.save(n);
		}
	

		@Override
		public void updateNotifOffer(OfferNotif n) {
			// TODO Auto-generated method stub
			repo.save(n);
	

		}
	

		@Override
		public void deleteNotifOffer(Long id) {
			// TODO Auto-generated method stub
			repo.delete(repo.findById(id).get());
		}
	

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			repo.deleteAll(); 
		}
	

	}



