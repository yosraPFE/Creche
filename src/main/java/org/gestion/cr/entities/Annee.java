package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Annees")
public class Annee implements Serializable
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
	@Column(name="ID_ANNEE")
	private long idAnnee;
	
	private String annee;
	
	
	@ManyToOne
	@JoinColumn(name="ID_ENFANT")
	private Enfant enfant;
	
	
    //generateur de guetteures et des setteurs
	public String getAnnee() 
	{
		return annee;
	}

	public void setAnnee(String annee) 
	{
		this.annee = annee;
	}
	

	public Enfant getEnfant() 
	{
		return enfant;
	}

	public void setEnfant(Enfant enfant)
	{
		this.enfant = enfant;
	}
	//generateur de constructeur sans parametres

	public Annee() 
	{
		super();
	
	}
	
    //geberateures du constructeur avec parametres
	public Annee(String annee) 
	{
		super();
		this.annee = annee;
	}
	
	
}
