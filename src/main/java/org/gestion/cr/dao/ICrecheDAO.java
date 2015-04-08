package org.gestion.cr.dao;

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

public interface ICrecheDAO

{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	//Gestion des CategorieClubs 
	
	public Long ajouterCategorieClub(CategorieClub categorieClub); 
	public List<CategorieClub> categorieClubParNom(String nomCategorieClub); 
	public CategorieClub getCategorieClub(Long idCategorieClub); 
	public void supprimerCategorieClub(Long idCategorieClub); 
	public void modifierCategorieClub(CategorieClub categorieClub); 
	
	public long getNombreCategorieClubs();
	public List<CategorieClub> listCategorieClubs(); 
	public List<CategorieClub> listCategorieClubs(int position,int nbrCategorieClubs); 
	
	//Gestion des PlanningHorraires 
	
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires,Long idGenrePlanning); 
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires); 
	public void supprimerPlanningHorraires(Long idPlanningHorraires); 
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires); 
	public List<Inscription> getInscriptionByPlannigHorraires(Long idPlanningHorraires);
	public List<PlanningHorraires> PlanningHorraireslubParGenrePlanning(Long idGenrePlanning);
	public void ajouterInscriptionPourPlanningHorraires(Long idInscription,Long idPlanningHorraires);
	
	
	public long getNombrePlanningHorraires();
	public List<PlanningHorraires> listPlanningHorraires(); 
	public List<PlanningHorraires> listPlanningHorraires(int position,int nbrPlanningHorraires); 
	
	
	//Gestion des Clubs     
	
	public Long ajouterClubs(Clubs clubs,Long idInscription,Long idCtagorieClubs); 
	public List<Clubs> clubsParNom(String nomClubs); 
	public List<Clubs> clubsParInscription(Long idInscription); 
	public Clubs getClubs(Long idClubs);
	public void supprimerClubs(Long idClubs); 
	public void modifierClubs(Clubs clubs); 
	public List<Clubs> clubParcategorieClub(Long idCategorieClub);
	
	
	public long getNombreClubs();
	public List<Clubs> listClubs(); 
	public List<Clubs> listClubs(int position,int nbrClubs); 

	
	
	//Gestion des GenresPlanningHorraires
	
	public Long ajouterGenrePlanning(GenrePlanning genrePlanning); 
	public List<GenrePlanning> genrePlanningParLabelle(String labelle); 
    public GenrePlanning getGenrePlanning(Long idGenrePlanning);
	public void supprimerGenrePlanning(Long idGenrePlanning); 
	public void modifierGenrePlanning(GenrePlanning genrePlanning); 
	
	public long getNombreGenrePlanning();
	public List<GenrePlanning> listGenrePlanning(); 
	public List<GenrePlanning> listGenrePlanning(int position,int nbrGenrePlanning); 
	
	
	//gestion des Creches    
	
	public Long ajouterCreche(Creche creche); 
	public List<Creche> crecheParNom(String nomCreche);
	public Creche getCreche(Long idCreche); 
	public void supprimerCreche(Long idCreche); 
	public void modifierCreche(Creche creche); 
	
	public long getNombreCreches();
	public List<Creche> listCreches(); 
	public List<Creche> listCreches(int position,int nbrCreches); 
	
	//Gestion des Classes 
	
	public Long ajouterClasse(Classe classe,Long idCreche); 
	public List<Classe> classeParNom(String nom);  
	public List<Classe> classeParCreche(Long idCreche); 
	public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse);
	public Classe getClasse(Long idClasse); 
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
	
	public long getNombreClasses();
	public List<Classe> listClasse(); 
	public List<Classe> listClasse(int position,int nbrClasses); 
	

	
	//Gestion des Equipes Sanitaire
	
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction); 
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom);  
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction); 
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire); 
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
	
	
    public long getNombreEquipesSan();
    public List<EquipeSanitaire> listEquipeSanitaires(); 
    public List<EquipeSanitaire> listEquipeSanitaires(int position,int nbrEquipesSan); 
	
	
	
	//Gestion des Equipes Educatifs 
	
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction); 
	public List<EquipeEducatif> equipeEducatifParNom(String nom); 
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction); 
	public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif); 
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif); 
	public void supprimerEquipeEducatif(Long idEquipeEducatif); 
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);
	

	public long getNombreEquipesEdu();
	public List<EquipeEducatif> listEquipeEducatif();  
	public List<EquipeEducatif> listEquipeEducatif(int position,int nbrEquipesEdu); 
	
	//Gestion des Fonctions 
	
	public Long ajouterFonction(Fonction fonction); 
	
	public Fonction getFonction(Long idFonction); 
	public void supprimerFonction(Long idFonction); 
	public void modifierFonction(Fonction fonction); 
	
	public long getNombreFonctions();
	public List<Fonction> listFonctions();  
	public List<Fonction> listFonctions(int position,int nbrFonctions); 
	
	
	
	//Gestion des Accompagnateurs 
	
	
	
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur); 
    public List<Accompagnateur> accompagnateurParNom(String nom); 
	public Accompagnateur getAccompagnateur(Long idAccompagnateur); 
	public void supprimerAccompagnateurs(Long idAccompagnateur); 
	public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur);
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
	
	public long getNombreAccompagnateurs();
	public List<Accompagnateur> listAccompagnateurs(); 
	public List<Accompagnateur> listAccompagnateurs(int position,int nbrAccompagnateurs); 
	
	
	
	//Gestion des Equipes
	
	public Long ajouterEquipe(Equipe equipe); 
	public List<Equipe> equipeParNom(String nom); 
	public Equipe getEquipe(Long idEquipe); 
	public void supprimerEquipes(Long idEquipe); 
	public void modifierEquipes(Equipe equipe); 
	public List<Equipe> getMaterielByEquipe(Long idEquipe);
	public void ajouterMaterielPourEquipe(Long idMateriel,Long idEquipe);
		
	public long getNombreEquipes();
	public List<Equipe> listEquipes(); 
	public List<Equipe> listEquipes(int position,int nbrEquipes); 
	
	//Gestion des Personnages
	
	public Long ajouterPersonnage(Personnage personnage); 
	public Personnage getPersonnage(Long idPersonnage); 
	public void supprimerPersonnage(Long idPersonnage); 
	public void modifierPersonnages(Personnage personnage); 
	
			
	public long getNombrePersonnages();
	public List<Personnage> personnageParNom(String nom); 	
	public List<Personnage> listPersonnage(int position,int nbrPersonnage); 
	public List<Personnage> listPersonnage();
	

	
	//Gestion des Inscriptions 
	
	public Long ajouterInscription(Inscription inscription); 
	public Inscription getInscription(Long idInscription); 
	public void supprimerInscriptions(Long idInscription); 
	public void modifierInscriptions(Inscription inscription); 
	public List<Inscription> getInscriptionByEnfantbyClasse(Long idEnfant,Long idClasse);
	public List<Enfant> getEnfantByClassebyInscription(Long idClasse,Long idInscription);
	public List<Classe> getClassesByEnfantbyInscription(Long idEnfant,Long idInscription);
	public void ajouterInscriptionsPourEnfantPourClasse(Long idInscription,Long idEnfant,Long idclass);
	public void ajouterEnfantsPourInscriptionPourClasse(Long idEnfant,Long idInscription,Long idclass);
	public void ajouterClassesPourInscriptionPourEnfant(Long idclass,Long idInscription,Long idEnfant );
	public void ajouterPlanningHorrairsPourInscription(Long idPlanningHorraires,Long idInscription);
	
	public long getNombreInscriptions();
	public List<Inscription> listInscriptions(); 
	public List<Inscription> listInscriptions(int position,int nbrInscriptions); 
	
	
	
	
    //Gestion des Parents 
	
	public Long ajouterParent(Parent parent); 
	
	public List<Parent> parentParNom(String nomParent); 
	public Parent getParent(Long idParent); 
	public void supprimerParent(Long idParent); 
	public void modifierParent(Parent parent); 
	public List<Enfant> getEnfantByParent(Long idParent);
	public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
	
	public List<Parent> listParents(int position,int nbrParents); 
	public List<Parent> listParents(); 
    public long getNombreParents();
	
	
	
	
	//Gestion des Consultations
	
	public Long ajouterConsultation(Consultation consultation); 
	public Consultation getConsultation(Long idConsultation); 
	public void supprimerConsultations(Long idConsultation); 
	public void modifierConsultations(Consultation consultation); 
	public List<Consultation> getConsultationsByEnfantbyEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
	public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire,Long idConsultation);
	public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant,Long idConsultation);
	public void ajouterConsultationsPourEnfantPourEquipeSanitaire(Long idConsultation,Long idEnfant,Long idEquipeSanitaire);
	public void ajouterEnfantsPourConsultationPourEquipeSanitaire(Long idEnfant,Long idConsultation,Long idEquipeSanitaire);
	public void ajouterEquipeSanitairesPourConsultationPourEnfant(Long idEquipeSanitaire,Long idConsultation,Long idEnfant );
	
	
	public long getNombreConsultations();
	public List<Consultation> listConsultations(); 
	public List<Consultation> listConsultations(int position,int nbrConsultations); 
	
	//Gestion des Evennements
	
	public Long ajouterEvennement(Evennement evennement); 
	
	public List<Evennement> evennementParNom(String nom); 
	public Evennement getEvennement(Long idEvennement); 
	public void supprimerEvennements(Long idEvennement); 
	public void modifierEvennements(Evennement evennement); 
	public List<Enfant> getEnfantsByEvennement(Long idEvennement);
	public void ajouterEnfantsPourEvennement(Long idEnfant,Long idEvennement);
	
	
	public long getNombreEvennements();
	public List<Evennement> listEvennements();
	public List<Evennement> listEvennements(int position,int nbrEvennements); 
	
	//Gestion des Enfants 
	
	public Long ajouterEnfant(Enfant enfant); 
	
	public List<Enfant> enfantParNom(String nom); 
	public Enfant getEnfant(Long idEnfant); 
	public List<Enfant> enfantCertife(); 
	public List<Enfant> enfantPhotoAutorise(); 
	public List<Enfant> enfantSituationParental(); 
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant); 
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant);
	public List<Evennement> getEvennementsByEnfant(Long idEnfant);
	public List<Parent> getParentsByEnfant(Long idEnfant);
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterEvennementsPourEnfant(Long idEvennement,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
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
	
	public Long ajouterFournisseur(Fournisseur fournisseur); 
	
	public List<Fournisseur> fournisseurParNom(String nom); 
	public Fournisseur getFournisseur(Long idFournisseur); 
	public void supprimerFournisseur(Long idFournisseur); 
	public void modifierFournisseur(Fournisseur fournisseur); 
	public List<Materiels> getMaterielsByFournisseur(Long idFournisseur);
	public void ajouterMaterielsPourFournisseur(Long idMateriels,Long idFournisseur);
	
	
     public long getNombreFournisseurs();
     public List<Fournisseur> listFournisseurs(); 
     public List<Fournisseur> listFournisseurs(int position,int nbrFournisseurs); 
	
	//Gestion des Materiels
	
	public Long ajouterMateriels(Materiels materiels,Long idTypeMateriels,Long idStock); 
	public List<Materiels> materielsParDesignation(String designation); 
	public Materiels getMateriels(Long idMateriels); 
	public void supprimerMateriels(Long idMateriels); 
	public void modifierMateriels(Materiels materiels); 
	public List<Fournisseur> getFournisseurByMateriels(Long idMateriels);
	public List<Equipe> getEquipeByMateriels(Long idMateriels);
	public void ajouterFournisseurPourMateriels(Long idFournisseur,Long idMateriels);
	public void ajouterEquipePourMateriels(Long idEquipe,Long idMateriels);
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
	
	public Long ajouterTypeMateriel(TypeMateriels typeMateriels); 
    public List<TypeMateriels> typeMaterielsParLabelle(String labelle); 
	public TypeMateriels getTypeMateriels(Long idTypeMateriels);
	public void supprimerTypeMateriels(Long idTypeMateriels); 
	public void modifierTypeMateriels(TypeMateriels typeMateriels); 
	
	public long getNombreTypesMateriels();
	public List<TypeMateriels> listTypeMateriels(); 
	public List<TypeMateriels> listTypeMateriels(int position,int nbrTypesMateriels); 
	
	
	
	//Gestion des stocks materiels
	
	public Long ajouterStock(Stock stock); 
	public Stock getStock(Long idStock);
	public void supprimerStock(Long idStock); 
	public void modifierStock(Stock stock); 
	
	public long getNombreStocks();
	public List<Stock> listStock(); 
	public List<Stock> listStock(int position,int nbrStocks); 
	

}
