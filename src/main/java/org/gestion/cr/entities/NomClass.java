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
	 * GenerationType.IDENTITY:c a d attribuer  les cl�s primaires pour l'entit� en utilisant une colonne d'identit� de base de donn�es.
	 * GenerationType.AUTO :c a d choisir une strat�gie appropri�e pour la base de donn�es particuli�re.
	 * GenerationType.SEQUENCE:attribuer les cl�s primaires pour l'entit� en utilisant une colonne de s�quence de base de donn�es.
	 * GenerationType.TABLE :attribuer les cl�s primaires pour l'entit� en utilisant une table de base de donn�es sous-jacente pour garantir l'unicit�
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_NOM_CLASSES")
	private long idNomClass;
	
	private String labelle;
	
	
	//mappedBy reference une propri�t� de l'entit� cible
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
