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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	private boolean situationParentale;
	
	private Date dateInscription;
	private boolean certificatMedicale;
	
	private boolean autorisationPrisePhoto;
	private boolean inscriptionEvenement;
	
	private String nomPrenomPediatre;
	
	private String telephonePortablePediatre;
	private int nombreFreres;
	private int nombreSoeur;
	
	
	
	/*puisque la classe "Enfant" a une collection de "Classe" qui a
	* un objet de type enfant qui s'appelle "enfant" on le met pour le mapping :mappedBy="enfant"
	*et Lazy par defaut*/
	
	
	
	/* l'annotation dans cette classe ne va pas etre accopagné par une table de jointure car c'est 
	 * deja declaré dans l'autre table Accompagnateur d'absence associative 
	 * (mappedBy="enfants"):enfant est une collection des objets de type Enfant dans 
	 * la classe AccompagnateurAbsence
	 *  */
	
	//mappedBy reference une propriété de l'entité cible
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Accompagnateur> accompagnateurs;
	
	@ManyToMany(mappedBy="enfants")
	private Collection<Parent> parents;
	
	@ManyToMany(mappedBy="enfants")
	private Collection<EquipeSanitaire> equipeSanitaires;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Classe> classes;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Annee> annees;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Evennement> evenements;
	
	
	@ManyToMany(mappedBy="enfants") 
    private Collection<Consultation> consultations;
	
	@ManyToOne
	@JoinColumn(name="ID_TARIF")
	private Tarif tarif;
	
	
	
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
	public boolean getSituationParentale() 
	{
		return situationParentale;
	}
	public void setSituationParentale(boolean situationParentale) 
	{
		this.situationParentale = situationParentale;
	}
	public Date getDateInscription() 
	{
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) 
	{
		this.dateInscription = dateInscription;
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
	public Collection<Annee> getAnnees() 
	{
		return annees;
	}
	public void setAnnees(Collection<Annee> annees) 
	{
		this.annees = annees;
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
	public boolean isInscriptionEvenement() 
	{
		return inscriptionEvenement;
	}
	public void setInscriptionEvenement(boolean inscriptionEvenement) {
		this.inscriptionEvenement = inscriptionEvenement;
	}
	
	
	public Tarif getTarif() 
	{
		return tarif;
	}
	public void setTarif(Tarif tarif) 
	{
		this.tarif = tarif;
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
			boolean situationParentale, Date dateInscription,
			boolean certificatMedicale, boolean autorisationPrisePhoto,
			boolean inscriptionEvenement, String nomPrenomPediatre,
			String telephonePortablePediatre, int nombreFreres, int nombreSoeur) {
		super(nom, prenom, photo, nomPhoto);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.langue = langue;
		this.antecedantsMedicaux = antecedantsMedicaux;
		this.situationParentale = situationParentale;
		this.dateInscription = dateInscription;
		this.certificatMedicale = certificatMedicale;
		this.autorisationPrisePhoto = autorisationPrisePhoto;
		this.inscriptionEvenement = inscriptionEvenement;
		this.nomPrenomPediatre = nomPrenomPediatre;
		this.telephonePortablePediatre = telephonePortablePediatre;
		this.nombreFreres = nombreFreres;
		this.nombreSoeur = nombreSoeur;
	}
	
	
		
	

}
