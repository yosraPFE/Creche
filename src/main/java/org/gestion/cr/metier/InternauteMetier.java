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

public interface InternauteMetier
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	
	   //Gestion des CategorieClubs 
	
		
		public List<CategorieClub> categorieClubParNom(String nomCategorieClub); 
		public CategorieClub getCategorieClub(Long idCategorieClub); 
		
		public long getNombreCategorieClubs();
		public List<CategorieClub> listCategorieClubs(); 
		public List<CategorieClub> listCategorieClubs(int position,int nbrCategorieClubs); 
		
		 
		
		//Gestion des PlanningHorraires 
		
	
		public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires); 
		public List<Inscription> getInscriptionByPlannigHorraires(Long idPlanningHorraires);
		public List<PlanningHorraires> PlanningHorraireslubParGenrePlanning(Long idGenrePlanning);
		
		public long getNombrePlanningHorraires();
		public List<PlanningHorraires> listPlanningHorraires(); 
		public List<PlanningHorraires> listPlanningHorraires(int position,int nbrPlanningHorraires); 
		
		//Gestion des Clubs     
		
	
		public List<Clubs> clubsParNom(String nomClubs); 
		public List<Clubs> clubsParInscription(Long idInscription); 
		public Clubs getClubs(Long idClubs);
		public List<Clubs> clubParcategorieClub(Long idCategorieClub);
		
		public long getNombreClubs();
		public List<Clubs> listClubs(); 
		public List<Clubs> listClubs(int position,int nbrClubs); 

		
		
		//Gestion des GenresPlanningHorraires
		
		 
		
		public List<GenrePlanning> genrePlanningParLabelle(String labelle); 
	    public GenrePlanning getGenrePlanning(Long idGenrePlanning);
		
	    
	    public long getNombreGenrePlanning();
		public List<GenrePlanning> listGenrePlanning(); 
		public List<GenrePlanning> listGenrePlanning(int position,int nbrGenrePlanning); 
		
		
		//gestion des Creches  
		
		
		public List<Creche> crecheParNom(String nomCreche);
		public Creche getCreche(Long idCreche); 
		
		public long getNombreCreches();
		public List<Creche> listCreches(); 
		public List<Creche> listCreches(int position,int nbrCreches); 
		
		
		//Gestion des Classes 
		
		public List<Classe> classeParNom(String nom);  
		public List<Classe> classeParCreche(Long idCreche); 
		public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse);
		public Classe getClasse(Long idClasse); 
		
		public long getNombreClasses();
		public List<Classe> listClasse(); 
		public List<Classe> listClasse(int position,int nbrClasses); 
		
		
		//Gestion des Equipes
		
		
		public List<Equipe> equipeParNom(String nom); 
		public Equipe getEquipe(Long idEquipe); 
		public List<Equipe> getMaterielByEquipe(Long idEquipe);
		
			
		public long getNombreEquipes();
		public List<Equipe> listEquipes(); 
		public List<Equipe> listEquipes(int position,int nbrEquipes); 
		
		
		//Gestion des Personnages
		
		
		public Personnage getPersonnage(Long idPersonnage); 
		public long getNombrePersonnages();
				
		public List<Personnage> personnageParNom(String nom); 	
		public List<Personnage> listPersonnage(int position,int nbrPersonnage); 
		public List<Personnage> listPersonnage();
		
		
		//Gestion des Equipes Sanitaire
		
		 
		
		public List<EquipeSanitaire> equipeSanitaireParNom(String nom);  
		public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction); 
		public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire); 
		
		public long getNombreEquipesSan();
		public List<EquipeSanitaire> listEquipeSanitaires(); 
	    public List<EquipeSanitaire> listEquipeSanitaires(int position,int nbrEquipesSan); 
		
		
		//Gestion des Equipes Educatifs 
		
		 
		
		public List<EquipeEducatif> equipeEducatifParNom(String nom); 
		public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction); 
		public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif); 
		public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif); 
		
		
		public long getNombreEquipesEdu();
		public List<EquipeEducatif> listEquipeEducatif();  
		public List<EquipeEducatif> listEquipeEducatif(int position,int nbrEquipesEdu); 
		
		
		//Gestion des Fonctions 
		
		
		public List<Fonction> listFonctions(); 
		public Fonction getFonction(Long idFonction); 
		
		public long getNombreFonctions();
		public List<Fonction> listFonctions(int position,int nbrFonctions); 
		 
		
		//Gestion des Accompagnateurs 
		
		 
		public List<Accompagnateur> listAccompagnateurs(int position,int nbrAccompagnateurs); 
		public List<Accompagnateur> accompagnateurParNom(String nom); 
		public Accompagnateur getAccompagnateur(Long idAccompagnateur); 
		public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur);
		
		
		public long getNombreAccompagnateurs();
		public List<Accompagnateur> listAccompagnateurs(); 
		
		
		
		
		//Gestion des Inscriptions 
		
		
		public Inscription getInscription(Long idInscription);  
		public List<Inscription> getInscriptionByEnfantbyClasse(Long idEnfant,Long idClasse);
		public List<Enfant> getEnfantByClassebyInscription(Long idClasse,Long idInscription);
		public List<Classe> getClassesByEnfantbyInscription(Long idEnfant,Long idInscription);
		
		public long getNombreInscriptions();
		public List<Inscription> listInscriptions(); 
		public List<Inscription> listInscriptions(int position,int nbrInscriptions); 
		
		
	    //Gestion des Parents 
		
		
		public List<Parent> listParents(); 
		public List<Parent> parentParNom(String nomParent); 
		public Parent getParent(Long idParent); 
		public List<Enfant> getEnfantByParent(Long idParent);
		
		 
	
	    public long getNombreParents();
		public List<Parent> listParents(int position,int nbrParents); 
		
		//Gestion des Consultations
		
		
		public Consultation getConsultation(Long idConsultation); 
		public List<Consultation> getConsultationsByEnfantbyEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
		public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire,Long idConsultation);
		public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant,Long idConsultation);
		
		
		public long getNombreConsultations();
		public List<Consultation> listConsultations(); 
		public List<Consultation> listConsultations(int position,int nbrConsultations); 
		
		
		//Gestion des Evennements
		
		
		
		public List<Evennement> evennementParNom(String nom); 
		public Evennement getEvennement(Long idEvennement); 
		public List<Enfant> getEnfantsByEvennement(Long idEvennement);
		
		public long getNombreEvennements();
		public List<Evennement> listEvennements();
		public List<Evennement> listEvennements(int position,int nbrEvennements); 
		
		
		//Gestion des Enfants 
		
		
		
		public List<Enfant> enfantParNom(String nom); 
		public Enfant getEnfant(Long idEnfant); 
		public List<Enfant> enfantCertife(); 
		public List<Enfant> enfantPhotoAutorise(); 
		public List<Enfant> enfantSituationParental(); 
		public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant);
		public List<Evennement> getEvennementsByEnfant(Long idEnfant);
		public List<Parent> getParentsByEnfant(Long idEnfant);
		public List<Enfant> getEnfantsByInscriptionByClasse(Long idInscription,Long idClasse);
		public List<Enfant> getEnfantsByConsultationByEquipeSanitaire(Long idConsultation,Long idEquipeSanitaire);
		public List<Classe> getClassesByInscriptionByEnfant(Long idInscription,Long idEnfant);
		public List<EquipeSanitaire> getEquipeSanitaireByConsultationByEnfant(Long idConsultation,Long idEnfant);
		public List<Inscription> getInscriptionByEnfantByClasse(Long idEnfant,Long idClasse);
		public List<Consultation> getConsultationByEnfantByEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
		public Enfant enregistrerEnfant(Inscription a,Parent p);
		
		
		
		public List<Enfant> listEnfants(int position,int nbrEnfants); 
		public List<Enfant> listEnfants();  
	    public long getNombreEnfants();
		
		//Gestion des Fournisseurs
		
		 
		
		public List<Fournisseur> fournisseurParNom(String nom); 
		public Fournisseur getFournisseur(Long idFournisseur); 
		public List<Materiels> getMaterielsByFournisseur(Long idFournisseur);
		
		public long getNombreFournisseurs();
		public List<Fournisseur> listFournisseurs(); 
	    public List<Fournisseur> listFournisseurs(int position,int nbrFournisseurs); 
		
		
		
		//Gestion des Materiels
		
	
		public List<Materiels> materielsParDesignation(String designation); 
		public Materiels getMateriels(Long idMateriels);  
		public List<Fournisseur> getFournisseurByMateriels(Long idMateriels);
		public List<Equipe> getEquipeByMateriels(Long idMateriels);
		public List<Materiels> materielsParFournisseur(Long idFournisseur);
		public List<Materiels> materielsParEquipe(Long idEquipe);
		public List<EquipeSanitaire> materielsParEquipeSanitaire(Long idEquipeSanitaire);
		public List<EquipeEducatif> materielsParEquipeEducatif(Long idEquipeEducatif);
		public List<Equipe> getEquipeEducatifByMateriels(Long idMateriels);
		public List<Equipe> getEquipeSanitaireByMateriels(Long idMateriels);
		
		public long getNombreMateriels();
		public List<Materiels> listMateriels();  
		public List<Materiels> listMateriels(int position,int nbrMateriels);
		
		
		//Gestion des typesMateriels
		
		 
		
		public List<TypeMateriels> typeMaterielsParLabelle(String labelle); 
		public TypeMateriels getTypeMateriels(Long idTypeMateriels);
		
		public long getNombreTypesMateriels();
		public List<TypeMateriels> listTypeMateriels(); 
		public List<TypeMateriels> listTypeMateriels(int position,int nbrTypesMateriels); 
		
		
		//Gestion des stocks materiels
		
		
		
		public Stock getStock(Long idStock);
		
		public long getNombreStocks();
		public List<Stock> listStock(); 
		public List<Stock> listStock(int position,int nbrStocks); 
		


}
