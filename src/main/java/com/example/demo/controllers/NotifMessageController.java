package com.example.demo.controllers;


	import java.util.ArrayList;


	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.MessageNotif;
import com.example.demo.services.NotifServiceMessage;
	

	@RestController 
	public class NotifMessageController { 
		@Autowired
		private NotifServiceMessage ns; 

		@GetMapping("/") 
		public List<MessageNotif> getAllNotifications(){ 
			List<MessageNotif> n = new ArrayList<MessageNotif>();
			n=ns.list();
			return n; 
		}
		@GetMapping("/notificationsVue") 
		public int notificationsVue(){ 
			List<MessageNotif> n = new ArrayList<MessageNotif>();
			n=ns.list();
			for(int i=0;i<n.size();i++) {
				MessageNotif not = n.get(i);
				not.setStatut(true);
				ns.updateNotifMessage(not);				
			}
			return getAllNbNotifications();
		}
		@GetMapping("/nbNotifs") 
		public int getAllNbNotifications(){ 
			List<MessageNotif> n = new ArrayList<MessageNotif>();
			int j =0;
			n=ns.list();
			for(int i=0;i<n.size();i++) {
				MessageNotif not = n.get(i);
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

		
			 
	



