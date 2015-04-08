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
public class Stock implements Serializable
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idStock;
	
	private float quantite;	
	
	@OneToMany(mappedBy="stock",fetch=FetchType.LAZY)
	private Collection<Materiels> materiels;

	//Generation des guetteurs et des setteurs
	public long getIdStock() {
		return idStock;
	}

	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}

	public float getQuantite() {
		return quantite;
	}

	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}

	public Collection<Materiels> getMateriels() {
		return materiels;
	}

	public void setMateriels(Collection<Materiels> materiels) {
		this.materiels = materiels;
	}
	
	
	
	//generation des constructeurs sans parametres

	

	public Stock() 
	{
		super();
	}
	//generation des constructeurs avec parametres

	public Stock( float quantite) {
		super();
		
		this.quantite = quantite;
	}

	

}
