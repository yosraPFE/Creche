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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Creche implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long idCreche;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String adresse;
	
	private String siteWeb;
	@NotEmpty
	private String ville;
	
	private String telephone;
	
	private String nomPhoto;
	
	
	@Lob
	private byte[] photo;
	
	/*puisque la classe Creche a une collection de EquipeTechnique  et dansla classe "EquipeTechnique" 
	*on a un objet de type Creche qui s'appelle "creche" on le met pour le mapping :mappedBy="creche"
	*et Lazy par defaut*/
	
	
	//mappedBy reference une propriété de l'entité cible
	/*fetch=FetchType.LAZY: définit que les données peuvent être recuperé longtement et lourdement
	 * fetch=FetchType.EAGER:indique que les donnée doit etre recuperé rapidement
	*/
	
	
	
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
	
	public Collection<Classe> getClasses() 
	{
		return classes;
	}
	public void setClasses(Collection<Classe> classes) 
	{
		this.classes = classes;
	}
	
	
	
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	//generation du constructeurs sans parametres
	public Creche() 
	{
		super();
		
	}
	//generation du constructeurs avec parametres
	
	public Creche(String nom, String adresse, String siteWeb, String ville,
			String telephone, String nomPhoto, byte[] photo) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.siteWeb = siteWeb;
		this.ville = ville;
		this.telephone = telephone;
		this.nomPhoto = nomPhoto;
		this.photo = photo;
	}
	
	
	

}
