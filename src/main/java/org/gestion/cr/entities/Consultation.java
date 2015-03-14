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
	@Column(name="ID_CONSULTATION")
	private long idConsultation;
	
	
	private Date date;
	private float tailleEnfant;
	private float poidsEnfants;
	private String Description;
	
	
	@ManyToMany
	@JoinTable(name="CONSULT_ENFANT_EqSANI",joinColumns=@JoinColumn(name="ID_CONSULTATION")
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


	public String getDescription() 
	{
		return Description;
	}


	public void setDescription(String description) 
	{
		Description = description;
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
			String description) 
	{
		super();
		this.date = date;
		this.tailleEnfant = tailleEnfant;
		this.poidsEnfants = poidsEnfants;
		Description = description;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
