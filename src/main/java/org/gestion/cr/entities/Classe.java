package org.gestion.cr.entities;

import java.io.Serializable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.gestion.cr.entities.Annee;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Classes")

public class Classe implements Serializable
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
	@Column(name="ID_CLASSE")
	private long idClass;
	
	@NotEmpty
	private int nombrePlaces;
	
	
	private String nom;
	
	
	
	
	
	@ManyToMany
	@JoinTable(name="class_ann_enf",joinColumns=@JoinColumn(name="ID_CLASSE")
	,inverseJoinColumns=@JoinColumn(name="ID_ANNEE"))
	private Collection<Annee> annees;//au lieu de annee getItems(){return items.values();}
	
	
	//mappedBy reference une propriété de l'entité cible
	@ManyToMany(mappedBy="classes")
	private Collection<EquipeEducatif> equipeEducatifs;
	
	@ManyToOne
	@JoinColumn(name="ID_CRECHE")
	private Creche creche;
	
	
	
	@ManyToMany
	@JoinTable(name="class_ann_enf",joinColumns=@JoinColumn(name="ID_CLASSE")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	
	
	/* 
	 * cascade=CascadeType.ALL:toutes les opérations en cascade
	 * cascade=CascadeType.REFRESH:cascade opération de rafraîchissement
	 * cascade=CascadeType.REMOVE:fonctionnement en cascade remove
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private NomClass nomClasse;
	
	
	
	
	public long getIdClass() {
		return idClass;
	}
	public void setIdClass(long idClass) {
		this.idClass = idClass;
	}
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	
	public Collection<Annee> getAnnees() {
		return annees;
	}
	public void setAnnees(Collection<Annee> annees) {
		this.annees = annees;
	}
	public Collection<EquipeEducatif> getEquipeEducatifs() {
		return equipeEducatifs;
	}
	public void setEquipeEducatifs(Collection<EquipeEducatif> equipeEducatifs) {
		this.equipeEducatifs = equipeEducatifs;
	}
	public Creche getCreche() {
		return creche;
	}
	public void setCreche(Creche creche) {
		this.creche = creche;
	}
	public Collection<Enfant> getEnfants() {
		return enfants;
	}
	public void setEnfants(Collection<Enfant> enfants) {
		this.enfants = enfants;
	}
	public NomClass getNomClasse() {
		return nomClasse;
	}
	public void setNomClasse(NomClass nomClasse) {
		this.nomClasse = nomClasse;
	}
	
	
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	//generateur du constructeur sans parametres
	
	
	public Classe() 
	{
		super();
		
	}
	//generateur du constructeur avec parametres
	public Classe(int nombrePlaces) {
		super();
		this.nombrePlaces = nombrePlaces;
		
	}
	
	
	
	
	
	
	

}
