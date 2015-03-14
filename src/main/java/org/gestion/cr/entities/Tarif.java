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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tarif implements Serializable
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
	@Column(name="ID_TARIF")
	private long idTarif;
	
	@NotEmpty
	
	private String tarifInscription;
	
	/*puisque la classe "Tarif" a une collection de "Clubs" qui a
	* un objet de type "Tarif" qui s'appelle "tarif" on le met pour le mapping :mappedBy="tarif"
	*et Lazy par defaut*/
	
	@OneToMany(mappedBy="tarif",fetch=FetchType.LAZY)
	private  Collection<Clubs> clubs;
	
	
	//mappedBy reference une propriété de l'entité cible
	@OneToMany(mappedBy="tarif",fetch=FetchType.LAZY)
	private Collection<Menus> menus;
	
	@ManyToOne
	@JoinColumn(name="ID_PLANNING_HORRAIRES")
	private PlanningHorraires plannigHorraires;
	
	@ManyToOne
	@JoinColumn(name="ID_ENFANT")
	private Enfant enfant;
	
	//generation du guetteurs et du setteurs
	public long getIdTarif() 
	{
		return idTarif;
	}
	public void setIdTarif(long idTarif) 
	{
		this.idTarif = idTarif;
	}
	public String getTarifInscription() 
	{
		return tarifInscription;
	}
	
	public void setTarifInscription(String tarifInscription) 
	{
		this.tarifInscription = tarifInscription;
	}
	public Collection<Clubs> getClubs() 
	{
		return clubs;
	}
	public void setClubs(Collection<Clubs> clubs) 
	{
		this.clubs = clubs;
	}
	public Collection<Menus> getMenus() 
	{
		return menus;
	}
	public void setMenus(Collection<Menus> menus) 
	{
		this.menus = menus;
	}
	public PlanningHorraires getPlannigHorraires() 
	{
		return plannigHorraires;
	}
	public void setPlannigHorraires(PlanningHorraires plannigHorraires) 
	{
		this.plannigHorraires = plannigHorraires;
	}
	public Enfant getEnfant() {
		return enfant;
	}
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
	
	
	//generation du constructeurs sans parametres
	public Tarif() 
	{
		super();
	}
	
	//generation du constructeurs avec parametres
	public Tarif(String tarifInscription) 
	{
		super();
		this.tarifInscription = tarifInscription;
	}
	

}
