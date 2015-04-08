package org.gestion.cr.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class GenrePlanning implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idGenrePlanning;
	
	
	
	
	private String labelle;	
	
	@OneToMany(mappedBy="genresPlannings",fetch=FetchType.LAZY)
	private Collection<PlanningHorraires> planningHorraires;

	
	
	
	//generation des guetteurs et des setteurs
	public long getIdGenrePlanning() {
		return idGenrePlanning;
	}

	public void setIdGenrePlanning(long idGenrePlanning) {
		this.idGenrePlanning = idGenrePlanning;
	}

	public String getLabelle() {
		return labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

	public Collection<PlanningHorraires> getPlanningHorraires() {
		return planningHorraires;
	}

	public void setPlanningHorraires(Collection<PlanningHorraires> planningHorraires) {
		this.planningHorraires = planningHorraires;
	}

	//generation de constructeurs sans parametres
	public GenrePlanning() {
		super();
		
	}

	//generation de constructeurs avec parametres
	public GenrePlanning(String labelle) {
		super();
		this.labelle = labelle;
	}
	
	
	
	
	
	

}
