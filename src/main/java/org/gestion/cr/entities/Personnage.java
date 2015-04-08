package org.gestion.cr.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name="TYPE_PERSONNAGE",discriminatorType=DiscriminatorType.STRING,length=22)

public class Personnage implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idPerson;
	
	
	
	private String nom;
	
	
	
	private String prenom;
	
	
	private String nomPhoto;
	
	@Lob
	private byte[] photo;
	
	
	//generation du guetteurs et du setteurs
	public long getIdPerson() 
	{
		return idPerson;
	}
	public void setIdPerson(long idPerson) 
	{
		this.idPerson = idPerson;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public String getPrenom() 
	{
		return prenom;
	}
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	public byte[] getPhoto()
	{
		return photo;
	}
	public void setPhoto(byte[] photo)
	{
		this.photo = photo;
	}
	
	
	public String getNomPhoto() 
	{
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) 
	{
		this.nomPhoto = nomPhoto;
	}
	//generation du constructeur sans parametres
	public Personnage() 
	{
		super();
		
	}
	//generation du constructeur avec parametres
	public Personnage(String nom, String prenom, byte[] photo, String nomPhoto) 
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}
	
	@Override
	public String toString() {
		
		return "Personnage";
	}
	
	

}
