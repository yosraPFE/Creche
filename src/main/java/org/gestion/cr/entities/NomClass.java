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

@Entity
@Table(name="NomClasses")
public class NomClass implements Serializable 
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
	@Column(name="ID_NOM_CLASSES")
	private long idNomClass;
	
	private String labelle;
	
	
	//mappedBy reference une propriété de l'entité cible
	@OneToOne(mappedBy="nomClasse",cascade=CascadeType.ALL)
	private Classe classe;
	
	
	//generateur du guetteurs et du setteurs
	public String getLabelle() 
	{
		return labelle;
	}
	public void setLabelle(String labelle) 
	{
		this.labelle = labelle;
	}
	public Classe getClasse() 
	{
		return classe;
	}
	public void setClasse(Classe classe) 
	{
		this.classe = classe;
	}
	//generateur du constructeur sans parametres
	public NomClass() 
	{
		super();
		
	}
	
	//generateur du constructeur avec parametres
	public NomClass(String labelle) 
	{
		super();
		this.labelle = labelle;
	}
	
	
	

}
