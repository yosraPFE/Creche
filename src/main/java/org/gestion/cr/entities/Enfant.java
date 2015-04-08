package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;








import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@DiscriminatorValue("Enfant")
public class  Enfant extends Personnage implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	private String sexe;
	
	
	private  String dateNaissance;
	
	private String lieuNaissance;
	
	private String langue;
	
	private String antecedantsMedicaux;
	
	private String situationParentale;
	
	
	
	private boolean certificatMedicale;
	
	private boolean autorisationPrisePhoto;
	
	
	private String nomPrenomPediatre;
	
	private String telephonePortablePediatre;
	private int nombreFreres;
	private int nombreSoeur;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Accompagnateur> accompagnateurs;
	
	@ManyToMany(mappedBy="enfants")
	private Collection<Parent> parents;
	
	@ManyToMany(mappedBy="enfants")
	private Collection<EquipeSanitaire> equipeSanitaires;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Classe> classes;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Inscription> inscriptions;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Evennement> evenements;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Consultation> consultations;
	
	
	
	
	
	//Generation des guetteurs et des setteurs
	public String getSexe()
	{
		return sexe;
	}
	public void setSexe(String sexe) 
	{
		this.sexe = sexe;
	}
	public String getDateNaissance()
	{
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) 
	{
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() 
	{
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) 
	{
		this.lieuNaissance = lieuNaissance;
	}
	public String getLangue() 
	{
		return langue;
	}
	public void setLangue(String langue) 
	{
		this.langue = langue;
	}
	public String getAntecedantsMedicaux() 
	{
		return antecedantsMedicaux;
	}
	public void setAntecedantsMedicaux(String antecedantsMedicaux) 
	{
		this.antecedantsMedicaux = antecedantsMedicaux;
	}
	public String getSituationParentale() 
	{
		return situationParentale;
	}
	public void setSituationParentale(String situationParentale) 
	{
		this.situationParentale = situationParentale;
	}
	
	public boolean getCertificatMedicale() 
	{
		return certificatMedicale;
	}
	public void setCertificatMedicale(boolean certificatMedicale) 
	{
		this.certificatMedicale = certificatMedicale;
	}
	public boolean getAutorisationPrisePhoto()
	{
		return autorisationPrisePhoto;
	}
	public void setAutorisationPrisePhoto(boolean autorisationPrisePhoto) 
	{
		this.autorisationPrisePhoto = autorisationPrisePhoto;
	}
	public String getNomPrenomPediatre() 
	{
		return nomPrenomPediatre;
	}
	public void setNomPrenomPediatre(String nomPrenomPediatre) 
	{
		this.nomPrenomPediatre = nomPrenomPediatre;
	}
	public String getTelephonePortablePediatre()
	{
		return telephonePortablePediatre;
	}
	public void setTelephonePortablePediatre(String telephonePortablePediatre)
	{
		this.telephonePortablePediatre = telephonePortablePediatre;
	}
	public int getNombreFreres() 
	{
		return nombreFreres;
	}
	public void setNombreFreres(int nombreFreres) 
	{
		this.nombreFreres = nombreFreres;
	}
	public int getNombreSoeur() 
	{
		return nombreSoeur;
	}
	public void setNombreSoeur(int nombreSoeur) 
	{
		this.nombreSoeur = nombreSoeur;
	}
	
	public Collection<Parent> getParents() 
	{
		return parents;
	}
	public void setParents(Collection<Parent> parents) 
	{
		this.parents = parents;
	}
	public Collection<EquipeSanitaire> getEquipeSanitaires() 
	{
		return equipeSanitaires;
	}
	public void setEquipeSanitaires(Collection<EquipeSanitaire> equipeSanitaires) 
	{
		this.equipeSanitaires = equipeSanitaires;
	}
	public Collection<Classe> getClasses() 
	{
		return classes;
	}
	public void setClasses(Collection<Classe> classes) 
	{
		this.classes = classes;
	}
	
	
	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public Collection<Accompagnateur> getAccompagnateurs() 
	{
		return accompagnateurs;
	}
	public void setAccompagnateurs(Collection<Accompagnateur> accompagnateurs)
	{
		this.accompagnateurs = accompagnateurs;
	}
	
	
	public Collection<Consultation> getConsultations() 
	{
		return consultations;
	}
	public void setConsultations(Collection<Consultation> consultations) 
	{
		this.consultations = consultations;
	}
	public Collection<Evennement> getEvenements() 
	{
		return evenements;
	}
	public void setEvenements(Collection<Evennement> evenements) 
	{
		this.evenements = evenements;
	}
	
	
	//generation du constructeur sans parametres
	public Enfant()
	{
		super();
		
	}
	//generation du constructeur avec parametres
	public Enfant(String nom, String prenom, byte[] photo, String nomPhoto,
			String sexe, String dateNaissance, String lieuNaissance,
			String langue, String antecedantsMedicaux,
			String situationParentale, boolean certificatMedicale,
			boolean autorisationPrisePhoto, String nomPrenomPediatre,
			String telephonePortablePediatre, int nombreFreres, int nombreSoeur) {
		super(nom, prenom, photo, nomPhoto);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.langue = langue;
		this.antecedantsMedicaux = antecedantsMedicaux;
		this.situationParentale = situationParentale;
		this.certificatMedicale = certificatMedicale;
		this.autorisationPrisePhoto = autorisationPrisePhoto;
		this.nomPrenomPediatre = nomPrenomPediatre;
		this.telephonePortablePediatre = telephonePortablePediatre;
		this.nombreFreres = nombreFreres;
		this.nombreSoeur = nombreSoeur;
	}
	
	@Override
	public String toString() {
	
		return "Enfant";
	}
	
		
	

}
