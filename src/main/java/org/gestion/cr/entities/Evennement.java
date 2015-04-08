package org.gestion.cr.entities;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evennement implements Serializable 
{
	/**
	 * 
	 * @author YOSRA
	 * 
	 * */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idEvenement;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String type;
	private double fraix;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String date;
	
	@ManyToMany
	@JoinTable(name="EVEN_ENF",joinColumns=@JoinColumn(name="idEvenement")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	
	
	//Generation des Guetteurs et de setteurs
    public long getIdEvenement() 
	{
		return idEvenement;
	}

	public void setIdEvenement(long idEvenement) 
	{
		this.idEvenement = idEvenement;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	

	public double getFraix() {
		return fraix;
	}

	public void setFraix(double fraix) {
		this.fraix = fraix;
	}

	
	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public Collection<Enfant> getEnfants() 
	{
		return enfants;
	}

	public void setEnfants(Collection<Enfant> enfants) 
	{
		this.enfants = enfants;
	}
	
    //Generation des constructeurs sans parametres
	public Evennement() 
	{
		super();
		
	}

	//Generation des constructeurs avec parametres
	public Evennement(String nom, String type, double fraix, String date) {
		super();
		this.nom = nom;
		this.type = type;
		this.fraix = fraix;
		
		this.date = date;
	}
	
    
	
	
	
	
	
	
	
	

}
