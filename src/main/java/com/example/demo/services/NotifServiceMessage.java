package com.example.demo.services;




	import java.util.List;


	import com.example.demo.models.MessageNotif;


	public interface NotifServiceMessage {


		List<MessageNotif> list();
		void addNotifMessage (MessageNotif n);
		void updateNotifMessage(MessageNotif n);
		void deleteNotifMessage(Long id);
		void deleteAll();
	

}


