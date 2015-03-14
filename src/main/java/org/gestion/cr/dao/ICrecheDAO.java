package org.gestion.cr.dao;

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

public interface ICrecheDAO

{
	
	//Gestion des CategorieClubs 
	
	public Long ajouterCategorieClub(CategorieClub categorieClub,Long idClub); 
	public List<CategorieClub> listCategorieClubs(); 
	public List<CategorieClub> categorieClubParNom(String nomCategorieClub); 
	public List<CategorieClub> categorieClubParClub(Long idClub);
	public CategorieClub getCategorieClub(Long idCategorieClub); 
	public void supprimerCategorieClub(Long idCategorieClub); 
	public void modifierCategorieClub(CategorieClub categorieClub); 
	
	//Gestion des PlanningHorraires 
	
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires); 
	public List<PlanningHorraires> listPlanningHorraires(); 
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires); 
	public void supprimerPlanningHorraires(Long idPlanningHorraires); 
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires); 
	
	//Gestion des Tarifs     
	
	public Long ajouterTarif(Tarif tarif,Long idPlanningHorraires, Long idEnfant); 
	public List<Tarif> listTarifs(); 
	public List<Tarif> tarifParPlanningHorraires(Long idPlanningHorraires); 
	public List<Enfant> getenfantbyTarif(Long idTarif); 
	public Tarif getTarif(Long idTarif); 
	public void supprimerTarif(Long idTarif); 
	public void modifierTarif(Tarif tarif); 
	
	//Gestion des Menus  
	
	public Long ajouterMenus(Menus menus,Long idTarif); 
	public List<Menus> listMenus(); 
	public List<Menus> menusParNom(String nomMenus);
	public List<Menus> menusParTarif(Long idTarif); 
	public Menus getMenus(Long idMenus);
	public void supprimerMenus(Long idMenus); 
	public void modifierMenus(Menus menus); 
	
	//Gestion des Clubs     
	
	public Long ajouterClubs(Clubs clubs,Long idTarif); 
	public List<Clubs> listClubs(); 
	public List<Clubs> clubsParNom(String nomClubs); 
	public List<Clubs> clubsParTarif(Long idTarif); 
	public Clubs getClubs(Long idClubs);
	public void supprimerClubs(Long idClubs); 
	public void modifierClubs(Clubs clubs); 
	
	//Gestion des Nom Classes 
	
	public Long ajouterNomClass(NomClass nomClass); 
	public List<NomClass> listNomClass(); 
	public NomClass getNomClass(Long idNomClass); 
	public void supprimerNomClass(Long idNomClass);
	public void modifierNomClass(NomClass nomClass); 
	
	//gestion des Creches   Composition des Classes 
	
	public Long ajouterCreche(Creche creche); 
	public List<Creche> listCreches(); 
	public List<Creche> crecheParNom(String nomCreche);
	public Creche getCreche(Long idCreche); 
	public void supprimerCreche(Long idCreche); 
	public void modifierCreche(Creche creche); 
	
	//Gestion des Classes 
	
	public Long ajouterClasse(Classe classe,Long idCreche,Long idNomClass); 
	public List<Classe> listClasse(); 
	public List<Classe> classeParNom(String nomClasse);  
	public List<Classe> classeParCreche(Long idCreche); 
	public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse);
	public Classe getClasse(Long idClasse); 
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
	
	//Gestion des Equipes Technique 
	
	public Long ajouterEquipeTechnique( EquipeTechnique equipeTechnique,Long idCreche,Long idFonction);
	public List<EquipeTechnique> listEquipeTechniques(); 
	public List<EquipeTechnique> equipeTechniqueParNom(String nom);
	public List<EquipeTechnique> equipeTechniqueParCreche(Long idCreche); 
	public List<EquipeTechnique> equipeTechniqueParFonction(Long idFonction); 
	public EquipeTechnique getEquipeTechnique(Long idEquipeTechnique); 
	public void supprimerEquipeTechnique(Long idEquipeTechnique);
	public void modifierEquipeTechnique(EquipeTechnique equipeTechnique); 
	
	//Gestion des Equipes Sanitaire
	
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction); 
	public List<EquipeSanitaire> listEquipeSanitaires(); 
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom);  
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction); 
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire); 
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
	
	
	
	//Gestion des Equipes Educatifs 
	
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction); 
	public List<EquipeEducatif> listEquipeEducatif(); 
	public List<EquipeEducatif> equipeEducatifParNom(String nom); 
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction); 
	public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif); 
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif); 
	public void supprimerEquipeEducatif(Long idEquipeEducatif); 
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);
	
	//Gestion des Fonctions 
	
	public Long ajouterFonction(Fonction fonction); 
	public List<Fonction> listFonctions(); 
	public Fonction getFonction(Long idFonction); 
	public void supprimerFonction(Long idFonction); 
	public void modifierFonction(Fonction fonction); 
	
	//Gestion des Accompagnateurs 
	
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur); 
	public List<Accompagnateur> listAccompagnateurs(); 
	public List<Accompagnateur> accompagnateurParNom(String nom); 
	public Accompagnateur getAccompagnateur(Long idAccompagnateur); 
	public void supprimerAccompagnateurs(Long idAccompagnateur); 
	public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur);
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
	
	//Gestion des Genres 
	
	public Long ajouterGenre(Genre genre); 
	public List<Genre> listGenre(); 
	public Genre getGenre(Long idGenre); 
	public void supprimerGenre(Long idGenre); 
	public void modifierGenre(Genre genre); 
	
	//Gestion des Annees 
	
	public Long ajouterAnnee(Annee annee); 
	public List<Annee> listAnnees(); 
	public Annee getAnnee(Long idAnnee); 
	public void supprimerAnnees(Long idAnnee); 
	public void modifierAnnees(Annee annee); 
	public List<Annee> getAnneesByEnfantbyClasse(Long idEnfant,Long idClasse);
	public List<Enfant> getEnfantByClassebyAnnee(Long idClasse,Long idAnnee);
	public List<Classe> getClassesByEnfantbyAnnee(Long idEnfant,Long idAnnee);
	public void ajouterAnneesPourEnfantPourClasse(Long idAnnee,Long idEnfant,Long idclass);
	public void ajouterEnfantsPourAnneePourClasse(Long idEnfant,Long idAnnee,Long idclass);
	public void ajouterClassesPourAnneePourEnfant(Long idclass,Long idAnnee,Long idEnfant );
	
    //Gestion des Parents 
	
	public Long ajouterParent(Parent parent,Long idGenre); 
	public List<Parent> listParents(); 
	public List<Parent> parentParNom(String nomParent); 
	public List<Parent> parentParGenre(Long idGenre); 
	public Parent getParent(Long idParent); 
	public void supprimerParent(Long idParent); 
	public void modifierParent(Parent parent); 
	public List<Enfant> getEnfantByParent(Long idParent);
	public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
	
	//Gestion des Consultations
	
	public Long ajouterConsultation(Consultation consultation); 
	public List<Consultation> listConsultations(); 
	public Consultation getConsultation(Long idConsultation); 
	public void supprimerConsultations(Long idConsultation); 
	public void modifierConsultations(Consultation consultation); 
	public List<Consultation> getConsultationsByEnfantbyEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
	public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire,Long idConsultation);
	public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant,Long idConsultation);
	public void ajouterConsultationsPourEnfantPourEquipeSanitaire(Long idConsultation,Long idEnfant,Long idEquipeSanitaire);
	public void ajouterEnfantsPourConsultationPourEquipeSanitaire(Long idEnfant,Long idConsultation,Long idEquipeSanitaire);
	public void ajouterEquipeSanitairesPourConsultationPourEnfant(Long idEquipeSanitaire,Long idConsultation,Long idEnfant );
	
	//Gestion des Evennements
	
	public Long ajouterEvennement(Evennement evennement); 
	public List<Evennement> listEvennements(); 
	public List<Evennement> evennementParNom(String nom); 
	public Evennement getEvennement(Long idEvennement); 
	public void supprimerEvennements(Long idEvennement); 
	public void modifierEvennements(Evennement evennement); 
	public List<Enfant> getEnfantsByEvennement(Long idEvennement);
	public void ajouterEnfantsPourEvennement(Long idEnfant,Long idEvennement);
	
	//Gestion des Enfants 
	
	public Long ajouterEnfant(Enfant enfant); 
	public List<Enfant> listEnfants(); 
	public List<Enfant> enfantParNom(String nom); 
	public Enfant getEnfant(Long idEnfant); 
	public List<Enfant> enfantCertife(); 
	public List<Enfant> enfantPhotoAutorise(); 
	public List<Enfant> enfantSituationParental(); 
	public List<Enfant> enfantInscriptionEvennement(); 
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant); 
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant);
	public List<Evennement> getEvennementsByEnfant(Long idEnfant);
	public List<Tarif> gettarifbyEnfant(Long idEnfant);
	public List<Parent> getParentsByEnfant(Long idEnfant);
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterEvennementsPourEnfant(Long idEvennement,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
	public List<Enfant> getEnfantsByAnneeByClasse(Long idAnnee,Long idClasse);
	public List<Enfant> getEnfantsByConsultationByEquipeSanitaire(Long idConsultation,Long idEquipeSanitaire);
	public List<Classe> getClassesByAnneeByEnfant(Long idAnnee,Long idEnfant);
	public List<EquipeSanitaire> getEquipeSanitaireByConsultationByEnfant(Long idConsultation,Long idEnfant);
	public List<Annee> getAnneeByEnfantByClasse(Long idEnfant,Long idClasse);
	public List<Consultation> getConsultationByEnfantByEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
	public Enfant enregistrerEnfant(Annee a,Parent p);
	
	
	 
	

}
