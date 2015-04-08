package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CategorieClub implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	/*
	 * GenerationType.IDENTITY:c a d attribuer  les cl�s primaires pour l'entit� en utilisant une colonne d'identit� de base de donn�es.
	 * GenerationType.AUTO :c a d choisir une strat�gie appropri�e pour la base de donn�es particuli�re.
	 * GenerationType.SEQUENCE:attribuer les cl�s primaires pour l'entit� en utilisant une colonne de s�quence de base de donn�es.
	 * GenerationType.TABLE :attribuer les cl�s primaires pour l'entit� en utilisant une table de base de donn�es sous-jacente pour garantir l'unicit�
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idCateg;
	
	
	
	
	
	private String labelle;
	
	private double prix;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String date;
	
	
	@OneToMany(mappedBy="categorieClub",fetch=FetchType.LAZY)
	private Collection<Clubs> clubs;
	
	//generation des guetteurs et des setteurs
	public long getIdCateg()
	{
		return idCateg;
	}
	public void setIdCateg(long idCateg) 
	{
		this.idCateg = idCateg;
	}
	
	public String getLabelle() 
	{
		return labelle;
	}
	
	public void setLabelle(String labelle)
	{
		this.labelle = labelle;
	}
	public double getPrix() 
	{
		return prix;
	}
	public void setPrix(double prix) 
	{
		this.prix = prix;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	
	
	
	public Collection<Clubs> getClubs() {
		return clubs;
	}
	public void setClubs(Collection<Clubs> clubs) {
		this.clubs = clubs;
	}
	//generation du constructeur sans parametres
	public CategorieClub() 
	{
		super();
		
	}
	
	//generation du constructeur avec parametres
	public CategorieClub(String labelle, double prix, String date) 
	{
		super();
		this.labelle = labelle;
		this.prix = prix;
		this.date = date;
	}
	


}
