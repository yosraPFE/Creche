package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
@Table(name="EquipeSanitaires")
@DiscriminatorValue("EQ_SAN")

public class EquipeSanitaire extends Equipe implements Serializable
{	
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	@ManyToOne
	@JoinColumn(name="ID_FONCTION")
	private Fonction fonction;
	
	@ManyToMany
	@JoinTable(name="EQSAN_ENF",joinColumns=@JoinColumn(name="ID_EQ_SAN"),
	inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
     
	//generateur du guetteurs et du setteurs
	public Fonction getFonction() 
	{
		return fonction;
	}

	public void setFonction(Fonction fonction) 
	{
		this.fonction = fonction;
	}
	public Collection<Enfant> getEnfants() 
	{
		return enfants;
	}

	public void setEnfants(Collection<Enfant> enfants) 
	{
		this.enfants = enfants;
	}
	
    
	//generateur du constructeur sans parametres
	public EquipeSanitaire() 
	{
		super();
		
	}
	//generateur du constructeur avec parametres


	public EquipeSanitaire(Date dateNaissance, String lieuNaissance,
			String sexe, String adresseDomicile, String nomUtilisateur,
			String motPasse) {
		super(dateNaissance, lieuNaissance, sexe, adresseDomicile,
				nomUtilisateur, motPasse);
	}

	
	
	
	
	
		

}
