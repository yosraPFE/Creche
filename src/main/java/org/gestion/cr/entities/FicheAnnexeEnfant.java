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
@Table(name="FcheAnnexeEnfants")

public class FicheAnnexeEnfant implements Serializable 
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
	@Column(name="ID_FICHE_ANNEXE")
	private long idFiche;
	
	
	
	private float poids;
	private float taille;
	//une FicheAnnexeEnfant est associ� a un et un seul enfant
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Enfant enfant;
	
	//generateur du guetteurs et du setteurs
	
	public long getIdFiche()
	{
		return idFiche;
	}
	public void setIdFiche(long idFiche) 
	{
		this.idFiche = idFiche;
	}
	public float getPoids() 
	{
		return poids;
	}
	
	public void setPoids(float poids)
	{
		this.poids = poids;
	}
	public float getTaille() 
	{
		return taille;
	}
	public void setTaille(float taille) 
	{
		this.taille = taille;
	}
	public Enfant getEnfant() 
	{
		return enfant;
	}
	public void setEnfant(Enfant enfant) 
	{
		this.enfant = enfant;
	}
	
	
	//generateur du constructeur sans parametres
	public FicheAnnexeEnfant() 
	{
		super();
		
	}
	
	//generateur du constructeur avec parametres
	public FicheAnnexeEnfant(float poids, float taille)
	{
		super();
		this.poids = poids;
		this.taille = taille;
	}
	
	
	

}
