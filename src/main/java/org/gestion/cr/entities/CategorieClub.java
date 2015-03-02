package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
//la notation table est pa obligatoire car par defaut il va prendre le nom de la classe
@Table(name="CategoriesClubs")


public class CategorieClub implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	/*
	 * GenerationType.IDENTITY:c a d attribuer  les clés primaires pour l'entité en utilisant une colonne d'identité de base de données.
	 * GenerationType.AUTO :c a d choisir une stratégie appropriée pour la base de données particulière.
	 * GenerationType.SEQUENCE:attribuer les clés primaires pour l'entité en utilisant une colonne de séquence de base de données.
	 * GenerationType.TABLE :attribuer les clés primaires pour l'entité en utilisant une table de base de données sous-jacente pour garantir l'unicité
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CATEG_CLUB")
	private long idCateg;
	
	@NotEmpty
	private String labelle;
	@NotEmpty
	private double prix;
	@NotEmpty
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="ID_CLUBS")
	private Clubs clubs;
	
	//generateur du guetteurs et du setteurs
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
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	public Clubs getClubs() 
	{
		return clubs;
	}
	public void setClubs(Clubs clubs) 
	{
		this.clubs = clubs;
	}
	
	
	//generateur du constructeur sans parametres
	
	public CategorieClub() 
	{
		super();
		
	}
	
	//generateur du constructeur avec parametres
	
	public CategorieClub(String labelle, double prix, Date date) 
	{
		super();
		this.labelle = labelle;
		this.prix = prix;
		this.date = date;
	}
	
	
	
	

}
