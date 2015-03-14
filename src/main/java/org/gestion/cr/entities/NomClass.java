package org.gestion.cr.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class NomClass implements Serializable 
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
	@Column(name="ID_NOM_CLASSES")
	private long idNomClass;
	
	@NotEmpty	
	private String labelle;
	
	
	//mappedBy reference une propri�t� de l'entit� cible
	//@OneToOne(mappedBy="nomClasse",cascade=CascadeType.ALL)
	//private Classe classe;
	
	
	//generation du guetteurs et du setteurs
	public long getIdNomClass() 
	{
		return idNomClass;
	}
	public void setIdNomClass(long idNomClass) 
	{
		this.idNomClass = idNomClass;
	}
	public void setLabelle(String labelle) 
	{
		this.labelle = labelle;
	}
	
	public String getLabelle() 
	{
		return labelle;
	}
	
	//generation du constructeur sans parametres
	public NomClass() 
	{
		super();
		
	}
	
	//generation du constructeur avec parametres
	public NomClass(String labelle) 
	{
		super();
		this.labelle = labelle;
	}
	
	
	

}
