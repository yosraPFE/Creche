package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@DiscriminatorValue("Fournisseur")
public class Fournisseur extends Personnage implements Serializable 
{
	
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@NotEmpty
	private String cin;	
	@Size(min=5)
	private String adresseSociete;
	@NotEmpty
	private String telephoneSociete;
	@NotEmpty
	private String telephonePortable;
	@NotEmpty
	private String email;
	
	
	@ManyToMany
	@JoinTable(name="MAT_FOUR",joinColumns=@JoinColumn(name="ID_FOURNISSEUR")
	,inverseJoinColumns=@JoinColumn(name="idMateriel"))
	private Collection<Materiels> materiels;

	//generation des guetteurs et des setteurs
	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getAdresseSociete() {
		return adresseSociete;
	}


	public void setAdresseSociete(String adresseSociete) {
		this.adresseSociete = adresseSociete;
	}


	public String getTelephoneSociete() {
		return telephoneSociete;
	}


	public void setTelephoneSociete(String telephoneSociete) {
		this.telephoneSociete = telephoneSociete;
	}


	public String getTelephonePortable() {
		return telephonePortable;
	}


	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Materiels> getMateriels() {
		return materiels;
	}


	public void setMateriels(Collection<Materiels> materiels) {
		this.materiels = materiels;
	}

	//generation des constructeurs sans parametres
	public Fournisseur()
	{
		super();
		
	}

	//generation des constructeurs avec parametres
	public Fournisseur(String nom, String prenom, byte[] photo,
			String nomPhoto, String cin, String adresseSociete,
			String telephoneSociete, String telephonePortable, String email) {
		super(nom, prenom, photo, nomPhoto);
		this.cin = cin;
		this.adresseSociete = adresseSociete;
		this.telephoneSociete = telephoneSociete;
		this.telephonePortable = telephonePortable;
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		return "Fournisseur";
	}

	

}
