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
import javax.persistence.Table;

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
	@Column(name="ID_EVENEMENT")
	private long idEvenement;
	
	
	private String nom;
	private String type;
	private String inscription;
	private double prix;
	private Date date;
	
	@ManyToMany
	@JoinTable(name="EVEN_ENF",joinColumns=@JoinColumn(name="ID_EVENEMENT")
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

	public String getInscription() 
	{
		return inscription;
	}

	public void setInscription(String inscription) 
	{
		this.inscription = inscription;
	}

	public double getPrix() 
	{
		return prix;
	}

	public void setPrix(double prix) 
	{
		this.prix = prix;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
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
	public Evennement(String nom, String type, String inscription, double prix,
			Date date) 
	{
		super();
		this.nom = nom;
		this.type = type;
		this.inscription = inscription;
		this.prix = prix;
		this.date = date;
	}
	
	
	
	
	
	
	
	

}
