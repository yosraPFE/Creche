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

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class TypeMateriels implements Serializable
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idTypeMateriel;
	
	
	
	@NotEmpty
	private String labelle;	
	
	
	@OneToMany(mappedBy="typeMateriel",fetch=FetchType.LAZY)
	private Collection<Materiels> materiels;

   //Generation des guetteurs et des setteurs
	public long getIdTypeMateriel() {
		return idTypeMateriel;
	}


	public void setIdTypeMateriel(long idTypeMateriel) {
		this.idTypeMateriel = idTypeMateriel;
	}


	public String getLabelle() {
		return labelle;
	}


	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}


	public Collection<Materiels> getMateriels() {
		return materiels;
	}


	public void setMateriels(Collection<Materiels> materiels) {
		this.materiels = materiels;
	}


	//Generation des constructeurs sans parametres
	public TypeMateriels() {
		super();
		
	}

	//Generation des constructeurs avec parametres
	public TypeMateriels(String labelle) {
		super();
		this.labelle = labelle;
	}


}
