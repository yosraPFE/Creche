package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PlanningHorraires")
public class PlanningHorraires implements Serializable
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PLANNING_HORRAIRES")
	private long idPlanning;
	
	private String type;
	private float prix;
	
	
	//mappedBy reference une propri�t� de l'entit� cible
	@OneToMany(mappedBy="plannigHorraires",fetch=FetchType.LAZY)
	private Collection<Tarif> tarifs;
	
	//generation du guetteurs et du setteurs
	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	public float getPrix() 
	{
		return prix;
	}
	public void setPrix(float prix) 
	{
		this.prix = prix;
	}
	public Collection<Tarif> getTarifs() 
	{
		return tarifs;
	}
	public void setTarifs(Collection<Tarif> tarifs) 
	{
		this.tarifs = tarifs;
	}
	
	
	//generation du constructeur sans parametres
	public PlanningHorraires() 
	{
		super();
		
	}
	
	//generation du constructeur avec parametres
	public PlanningHorraires(String type, float prix) 
	{
		super();
		this.type = type;
		this.prix = prix;
	}
	
	
	

}
