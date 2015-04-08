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
@DiscriminatorValue("EquipeSanitaire")
public class EquipeSanitaire extends Equipe implements Serializable
{	
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	@ManyToOne
	@JoinColumn(name="idFonction")
	private Fonction fonction;
	
	@ManyToMany
	@JoinTable(name="CONSULT_ENFANT_EqSANI",joinColumns=@JoinColumn(name="ID_EQ_SAN"),
	inverseJoinColumns=@JoinColumn(name="idConsultation"))
	private Collection<Consultation> consultations;
	
	@ManyToMany
	@JoinTable(name="CONSULT_ENFANT_EqSANI",joinColumns=@JoinColumn(name="ID_EQ_SAN")
	,inverseJoinColumns=@JoinColumn(name="ID_ENFANT"))
	private Collection<Enfant> enfants;
	
	//generation du guetteurs et du setteurs
    public Fonction getFonction() 
	{
		return fonction;
	}

	public void setFonction(Fonction fonction) 
	{
		this.fonction = fonction;
	}

	public Collection<Consultation> getConsultations() 
	{
		return consultations;
	}

	public void setConsultations(Collection<Consultation> consultations) 
	{
		this.consultations = consultations;
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
		public EquipeSanitaire() 
		{
			super();
			
		}
		
	
   //generation des constructeurs avec parametres
	public EquipeSanitaire(String nom, String prenom, byte[] photo,
			String nomPhoto, String dateNaissance, String lieuNaissance,
			String sexe, String adresseDomicile, String nomUtilisateur,
			String motPasse)
	{
		super(nom, prenom, photo, nomPhoto, dateNaissance, lieuNaissance, sexe,
				adresseDomicile, nomUtilisateur, motPasse);
	}

	@Override
	public String toString() {
		
		return "Equipe Sanitaire";
	}

}
