package org.gestion.cr.entities;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity




/*une annotation specifier pour l'heritage et "SINGLE_TABLE" c a d que tous les type de cette Classe
*mere "Equipe" sont stocké dans le mem tableau(un seul tableau))*/



@Inheritance(strategy=InheritanceType.SINGLE_TABLE)




/*toutes les types de la classe mere c a d les classes heritants de la classe mere(Equipe)
 * sont stoché dans  la meme table qui contient une colone qui a le nom "TYPE_EQUIPE"
 * qui va faire la differences entre les differetes type de la table Equipe
 * et cette colonne a un type chaine de caractere (String) et le nombre de caractere de nom du type
 * a une maximum longueur 16 (length=16)*/




@DiscriminatorColumn(name="TYPE_EQUIPE",discriminatorType=DiscriminatorType.STRING,length=16)



/*c a d que si je crai un objet de type Equipe Dans la table (classe) Personnage le, nom "TYPE_EQUIPE"
 * va etre egale a EQ
 */



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
	
	

	
	
	
	

}
