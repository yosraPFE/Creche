package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

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

@Entity
public class Clubs implements Serializable
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
	@Column(name="ID_CLUB")
	private long idClub;
	
	@NotEmpty
	private String nom;	
	
	/*puisque la classe "Clubs" a une collection de "CategorieClub" qui a
	* un objet de type "Clubs" qui s'appelle "clubs" on le met pour le mapping :mappedBy="clubs"
	*et Lazy par defaut*/
	
	
	//mappedBy reference une propriété de l'entité cible
	@OneToMany(mappedBy="clubs",fetch=FetchType.LAZY)
	private Collection<CategorieClub> categoriClubs;
	
	@ManyToOne
	@JoinColumn(name="ID_TARIF")
	private Tarif tarif;
	
	//generation des guetteurs et des setteurs
	public long getIdClub() 
	{
		return idClub;
	}
	public void setIdClub(long idClub)
	{
		this.idClub = idClub;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public Collection<CategorieClub> getCategoriClubs() 
	{
		return categoriClubs;
	}
	public void setCategoriClubs(Collection<CategorieClub> categoriClubs) 
	{
		this.categoriClubs = categoriClubs;
	}
	public void setTarif(Tarif tarif) 
	{
		this.tarif = tarif;
	}
	public Tarif getTarif() 
	{
		return tarif;
	}
	
	
	//generation constructeur sans parametres
	public Clubs() 
	{
		super();
		
	}
	
	//generation constructeur avec parametres
	public Clubs(String nom) 
	{
		super();
		this.nom = nom;
	}
	
}
