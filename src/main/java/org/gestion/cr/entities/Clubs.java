package org.gestion.cr.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Clubs implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idClub;
	
	@NotEmpty
	private String nom;	
	
	
	
	@ManyToOne
	@JoinColumn(name="idCateg")
	private CategorieClub categorieClub;
	
	
	
	@ManyToOne
	@JoinColumn(name="idinscription")
	private Inscription inscription;
	
	//generation des guetteurs et des setteurs
	public long getIdClub() 
	{
		return idClub;
	}
	public void setIdClub(long idClub)
	{
		this.idClub = idClub;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	
	
	
	public CategorieClub getCategorieClub() {
		return categorieClub;
	}
	public void setCategorieClub(CategorieClub categorieClub) {
		this.categorieClub = categorieClub;
	}
	public Inscription getInscription() {
		return inscription;
	}
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	//generation constructeur sans parametres
	public Clubs() 
	{
		super();
		
	}
	
	//generation constructeur avec parametres
	public Clubs(String nom) 
	{
		super();
		this.nom = nom;
	}
	
}
