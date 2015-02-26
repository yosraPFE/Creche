package org.gestion.cr.entities;

import java.io.Serializable;


import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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

@Entity
@Table(name="Enfants")
@DiscriminatorValue("ENF")

public class  Enfant extends Personnage implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private String sexe;
	private  Date dateNaissance;
	private String lieuNaissance;
	private String langue;
	private String antecedantsMedicaux;
	private String situationParentale;
	private Date dateInscription;
	private String certificatMedicale;
	private String autorisationPrisePhoto;
	private String nomPrenomPediatre;
	private String telephonePortablePediatre;
	private int nombreFreres;
	private int nombreSoeur;
	
	/*
	 * un enfant possede une et une seule FicheAnnexeEnfant associé a lui
	 */
	
	@OneToOne(mappedBy="enfant",cascade=CascadeType.ALL)
	private FicheAnnexeEnfant ficheAnnexeEnfant;
	
	@OneToOne(mappedBy="enfant",cascade=CascadeType.ALL)
	private Tarif tarif;
	
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
    private Collection<Accompagnateur> accompagnateurAbsences;
	
	@ManyToMany(mappedBy="enfants")
	private Collection<Parent> parents;
	
	@ManyToMany(mappedBy="enfants")
	private Collection<EquipeSanitaire> equipeSanitaires;
	
	
	//generateur du guetteurs et du setteurs
	public String getSexe() 
	{
		return sexe;
	}
	public void setSexe(String sexe) 
	{
		this.sexe = sexe;
	}
	public Date getDateNaissance() 
	{
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance)
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
	public Date getDateInscription() 
	{
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) 
	{
		this.dateInscription = dateInscription;
	}
	public String getCertificatMedicale() 
	{
		return certificatMedicale;
	}
	public void setCertificatMedicale(String certificatMedicale)
	{
		this.certificatMedicale = certificatMedicale;
	}
	
	
	public Collection<Accompagnateur> getAccompagnateurAbsences() 
	{
		return accompagnateurAbsences;
	}
	public void setAccompagnateurAbsences(
			Collection<Accompagnateur> accompagnateurAbsences) 
	{
		this.accompagnateurAbsences = accompagnateurAbsences;
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
	
	public FicheAnnexeEnfant getFicheAnnexeEnfant()
	{
		return ficheAnnexeEnfant;
	}
	public void setFicheAnnexeEnfant(FicheAnnexeEnfant ficheAnnexeEnfant) 
	{
		this.ficheAnnexeEnfant = ficheAnnexeEnfant;
	}
	public Tarif getTarif() 
	{
		return tarif;
	}
	public void setTarif(Tarif tarif)
	{
		this.tarif = tarif;
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
	
	
	public String getAutorisationPrisePhoto() 
	{
		return autorisationPrisePhoto;
	}
	public void setAutorisationPrisePhoto(String autorisationPrisePhoto) 
	{
		this.autorisationPrisePhoto = autorisationPrisePhoto;
	}
	//generateur du constructeur sans parametres
	public Enfant()
	{
		super();
		
	}
	//generateur du constructeur avec parametres
	public Enfant(String nom, String prenom, byte[] photo, String sexe,
			Date dateNaissance, String lieuNaissance, String langue,
			String antecedantsMedicaux, String situationParentale,
			Date dateInscription, String certificatMedicale) {
		super(nom, prenom, photo);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.langue = langue;
		this.antecedantsMedicaux = antecedantsMedicaux;
		this.situationParentale = situationParentale;
		this.dateInscription = dateInscription;
		this.certificatMedicale = certificatMedicale;
	}
	
	
	
	
	
	

}
