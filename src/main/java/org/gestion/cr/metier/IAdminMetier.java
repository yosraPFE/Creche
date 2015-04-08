package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Clubs;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Equipe;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.Evennement;
import org.gestion.cr.entities.Fonction;
import org.gestion.cr.entities.Fournisseur;
import org.gestion.cr.entities.GenrePlanning;
import org.gestion.cr.entities.Inscription;
import org.gestion.cr.entities.Materiels;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.entities.Personnage;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.entities.Stock;
import org.gestion.cr.entities.TypeMateriels;

public interface IAdminMetier extends InternauteMetier

{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	//Gestion des CategorieClubs 
	
	public Long ajouterCategorieClub(CategorieClub categorieClub); 
	public void supprimerCategorieClub(Long idCategorieClub); 
	public void modifierCategorieClub(CategorieClub categorieClub);
	
	
	//Gestion des PlanningHorraires
	
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires,Long idGenrePlanning); 
	public void supprimerPlanningHorraires(Long idPlanningHorraires); 
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires); 
	public void ajouterInscriptionPourPlanningHorraires(Long idInscription,Long idPlanningHorraires);
	
	
	//Gestion des Clubs
	
	public Long ajouterClubs(Clubs clubs,Long idInscription,Long idCtagorieClubs);
	public void supprimerClubs(Long idClubs); 
	public void modifierClubs(Clubs clubs); 
	
	
	//Gestion des GenresPlanningHorraires
	
	public Long ajouterGenrePlanning(GenrePlanning genrePlanning);
	public void supprimerGenrePlanning(Long idGenrePlanning); 
	public void modifierGenrePlanning(GenrePlanning genrePlanning); 
	
	
	//gestion des Creches 
	
	
	public Long ajouterCreche(Creche creche);
	public void supprimerCreche(Long idCreche); 
	public void modifierCreche(Creche creche); 
	
	
	//Gestion des Classes
	
	public Long ajouterClasse(Classe classe,Long idCreche); 
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
	
	//Gestion des Equipes
	
	public Long ajouterEquipe(Equipe equipe); 
	public void supprimerEquipes(Long idEquipe); 
	public void modifierEquipes(Equipe equipe); 
	public void ajouterMaterielPourEquipe(Long idMateriel,Long idEquipe);
	
	
	//Gestion des Personnages
	
	public Long ajouterPersonnage(Personnage personnage); 
	public void supprimerPersonnage(Long idPersonnage); 
    public void modifierPersonnages(Personnage personnage); 
	
	
	//Gestion des Equipes Sanitaire
	
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction);
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
	
	
	//Gestion des Equipes Educatifs 
	
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction);
	public void supprimerEquipeEducatif(Long idEquipeEducatif); 
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);
	
	//Gestion des Fonctions 
	
	public Long ajouterFonction(Fonction fonction); 
	public void supprimerFonction(Long idFonction); 
	public void modifierFonction(Fonction fonction);
	
	//Gestion des Accompagnateurs 
	
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur);
	public void supprimerAccompagnateurs(Long idAccompagnateur); 
	public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
	
	
	//Gestion des Inscriptions
	
	public Long ajouterInscription(Inscription inscription); 
	public void supprimerInscriptions(Long idInscription); 
	public void modifierInscriptions(Inscription inscription);
	public void ajouterInscriptionsPourEnfantPourClasse(Long idInscription,Long idEnfant,Long idclass);
	public void ajouterEnfantsPourInscriptionPourClasse(Long idEnfant,Long idInscription,Long idclass);
	public void ajouterClassesPourInscriptionPourEnfant(Long idclass,Long idInscription,Long idEnfant );
	public void ajouterPlanningHorrairsPourInscription(Long idPlanningHorraires,Long idInscription);
	
	
	 //Gestion des Parents 
	
	public Long ajouterParent(Parent parent); 
	public void supprimerParent(Long idParent); 
	public void modifierParent(Parent parent); 
	public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
	
	
	//Gestion des Consultations
	
	public Long ajouterConsultation(Consultation consultation); 
	public void supprimerConsultations(Long idConsultation); 
	public void modifierConsultations(Consultation consultation); 
	public void ajouterConsultationsPourEnfantPourEquipeSanitaire(Long idConsultation,Long idEnfant,Long idEquipeSanitaire);
	public void ajouterEnfantsPourConsultationPourEquipeSanitaire(Long idEnfant,Long idConsultation,Long idEquipeSanitaire);
	public void ajouterEquipeSanitairesPourConsultationPourEnfant(Long idEquipeSanitaire,Long idConsultation,Long idEnfant );
	
	
	//Gestion des Evennements
	
	public Long ajouterEvennement(Evennement evennement); 
	public void supprimerEvennements(Long idEvennement); 
	public void modifierEvennements(Evennement evennement); 
	public void ajouterEnfantsPourEvennement(Long idEnfant,Long idEvennement);
	
	
	//Gestion des Enfants 
	
	public Long ajouterEnfant(Enfant enfant); 
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant); 
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterEvennementsPourEnfant(Long idEvennement,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
	
	
	//Gestion des Fournisseurs
	
	public Long ajouterFournisseur(Fournisseur fournisseur);
	public void supprimerFournisseur(Long idFournisseur); 
	public void modifierFournisseur(Fournisseur fournisseur); 
	public void ajouterMaterielsPourFournisseur(Long idMateriels,Long idFournisseur);
	
	
	//Gestion des Materiels
	
	
	public Long ajouterMateriels(Materiels materiels,Long idTypeMateriels,Long idStock);
	public void supprimerMateriels(Long idMateriels); 
	public void modifierMateriels(Materiels materiels);
	public void ajouterFournisseurPourMateriels(Long idFournisseur,Long idMateriels);
	public void ajouterEquipePourMateriels(Long idEquipe,Long idMateriels);
	
	
	//Gestion des typesMateriels
	
	
	public Long ajouterTypeMateriel(TypeMateriels typeMateriels);
	public void supprimerTypeMateriels(Long idTypeMateriels); 
	public void modifierTypeMateriels(TypeMateriels typeMateriels); 
	
	
	//Gestion des stocks materiels
	
	public Long ajouterStock(Stock stock); 
	public void supprimerStock(Long idStock); 
	public void modifierStock(Stock stock); 

}

