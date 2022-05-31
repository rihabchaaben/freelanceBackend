package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MessageNotif 	{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id; 
    private String contenu; 
    private boolean statut ; 


    public MessageNotif() {
		// TODO Auto-generated constructor stub
	} 
	public MessageNotif(Long id, String contenu, boolean statut) { 


		super(); 


		this.id = id; 


		this.contenu = contenu; 


		this.statut = statut; 


	} 
	public MessageNotif(String contenu) { 


		super(); 


		this.contenu = contenu; 


	} 


	public MessageNotif(String contenu, boolean statut) { 


		super(); 


		this.contenu = contenu; 


		this.statut = statut; 


	} 


	public Long getId() { 


		return id; 


	} 


	public void setId(Long id) { 


		this.id = id; 


	} 
	public String getContenu() { 


		return contenu; 


	} 


	public void setContenu(String contenu) { 


		this.contenu = contenu; 


	} 


	public boolean isStatut() { 


		return statut; 


	} 


	public void setStatut(boolean statut) { 


		this.statut = statut; 


	} 




}

