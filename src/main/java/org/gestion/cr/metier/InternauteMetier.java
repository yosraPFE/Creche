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

public interface InternauteMetier
{
	
	
	//Consulter Categories clubs
	public List<CategorieClub> listCategorieClubs(); 
	public List<CategorieClub> categorieClubParNom(String nomCategorieClub); 
	public List<CategorieClub> categorieClubParClub(Long idClub);
	public CategorieClub getCategorieClub(Long idCategorieClub); 
	
	
	//Consulter Planning Horraires 
	public List<PlanningHorraires> listPlanningHorraires(); 
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires); 
	
	
	//Consulter Tarifs 
	
	public List<Tarif> listTarifs(); 
	public List<Tarif> tarifParPlanningHorraires(Long idPlanningHorraires); 
	public List<Enfant> getenfantbyTarif(Long idTarif); 
	public Tarif getTarif(Long idTarif); 
	
	
	
	//Consulter Menues 
	public List<Menus> listMenus(); 
	public List<Menus> menusParNom(String nomMenus);
	public List<Menus> menusParTarif(Long idTarif); 
	public Menus getMenus(Long idMenus);
	
	
	//Consulter Clubs 
	public List<Clubs> listClubs(); 
	public List<Clubs> clubsParNom(String nomClubs); 
	public List<Clubs> clubsParTarif(Long idTarif); 
	public Clubs getClubs(Long idClubs);
	
	
	//Consulter Nom de Classes
	public List<NomClass> listNomClass(); 
	public NomClass getNomClass(Long idNomClass); 
	
	
	//Consulter  Creche 
	public List<Creche> listCreches(); 
	public List<Creche> crecheParNom(String nomCreche);
	public Creche getCreche(Long idCreche); 
	
	
	//Consulter  Classes 
	public List<Classe> listClasse(); 
	public List<Classe> classeParNom(String nomClasse);  
	public List<Classe> classeParCreche(Long idCreche); 
	public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse);
	public Classe getClasse(Long idClasse); 
	
	
	//Consulter  Equipes Techniques 
	public List<EquipeTechnique> listEquipeTechniques(); 
	public List<EquipeTechnique> equipeTechniqueParNom(String nom);
	public List<EquipeTechnique> equipeTechniqueParCreche(Long idCreche); 
	public List<EquipeTechnique> equipeTechniqueParFonction(Long idFonction); 
	public EquipeTechnique getEquipeTechnique(Long idEquipeTechnique); 
	
	
	//Consulter Equipes Sanitaires 
	public List<EquipeSanitaire> listEquipeSanitaires(); 
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom);  
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction); 
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire); 
	
	
	
	//Consulter  Equipes Educatifs 
	public List<EquipeEducatif> listEquipeEducatif(); 
	public List<EquipeEducatif> equipeEducatifParNom(String nom); 
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction); 
	public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif); 
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif); 
	
	
	//Consulter Fonctions 
	public List<Fonction> listFonctions(); 
	public Fonction getFonction(Long idFonction); 
	
	
	
	//Consulter Accompagnateurs
    public Accompagnateur getAccompagnateur(Long idAccompagnateur); 
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur);
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur); 
	public List<Accompagnateur> listAccompagnateurs(); 
	public List<Accompagnateur> accompagnateurParNom(String nom); 
	
	
	
	//Consulter Genres
	public List<Genre> listGenre(); 
	public Genre getGenre(Long idGenre);
	
	
	//Consulter Annees
	public List<Annee> listAnnees(); 
	public Annee getAnnee(Long idAnnee); 
	public List<Annee> getAnneesByEnfantbyClasse(Long idEnfant,Long idClasse);
	public List<Enfant> getEnfantByClassebyAnnee(Long idClasse,Long idAnnee);
	public List<Classe> getClassesByEnfantbyAnnee(Long idEnfant,Long idAnnee);
	
	
	//Consulter Parents
	public Parent getParent(Long idParent); 
	public List<Enfant> getEnfantByParent(Long idParent);
	
	
	
    //Consulter Les Enfants
	
	public List<Enfant> listEnfants(); 
	public List<Enfant> enfantParNom(String nom);
	public Enfant getEnfant(Long idEnfant); 
	public List<Enfant> enfantCertife(); 
	public List<Enfant> enfantPhotoAutorise(); 
	public List<Enfant> enfantSituationParental(); 
	public List<Enfant> enfantInscriptionEvennement(); 
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant);
	public List<Evennement> getEvennementsByEnfant(Long idEnfant);
	public List<Tarif> gettarifbyEnfant(Long idEnfant);
	public List<Parent> getParentsByEnfant(Long idEnfant);
	public List<Enfant> getEnfantsByAnneeByClasse(Long idAnnee,Long idClasse);
	public List<Enfant> getEnfantsByConsultationByEquipeSanitaire(Long idConsultation,Long idEquipeSanitaire);
	public List<Classe> getClassesByAnneeByEnfant(Long idAnnee,Long idEnfant);
	public List<EquipeSanitaire> getEquipeSanitaireByConsultationByEnfant(Long idConsultation,Long idEnfant);
	public List<Annee> getAnneeByEnfantByClasse(Long idEnfant,Long idClasse);
	public List<Consultation> getConsultationByEnfantByEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
	
	
	
	//Consulter les Evennements
	
	public List<Evennement> listEvennements(); 
	public List<Evennement> evennementParNom(String nom); 
	public Evennement getEvennement(Long idEvennement);  
	public List<Enfant> getEnfantsByEvennement(Long idEvennement);
	
	
	
	//Consulter les Consultations
	public List<Consultation> listConsultations(); 
	public Consultation getConsultation(Long idConsultation); 
	public List<Consultation> getConsultationsByEnfantbyEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
	public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire,Long idConsultation);
	public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant,Long idConsultation);
	
	
	
	

}
