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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Menus implements Serializable
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
	@Column(name="ID_MENUS")
	private long idMenu;
	
	@NotEmpty
	private String nom;
	
	private double prix;
	@NotEmpty
	private String date;
	
	@ManyToOne
	@JoinColumn(name="ID_TARIF")
	private Tarif tarif;
	
	//generation du guetteurs et du setteurs
	public long getIdMenu() 
	{
		return idMenu;
	}
	public void setIdMenu(long idMenu)
	{
		this.idMenu = idMenu;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
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
	public Tarif getTarif() 
	{
		return tarif;
	}
	public void setTarif(Tarif tarif)
	{
		this.tarif = tarif;
	}
	
	//generation du constructeurs sans parametres
	public Menus() 
	{
		super();
		
	}
	//generation du constructeurs avec parametres
	public Menus(String nom, double prix, String date) 
	{
		super();
		this.nom = nom;
		this.prix = prix;
		this.date = date;
	}
	
	
	
	

}
