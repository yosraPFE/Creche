package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Annee;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.entities.Tarif;

public interface IAdminEnfantsMetier extends InternauteMetier
{
	//Gestion des Enfants
	public Long ajouterEnfant(Enfant enfant,Long idFicheAnnexeEnfant); 
	public List<Enfant> enfantCertife(); 
	public List<Enfant> enfantPhotoAutorise(); 
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant);
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
	public void ajouterEquipesSanitairesPourEnfant(Long idEquipeSanitaire,Long idEnfant);
	
	
	//Gestion des Tarifs
	public Long ajouterTarif(Tarif tarif,Long idPlanningHorraires,Long idEnfant); 
	public void supprimerTarif(Long idTarif); 
	public void modifierTarif(Tarif tarif); 
	
	
	//Gestion Accompagnateur
    public void supprimerAccompagnateurs(Long idAccompagnateur); 
    public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
    public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);

    
    //Gestion des Parents
    public Long ajouterParent(Parent parent,Long idGenre); 
	public List<Parent> listParents(); 
	public List<Parent> parentParNom(String nomParent); 
	public List<Parent> parentParGenre(Long idGenre); 
	public void supprimerParent(Long idParent); 
	public void modifierParent(Parent parent); 
	public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
	
	
	
	//Gestion des Equipes Sanitaires
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction);
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
	public void ajouterEnfantsPourEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
	
	
	
	//Gestion des Classes
	public Long ajouterClasse(Classe classe,Long idCreche,Long idNomClass);
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
	
	
	
	//Gestion des Annees
	public Long ajouterAnnee(Annee annee);
	public void supprimerAnnees(Long idAnnee); 
	public void modifierAnnees(Annee annee); 
	public void ajouterAnneesPourEnfantPourClasse(Long idAnnee,Long idEnfant,Long idclass);
	public void ajouterEnfantsPourAnneePourClasse(Long idEnfant,Long idAnnee,Long idclass);
	public void ajouterClassesPourAnneePourEnfant(Long idclass,Long idAnnee,Long idEnfant );
	
	
	
	
}
