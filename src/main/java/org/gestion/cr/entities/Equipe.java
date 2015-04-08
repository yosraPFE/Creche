package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name="TYPE_EQUIPE",discriminatorType=DiscriminatorType.STRING,length=16)

@DiscriminatorValue("Equipe")

public class Equipe extends Personnage implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	@NotEmpty
	private String dateNaissance;
	@NotEmpty
	private String lieuNaissance;
	
	@NotEmpty
	private String sexe;
	@NotEmpty
	private String adresseDomicile;
	
	private String nomUtilisateur;
	private String motPasse;
	
	
	@ManyToMany
	@JoinTable(name="MAT_EQ",joinColumns=@JoinColumn(name="ID_EQUIPE")
	,inverseJoinColumns=@JoinColumn(name="idMateriel"))
	private Collection<Materiels> materiels;
	
	//generation des guetteurs et des setteurs
	public String getDateNaissance() 
	{
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) 
	{
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance()
	{
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) 
	{
		this.lieuNaissance = lieuNaissance;
	}
	public String getSexe() 
	{
		return sexe;
	}
	public void setSexe(String sexe) 
	{
		this.sexe = sexe;
	}
	public String getAdresseDomicile() 
	{
		return adresseDomicile;
	}
	public void setAdresseDomicile(String adresseDomicile)
	{
		this.adresseDomicile = adresseDomicile;
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
	
	public Collection<Materiels> getMateriels() {
		return materiels;
	}
	public void setMateriels(Collection<Materiels> materiels) {
		this.materiels = materiels;
	}
	//generation du constructeur sans parametres
	public Equipe() 
	{
		super();
		
	}
	//generation du constructeur avec parametres
	public Equipe(String nom, String prenom, byte[] photo, String nomPhoto,
			String dateNaissance, String lieuNaissance, String sexe,
			String adresseDomicile, String nomUtilisateur, String motPasse) {
		super(nom, prenom, photo, nomPhoto);
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sexe = sexe;
		this.adresseDomicile = adresseDomicile;
		this.nomUtilisateur = nomUtilisateur;
		this.motPasse = motPasse;
	}
	
	

	@Override
	public String toString() {
		
		return "Equipe";
	}
	
	
	

}
