package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Fonctions")

public class Fonction implements Serializable
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
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="ID_FONCTION")
	private long idFonction;
	
	@NotEmpty
	private String labelle;
	
	//mappedBy reference une propriété de l'entité cible
	@OneToMany(mappedBy="fonction",fetch=FetchType.LAZY)
	private Collection<EquipeSanitaire> equipeSanitaires;
	
	@OneToMany(mappedBy="fonction",fetch=FetchType.LAZY)
	private Collection<EquipeTechnique> equipeTechniques;
	
	@OneToMany(mappedBy="fonction",fetch=FetchType.LAZY)
	private Collection<EquipeEducatif>  equipeEducatifs;
	
	
	//generation du guetteurs et du setteurs
	
	public long getIdFonction() 
	{
		return idFonction;
	}
	public void setIdFonction(long idFonction) 
	{
		this.idFonction = idFonction;
	}
	public String getLabelle()
	{
		return labelle;
	}
	
	public void setLabelle(String labelle) 
	{
		this.labelle = labelle;
	}
	public Collection<EquipeSanitaire> getEquipeSanitaires() 
	{
		return equipeSanitaires;
	}
	public void setEquipeSanitaires(Collection<EquipeSanitaire> equipeSanitaires) 
	{
		this.equipeSanitaires = equipeSanitaires;
	}
	public Collection<EquipeTechnique> getEquipeTechniques() 
	{
		return equipeTechniques;
	}
	public void setEquipeTechniques(Collection<EquipeTechnique> equipeTechniques) 
	{
		this.equipeTechniques = equipeTechniques;
	}
	public Collection<EquipeEducatif> getEquipeEducatifs() 
	{
		return equipeEducatifs;
	}
	public void setEquipeEducatifs(Collection<EquipeEducatif> equipeEducatifs)
	{
		this.equipeEducatifs = equipeEducatifs;
	}
	
	
	//generation du constructeurs sans parametres
	public Fonction() 
	{
		super();
		
	}
	
	//generation du constructeurs avec parametres
	public Fonction(String labelle) 
	{
		super();
		this.labelle = labelle;
	}
	
	
	
	

}
