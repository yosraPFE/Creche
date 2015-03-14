package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Annee;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Clubs;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.EquipeTechnique;
import org.gestion.cr.entities.Evennement;
import org.gestion.cr.entities.Fonction;
import org.gestion.cr.entities.Genre;
import org.gestion.cr.entities.Menus;
import org.gestion.cr.entities.NomClass;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.entities.Tarif;

public interface IAdminMetier extends InternauteMetier

{
	
	
	//Gestion des Categories Clubs
    public Long ajouterCategorieClub(CategorieClub categorieClub,Long idClub);
	public void supprimerCategorieClub(Long idCategorieClub); 
	public void modifierCategorieClub(CategorieClub categorieClub);
	
			
	//Gestion des Planning Horraires
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires); 
	public void supprimerPlanningHorraires(Long idPlanningHorraires); 
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires); 
			
			
	//Gestion des Tarifs
	public Long ajouterTarif(Tarif tarif,Long idPlanningHorraires,Long idEnfant); 
	public void supprimerTarif(Long idTarif); 
	public void modifierTarif(Tarif tarif); 
	
			
	//Gestion des Menus
	public Long ajouterMenus(Menus menus,Long idTarif); 
	public void supprimerMenus(Long idMenus); 
	public void modifierMenus(Menus menus);
	
			
	//Gestion des Clubs
	public Long ajouterClubs(Clubs clubs,Long idTarif); 
	public void supprimerClubs(Long idClubs); 
	public void modifierClubs(Clubs clubs); 
	
			
	//Gestion des Nom Classes
	public Long ajouterNomClass(NomClass nomClass); 
	public void supprimerNomClass(Long idNomClass);
	public void modifierNomClass(NomClass nomClass); 
			
			

	//Gestion des Creches
	public Long ajouterCreche(Creche creche); 
	public void supprimerCreche(Long idCreche); 
	public void modifierCreche(Creche creche); 
			
			
	//Gestion des Classes
	public Long ajouterClasse(Classe classe,Long idCreche,Long idNomClass);
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
			
			
	//Gestion des Equipes Techniques
	public Long ajouterEquipeTechnique( EquipeTechnique equipeTechnique,Long idCreche,Long idFonction);
	public void supprimerEquipeTechnique(Long idEquipeTechnique);
	public void modifierEquipeTechnique(EquipeTechnique equipeTechnique);
			
			
	//Gestion des Equipes Sanitaires
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
		
			
	//Gestion Accompagnateur
	public void supprimerAccompagnateurs(Long idAccompagnateur); 
	public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
			
	//Gestion des Genres 
	public Long ajouterGenre(Genre genre); 
	public void supprimerGenre(Long idGenre); 
	public void modifierGenre(Genre genre);
			
			
	//Gestion des Annees
	public Long ajouterAnnee(Annee annee);
	public void supprimerAnnees(Long idAnnee); 
	public void modifierAnnees(Annee annee); 
	public void ajouterAnneesPourEnfantPourClasse(Long idAnnee,Long idEnfant,Long idclass);
	public void ajouterEnfantsPourAnneePourClasse(Long idEnfant,Long idAnnee,Long idclass);
	public void ajouterClassesPourAnneePourEnfant(Long idclass,Long idAnnee,Long idEnfant );
			
			
    //Gestion des Parents
    public Long ajouterParent(Parent parent,Long idGenre); 
	public List<Parent> listParents(); 
	public List<Parent> parentParNom(String nomParent); 
	public List<Parent> parentParGenre(Long idGenre); 
	public void supprimerParent(Long idParent); 
	public void modifierParent(Parent parent); 
	public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
			
			
	//Gestion Enfant
	
	public Long ajouterEnfant(Enfant enfant);
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant); 
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterEvennementsPourEnfant(Long idEvennement,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
	public Enfant enregistrerEnfant(Annee a,Parent p);
	
	//gestion des Consultations
	
	public Long ajouterConsultation(Consultation consultation); 
	public void modifierConsultations(Consultation consultation); 
	public void ajouterConsultationsPourEnfantPourEquipeSanitaire(Long idConsultation,Long idEnfant,Long idEquipeSanitaire);
	public void ajouterEnfantsPourConsultationPourEquipeSanitaire(Long idEnfant,Long idConsultation,Long idEquipeSanitaire);
	public void ajouterEquipeSanitairesPourConsultationPourEnfant(Long idEquipeSanitaire,Long idConsultation,Long idEnfant );
	
	//Gestion des Evennements
	
	public Long ajouterEvennement(Evennement evennement);
	public void supprimerEvennements(Long idEvennement); 
	public void modifierEvennements(Evennement evennement); 
	public void ajouterEnfantsPourEvennement(Long idEnfant,Long idEvennement);
			

}
