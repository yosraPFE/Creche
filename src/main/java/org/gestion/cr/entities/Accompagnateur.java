package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity

@DiscriminatorValue("Accompagnateur")

public class Accompagnateur extends Personnage implements Serializable 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	@NotEmpty
	private String cin;	
	@Size(min=5)
	private String description;
	@NotEmpty
	private String telephonePortable;
	

	
	@ManyToMany
	@JoinTable(name="ACC_ENF",joinColumns=@JoinColumn(name="ID_ACOMP_ABSENCE")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	
	//generation  des guetteurs et des setteurs
	public String getCin() 
	{
		return cin;
	}
	public void setCin(String cin) 
	{
		this.cin = cin;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public String getTelephonePortable() 
	{
		return telephonePortable;
	}
	public void setTelephonePortable(String telephonePortable)
	{
		this.telephonePortable = telephonePortable;
	}
	public Collection<Enfant> getEnfants() 
	{
		return enfants;
	}
	public void setEnfants(Collection<Enfant> enfants) 
	{
		this.enfants = enfants;
	}
	
	//generation du constructeur sans parametres
	public Accompagnateur() 
	{
		super();
		
	}
	
	
	//generateur du constructeur avec parametres
	public Accompagnateur(String nom, String prenom, byte[] photo,
			String nomPhoto, String cin, String description,
			String telephonePortable) 
	{
		super(nom, prenom, photo, nomPhoto);
		this.cin = cin;
		this.description = description;
		this.telephonePortable = telephonePortable;
		
	}
	
	@Override
	public String toString() {
		
		return "Accompagnateur";
	}

}
