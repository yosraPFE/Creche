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

@Entity
@Table(name="AccompagnateurAbsences")
//classe heritante de la classe mere Personnage
@DiscriminatorValue("ACP")

public class Accompagnateur extends Personnage implements Serializable 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	private String cin;
	private String description;
	private String telephonePortable;
	
	/*pour l'annotation ManyToMany on declare un table de jointure qui contient les deux cl� etranger
	 * de deux tables associative AccompagnateurAbsence et Enfant
     */
	@ManyToMany
	@JoinTable(name="ACC_ENF",joinColumns=@JoinColumn(name="ID_ACOMP_ABSENCE")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	//generateur du guetteurs et du setteurs
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
	
	
	//generateur du constructeur sans parametres
	public Accompagnateur() 
	{
		super();
		
	}
	public Collection<Enfant> getEnfants() 
	{
		return enfants;
	}
	public void setEnfants(Collection<Enfant> enfants) 
	{
		this.enfants = enfants;
	}
	
	//generateur du constructeur avec parametres
	public Accompagnateur(String nom, String prenom, byte[] photo,
			String cin, String description, String telephonePortable) {
		super(nom, prenom, photo);
		this.cin = cin;
		this.description = description;
		this.telephonePortable = telephonePortable;
	}
	
	
	
	

}