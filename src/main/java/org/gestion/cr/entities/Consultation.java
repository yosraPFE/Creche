package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Consultation implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idConsultation;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	private float tailleEnfant;
	private float poidsEnfants;
	private String description;
	
	
	@ManyToMany
	@JoinTable(name="CONSULT_ENFANT_EqSANI",joinColumns=@JoinColumn(name="idConsultation")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	
	@ManyToMany(mappedBy="consultations") 
    private Collection<EquipeSanitaire> equipeSanitaires ;

    //generation des guetteurs et des setteurs
	public long getIdConsultation() 
	{
		return idConsultation;
	}


	public void setIdConsultation(long idConsultation) 
	{
		this.idConsultation = idConsultation;
	}


	public Date getDate() 
	{
		return date;
	}


	public void setDate(Date date)
	{
		this.date = date;
	}


	public float getTailleEnfant()
	{
		return tailleEnfant;
	}


	public void setTailleEnfant(float tailleEnfant) 
	{
		this.tailleEnfant = tailleEnfant;
	}


	public float getPoidsEnfants() 
	{
		return poidsEnfants;
	}


	public void setPoidsEnfants(float poidsEnfants) 
	{
		this.poidsEnfants = poidsEnfants;
	}
 
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Collection<Enfant> getEnfants() 
	{
		return enfants;
	}


	public void setEnfants(Collection<Enfant> enfants)
	{
		this.enfants = enfants;
	}


	public Collection<EquipeSanitaire> getEquipeSanitaires() 
	{
		return equipeSanitaires;
	}


	public void setEquipeSanitaires(Collection<EquipeSanitaire> equipeSanitaires) 
	{
		this.equipeSanitaires = equipeSanitaires;
	}

   //Generation des constructeurs sans parametres
	public Consultation() 
	{
		super();
		
	}

	//Generation des constructeurs avec parametres


	public Consultation(Date date, float tailleEnfant, float poidsEnfants,
			String description) {
		super();
		this.date = date;
		this.tailleEnfant = tailleEnfant;
		this.poidsEnfants = poidsEnfants;
		this.description = description;
	}
	
	

}
