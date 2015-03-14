package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
//classe heritante de la classe mere Personnage
@DiscriminatorValue("Parent")

public class Parent  extends Personnage implements Serializable 
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
	
	@NotEmpty
	private String cin;
	
	private String profession;
	
	private String adresseDomicile;
	
	private String telephoneDomicile;
	
	private String telephonePortable;
	private String email;
	private String lieuTravail;
	private String telephoneTravail;
	private String nomUtilisateur;
	private String motPasse;
	
	
	@ManyToOne
	@JoinColumn(name="ID_GENRE")
	private Genre genre;
	
	@ManyToMany
	@JoinTable(name="PAR_ENF",joinColumns=@JoinColumn(name="ID_PARENT"),
	inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	
	//generation du guetteurs et du setteurs
	public String getCin() 
	{
		return cin;
	}
	public void setCin(String cin) 
	{
		this.cin = cin;
	}
	public String getProfession() 
	{
		return profession;
	}
	public void setProfession(String profession) 
	{
		this.profession = profession;
	}
	public String getAdresseDomicile() 
	{
		return adresseDomicile;
	}
	public void setAdresseDomicile(String adresseDomicile) 
	{
		this.adresseDomicile = adresseDomicile;
	}
	public String getTelephoneDomicile() 
	{
		return telephoneDomicile;
	}
	public void setTelephoneDomicile(String telephoneDomicile) 
	{
		this.telephoneDomicile = telephoneDomicile;
	}
	public String getTelephonePortable() 
	{
		return telephonePortable;
	}
	public void setTelephonePortable(String telephonePortable) 
	{
		this.telephonePortable = telephonePortable;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getLieuTravail() 
	{
		return lieuTravail;
	}
	public void setLieuTravail(String lieuTravail) 
	{
		this.lieuTravail = lieuTravail;
	}
	public String getTelephoneTravail()
	{
		return telephoneTravail;
	}
	public void setTelephoneTravail(String telephoneTravail)
	{
		this.telephoneTravail = telephoneTravail;
	}
	public String getNomUtilisateur() 
	{
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) 
	{
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotPasse()
	{
		return motPasse;
	}
	public void setMotPasse(String motPasse) 
	{
		this.motPasse = motPasse;
	}
	public Genre getGenre() 
	{
		return genre;
	}
	public void setGenre(Genre genre) 
	{
		this.genre = genre;
	}
	public Collection<Enfant> getEnfants() 
	{
		return enfants;
	}
	public void setEnfants(Collection<Enfant> enfants) 
	{
		this.enfants = enfants;
	}
	
	//generation du constructeurs sans parametres
	public Parent() 
	{
		super();
		
	}
	//generation du constructeur avec parametres
	public Parent(String nom, String prenom, byte[] photo, String nomPhoto,
			String cin, String profession, String adresseDomicile,
			String telephoneDomicile, String telephonePortable, String email,
			String lieuTravail, String telephoneTravail, String nomUtilisateur,
			String motPasse) 
	{
		super(nom, prenom, photo, nomPhoto);
		this.cin = cin;
		this.profession = profession;
		this.adresseDomicile = adresseDomicile;
		this.telephoneDomicile = telephoneDomicile;
		this.telephonePortable = telephonePortable;
		this.email = email;
		this.lieuTravail = lieuTravail;
		this.telephoneTravail = telephoneTravail;
		this.nomUtilisateur = nomUtilisateur;
		this.motPasse = motPasse;
	}
	
		
	
	
	

}
