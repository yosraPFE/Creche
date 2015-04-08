package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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








import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Inscription implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long idinscription;
	
	
	private String annee;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateInscription;
	
	private double tarifInscription;
	private  double remise;
	
	@ManyToMany(mappedBy="inscriptions") 
    private Collection<Classe> classes;
	
	@ManyToMany
	@JoinTable(name="INSC_PLAN",joinColumns=@JoinColumn(name="idinscription")
	,inverseJoinColumns=@JoinColumn(name="idPlanning"))
	private Collection<PlanningHorraires> planningHorraires;
	
	
	
	@OneToMany(mappedBy="inscription",fetch=FetchType.LAZY)
	private Collection<Clubs> clubs;
	

	@ManyToMany
	@JoinTable(name="CLASS_INSC_ENF",joinColumns=@JoinColumn(name="idinscription")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;

	
    //Genreation des guetteurs et des setteurs
	
	

	public String getAnnee()
	{
		return annee;
	}

	public long getIdinscription() {
		return idinscription;
	}

	public void setIdinscription(long idinscription) {
		this.idinscription = idinscription;
	}

	public double getTarifInscription() {
		return tarifInscription;
	}

	public void setTarifInscription(double tarifInscription) {
		this.tarifInscription = tarifInscription;
	}

	public void setAnnee(String annee)
	{
		this.annee = annee;
	}

	public Collection<Classe> getClasses() 
	{
		return classes;
	}

	public void setClasses(Collection<Classe> classes)
	{
		this.classes = classes;
	}

	public Collection<Enfant> getEnfants()
	{
		return enfants;
	}

	public void setEnfants(Collection<Enfant> enfants) 
	{
		this.enfants = enfants;
	}
	
	
	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public Collection<PlanningHorraires> getPlanningHorraires() {
		return planningHorraires;
	}

	public void setPlanningHorraires(Collection<PlanningHorraires> planningHorraires) {
		this.planningHorraires = planningHorraires;
	}

	public Collection<Clubs> getClubs() {
		return clubs;
	}

	public void setClubs(Collection<Clubs> clubs) {
		this.clubs = clubs;
	}
	
	

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	//Generation du constructeur sans parametres
	public Inscription() 
	{
		super();
		
	}
	  //geberation du constructeur avec parametres

	public Inscription(String annee, Date dateInscription,
			double tarifInscription, double remise) {
		super();
		this.annee = annee;
		this.dateInscription = dateInscription;
		this.tarifInscription = tarifInscription;
		this.remise = remise;
	}

	
	
	
	
	
}
