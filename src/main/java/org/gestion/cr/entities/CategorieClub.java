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
	 * GenerationType.IDENTITY:c a d attribuer  les cl�s primaires pour l'entit� en utilisant une colonne d'identit� de base de donn�es.
	 * GenerationType.AUTO :c a d choisir une strat�gie appropri�e pour la base de donn�es particuli�re.
	 * GenerationType.SEQUENCE:attribuer les cl�s primaires pour l'entit� en utilisant une colonne de s�quence de base de donn�es.
	 * GenerationType.TABLE :attribuer les cl�s primaires pour l'entit� en utilisant une table de base de donn�es sous-jacente pour garantir l'unicit�
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
