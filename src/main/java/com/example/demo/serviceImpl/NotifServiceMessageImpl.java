package com.example.demo.serviceImpl;



	import java.util.List;
	

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	

	import com.example.demo.models.MessageNotif;
	import com.example.demo.repository.notifMessageRepository;
import com.example.demo.services.NotifServiceMessage;
	

	@Service
	 public class NotifServiceMessageImpl  implements NotifServiceMessage {
		
		@Autowired
		notifMessageRepository repo;
		@Override
		public List<MessageNotif> list() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}
	

		@Override
		public void addNotifMessage(MessageNotif n) {
			// TODO Auto-generated method stub
			repo.save(n);
		}
	

		@Override
		public void updateNotifMessage(MessageNotif n) {
			// TODO Auto-generated method stub
			repo.save(n);
	

		}
	

		@Override
		public void deleteNotifMessage(Long id) {
			// TODO Auto-generated method stub
			repo.delete(repo.findById(id).get());
		}
	

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			repo.deleteAll(); 
		}
	

	}





