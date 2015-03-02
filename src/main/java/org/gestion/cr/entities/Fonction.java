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
	 * GenerationType.IDENTITY:c a d attribuer  les cl�s primaires pour l'entit� en utilisant une colonne d'identit� de base de donn�es.
	 * GenerationType.AUTO :c a d choisir une strat�gie appropri�e pour la base de donn�es particuli�re.
	 * GenerationType.SEQUENCE:attribuer les cl�s primaires pour l'entit� en utilisant une colonne de s�quence de base de donn�es.
	 * GenerationType.TABLE :attribuer les cl�s primaires pour l'entit� en utilisant une table de base de donn�es sous-jacente pour garantir l'unicit�
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="ID_FONCTION")
	private long idFonction;
	
	@NotEmpty
	private String labelle;
	
	//mappedBy reference une propri�t� de l'entit� cible
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
