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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

//chaque classe est une entit� pour realiser la persistance on utilisant les anntation JPA

@Entity
public class Creche implements Serializable
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
	@Column(name="ID_CRECHE")
	private long idCreche;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String adresse;
	
	private String siteWeb;
	@NotEmpty
	private String ville;
	
	private String telephone;
	
	/*puisque la classe Creche a une collection de EquipeTechnique  et dansla classe "EquipeTechnique" 
	*on a un objet de type Creche qui s'appelle "creche" on le met pour le mapping :mappedBy="creche"
	*et Lazy par defaut*/
	
	
	//mappedBy reference une propri�t� de l'entit� cible
	/*fetch=FetchType.LAZY: d�finit que les donn�es peuvent �tre recuper� longtement et lourdement
	 * fetch=FetchType.EAGER:indique que les donn�e doit etre recuper� rapidement
	*/
	@OneToMany(mappedBy="creche",fetch=FetchType.LAZY)
	private Collection<EquipeTechnique> equipeTechniques;
	
	
	//cascade=CascadeType.REMOVE:fonctionnement en cascade remove
	
	@OneToMany(mappedBy="creche",cascade=CascadeType.REMOVE)
	private Collection<Classe> classes;
	
	
	
	//generation des guetteurs et des setteurs
	public long getIdCreche() 
	{
		return idCreche;
	}
	public void setIdCreche(long idCreche) 
	{
		this.idCreche = idCreche;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public String getAdresse() 
	{
		return adresse;
	}
	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}
	public String getSiteWeb() 
	{
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) 
	{
		this.siteWeb = siteWeb;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) 
	{
		this.ville = ville;
	}
	public String getTelephone() 
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public Collection<EquipeTechnique> getEquipeTechniques() 
	{
		return equipeTechniques;
	}
	public void setEquipeTechniques(Collection<EquipeTechnique> equipeTechniques) 
	{
		this.equipeTechniques = equipeTechniques;
	}
	public Collection<Classe> getClasses() 
	{
		return classes;
	}
	public void setClasses(Collection<Classe> classes) 
	{
		this.classes = classes;
	}
	
	//generation du constructeurs sans parametres
	public Creche() 
	{
		super();
		
	}
	
	//generation du constructeurs avec parametres
	public Creche(String nom, String adresse, String siteWeb, String ville,
			String telephone) 
	{
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.siteWeb = siteWeb;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	

}
