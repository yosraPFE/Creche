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
@Table(name="Genres")

public class Genre implements Serializable 
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
	@Column(name="ID_GENRE")
	private long idGenre;
	
	@NotEmpty
	private String labelle;
	
	//mappedBy reference une propriété de l'entité cible
	@OneToMany(mappedBy="genre",fetch=FetchType.LAZY)
	private Collection<Parent> parents;
	
	//generation du guetteurs et du setteurs
	
	public long getIdGenre()
	{
		return idGenre;
	}
	public void setIdGenre(long idGenre) 
	{
		this.idGenre = idGenre;
	}
	public String getLabelle() 
	{
		return labelle;
	}
	
	public void setLabelle(String labelle) 
	{
		this.labelle = labelle;
	}
	public Collection<Parent> getParents()
	{
		return parents;
	}
	public void setParents(Collection<Parent> parents) 
	{
		this.parents = parents;
	}
	
	
	//generation du constructeurs sans parametres
	public Genre() 
	{
		super();
		
	}
	
	//generation du constructeurs avec parametres
	public Genre(String labelle) 
	{
		super();
		this.labelle = labelle;
	}
	
	

}
