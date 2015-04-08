package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Materiels  implements Serializable
{
	

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idMateriel;
	
	
	private String designation;
	private String description;
	private double prix;
	
	
	
	@ManyToMany(mappedBy="materiels") 
    private Collection<Fournisseur> fournisseurs;
	
	@ManyToMany(mappedBy="materiels") 
    private Collection<Equipe> equipes;
	
	
	@ManyToOne
	@JoinColumn(name="idTypeMateriel")
	private TypeMateriels typeMateriel;
	
	@ManyToOne
	@JoinColumn(name="idStock")
	private Stock stock;


   //Generation des guetteurs et des setteurs
	
	
	public long getIdMateriel() {
		return idMateriel;
	}


	public void setIdMateriel(long idMateriel) {
		this.idMateriel = idMateriel;
	}
	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Collection<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}


	public void setFournisseurs(Collection<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}


	public TypeMateriels getTypeMateriel() {
		return typeMateriel;
	}


	public void setTypeMateriel(TypeMateriels typeMateriel) {
		this.typeMateriel = typeMateriel;
	}
	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}


	public Collection<Equipe> getEquipes() {
		return equipes;
	}


	public void setEquipes(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}


	//Generation des constructeurs sans parametres
	public Materiels() 
	{
		super();
		
	}

	//Generation des constructeurs avec parametres
	public Materiels(String designation, String description, double prix) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		
	}
	
}
