package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Classe implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idClass;
	
	private String nom;
	private int nombrePlaces;
	
	
	
	
	@ManyToMany
	@JoinTable(name="CLASS_INSC_ENF",joinColumns=@JoinColumn(name="idClass")
	,inverseJoinColumns=@JoinColumn(name="idinscription"))
	private Collection<Inscription> inscriptions;
	
	
	
	@ManyToMany(mappedBy="classes")
	private Collection<EquipeEducatif> equipeEducatifs;
	
	@ManyToOne
	@JoinColumn(name="idCreche")
	private Creche creche;
	
	
	
	@ManyToMany
	@JoinTable(name="CLASS_INSC_ENF",joinColumns=@JoinColumn(name="idClass")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	
	
	/* 
	 * cascade=CascadeType.ALL:toutes les opérations en cascade
	 * cascade=CascadeType.REFRESH:cascade opération de rafraîchissement
	 * cascade=CascadeType.REMOVE:fonctionnement en cascade remove
	 */
	
	
	
	//Generation des guetteurs et des setteurs
	public long getIdClass() 
	{
		return idClass;
	}
	public void setIdClass(long idClass) 
	{
		this.idClass = idClass;
	}
	public int getNombrePlaces() 
	{
		return nombrePlaces;
	}
	public void setNombrePlaces(int nombrePlaces) 
	{
		this.nombrePlaces = nombrePlaces;
	}
	
	
	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public Collection<EquipeEducatif> getEquipeEducatifs() 
	{
		return equipeEducatifs;
	}
	public void setEquipeEducatifs(Collection<EquipeEducatif> equipeEducatifs) 
	{
		this.equipeEducatifs = equipeEducatifs;
	}
	public Creche getCreche() 
	{
		return creche;
	}
	public void setCreche(Creche creche) 
	{
		this.creche = creche;
	}
	public Collection<Enfant> getEnfants() 
	{
		return enfants;
	}
	public void setEnfants(Collection<Enfant> enfants) 
	{
		this.enfants = enfants;
	}
	
	
	
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	//generation du constructeur sans parametres
	public Classe() 
	{
		super();
		
	}
	//generation du constructeur avec parametres
	public Classe(String nom, int nombrePlaces) 
	{
		super();
		this.nom = nom;
		this.nombrePlaces = nombrePlaces;
	}
	
	
	
	
	
	
	
	

}
