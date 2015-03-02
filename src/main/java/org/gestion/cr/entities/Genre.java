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
	 * GenerationType.IDENTITY:c a d attribuer  les cl�s primaires pour l'entit� en utilisant une colonne d'identit� de base de donn�es.
	 * GenerationType.AUTO :c a d choisir une strat�gie appropri�e pour la base de donn�es particuli�re.
	 * GenerationType.SEQUENCE:attribuer les cl�s primaires pour l'entit� en utilisant une colonne de s�quence de base de donn�es.
	 * GenerationType.TABLE :attribuer les cl�s primaires pour l'entit� en utilisant une table de base de donn�es sous-jacente pour garantir l'unicit�
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GENRE")
	private long idGenre;
	
	@NotEmpty
	private String labelle;
	
	//mappedBy reference une propri�t� de l'entit� cible
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
