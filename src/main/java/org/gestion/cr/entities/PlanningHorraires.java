package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PlanningHorraires implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idPlanning;
	
	
	
	
	
	private double prix;
	
	
	
	@ManyToMany(mappedBy="planningHorraires") 
    private Collection<Inscription> inscriptions;
	
	
	@ManyToOne
	@JoinColumn(name="idGenrePlanning")
	private GenrePlanning genresPlannings;
	
	//generation du guetteurs et du setteurs
	
	
	public long getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(long idPlanning) {
		this.idPlanning = idPlanning;
	}

	

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	
	
	
	public GenrePlanning getGenresPlannings() {
		return genresPlannings;
	}

	public void setGenresPlannings(GenrePlanning genresPlannings) {
		this.genresPlannings = genresPlannings;
	}
	
	

	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	//generation du constructeur sans parametres
	public PlanningHorraires() 
	{
		super();
		
	}

	//generation du constructeur avec parametres
	public PlanningHorraires( double prix) 
	{
		super();
		
		this.prix = prix;
	}
	

}
