package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
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

import org.hibernate.validator.constraints.NotEmpty;

//chaque classe est une entité pour realiser la persistance on utilisant les anntation JPA

@Entity
public class Creche implements Serializable
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
	@Column(name="ID_CRECHE")
	private long idCreche;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String adresse;
	
	private String siteWeb;
	@NotEmpty
	private String ville;
	
	private String telephone;
	
	/*puisque la classe Creche a une collection de EquipeTechnique  et dansla classe "EquipeTechnique" 
	*on a un objet de type Creche qui s'appelle "creche" on le met pour le mapping :mappedBy="creche"
	*et Lazy par defaut*/
	
	
	//mappedBy reference une propriété de l'entité cible
	/*fetch=FetchType.LAZY: définit que les données peuvent être recuperé longtement et lourdement
	 * fetch=FetchType.EAGER:indique que les donnée doit etre recuperé rapidement
	*/
	@OneToMany(mappedBy="creche",fetch=FetchType.LAZY)
	private Collection<EquipeTechnique> equipeTechniques;
	
	
	//cascade=CascadeType.REMOVE:fonctionnement en cascade remove
	
	@OneToMany(mappedBy="creche",cascade=CascadeType.REMOVE)
	private Collection<Classe> classes;
	
	
	
	//generation des guetteurs et des setteurs
	public long getIdCreche() 
	{
		return idCreche;
	}
	public void setIdCreche(long idCreche) 
	{
		this.idCreche = idCreche;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public String getAdresse() 
	{
		return adresse;
	}
	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}
	public String getSiteWeb() 
	{
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) 
	{
		this.siteWeb = siteWeb;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) 
	{
		this.ville = ville;
	}
	public String getTelephone() 
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public Collection<EquipeTechnique> getEquipeTechniques() 
	{
		return equipeTechniques;
	}
	public void setEquipeTechniques(Collection<EquipeTechnique> equipeTechniques) 
	{
		this.equipeTechniques = equipeTechniques;
	}
	public Collection<Classe> getClasses() 
	{
		return classes;
	}
	public void setClasses(Collection<Classe> classes) 
	{
		this.classes = classes;
	}
	
	//generation du constructeurs sans parametres
	public Creche() 
	{
		super();
		
	}
	
	//generation du constructeurs avec parametres
	public Creche(String nom, String adresse, String siteWeb, String ville,
			String telephone) 
	{
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.siteWeb = siteWeb;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	

}
