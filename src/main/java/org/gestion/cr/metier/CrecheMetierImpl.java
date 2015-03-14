package org.gestion.cr.metier;

import java.util.List;





import org.gestion.cr.dao.ICrecheDAO;
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
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class CrecheMetierImpl implements IAdminMetier

{
	private ICrecheDAO dao;
	
	
	public void setDao(ICrecheDAO dao) 
	{
		this.dao = dao;
	}

	@Override
	public List<CategorieClub> listCategorieClubs() 
	{
		
		return dao.listCategorieClubs();
	}

	@Override
	public List<CategorieClub> categorieClubParNom(String nomCategorieClub)
{
		
		return dao.categorieClubParNom(nomCategorieClub);
	}

	@Override
	public List<CategorieClub> categorieClubParClub(Long idClub) 
	{
		
		return dao.categorieClubParClub(idClub);
	}

	@Override
	public CategorieClub getCategorieClub(Long idCategorieClub) 
	{
		
		return dao.getCategorieClub(idCategorieClub);
	}

	@Override
	public List<PlanningHorraires> listPlanningHorraires() 
	{
	
		return dao.listPlanningHorraires();
	}

	@Override
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires) 
	{
		
		return dao.getPlanningHorraires(idPlanningHorraires);
	}

	@Override
	public List<Tarif> listTarifs()
	{
		
		return dao.listTarifs();
	}

	@Override
	public List<Tarif> tarifParPlanningHorraires(Long idPlanningHorraires) 
	{
		
		return dao.tarifParPlanningHorraires(idPlanningHorraires);
	}

	@Override
	public List<Enfant> getenfantbyTarif(Long idTarif) 
	{
		
		return dao.getenfantbyTarif(idTarif);
	}

	@Override
	public Tarif getTarif(Long idTarif) 
	{
		
		return dao.getTarif(idTarif);
	}

	@Override
	public List<Menus> listMenus() 
	{
		
		return dao.listMenus();
	}

	@Override
	public List<Menus> menusParNom(String nomMenus)
	{
		
		return dao.menusParNom(nomMenus);
	}

	@Override
	public List<Menus> menusParTarif(Long idTarif) 
	{
		
		return dao.menusParTarif(idTarif);
	}

	@Override
	public Menus getMenus(Long idMenus)
	{
		
		return dao.getMenus(idMenus);
	}

	@Override
	public List<Clubs> listClubs() 
	{
		
		return dao.listClubs();
	}

	@Override
	public List<Clubs> clubsParNom(String nomClubs) 
	{
		
		return dao.clubsParNom(nomClubs);
	}

	@Override
	public List<Clubs> clubsParTarif(Long idTarif) 
	{
		
		return dao.clubsParTarif(idTarif);
	}

	@Override
	public Clubs getClubs(Long idClubs) 
	{
		
		return dao.getClubs(idClubs);
	}

	@Override
	public List<NomClass> listNomClass()
	{
		
		return dao.listNomClass();
	}

	@Override
	public NomClass getNomClass(Long idNomClass)
	{
		
		return dao.getNomClass(idNomClass);
	}

	@Override
	public List<Creche> listCreches()
	{
		
		return dao.listCreches();
	}

	@Override
	public List<Creche> crecheParNom(String nomCreche) 
	{
		
		return dao.crecheParNom(nomCreche);
	}

	@Override
	public Creche getCreche(Long idCreche)
	{
		
		return dao.getCreche(idCreche);
	}

	@Override
	public List<Classe> listClasse()
	{
		
		return dao.listClasse();
	}

	@Override
	public List<Classe> classeParNom(String nomClasse)
	{
		
		return dao.classeParNom(nomClasse);
	}

	@Override
	public List<Classe> classeParCreche(Long idCreche) 
	{
		
		return dao.classeParCreche(idCreche);
	}

	@Override
	public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse) 
	{
		
		return dao.getEquipeEducatifByClasse(idClasse);
	}

	@Override
	public Classe getClasse(Long idClasse)
	{
		
		return dao.getClasse(idClasse);
	}

	@Override
	public List<EquipeTechnique> listEquipeTechniques() 
	{
		
		return dao.listEquipeTechniques();
	}

	@Override
	public List<EquipeTechnique> equipeTechniqueParNom(String nom) 
	{
		
		return dao.equipeTechniqueParNom(nom);
	}

	@Override
	public List<EquipeTechnique> equipeTechniqueParCreche(Long idCreche)
	{
		
		return dao.equipeTechniqueParCreche(idCreche);
	}

	@Override
	public List<EquipeTechnique> equipeTechniqueParFonction(Long idFonction) 
	{
		
		return dao.equipeTechniqueParFonction(idFonction);
	}

	@Override
	public EquipeTechnique getEquipeTechnique(Long idEquipeTechnique) 
	{
		
		return dao.getEquipeTechnique(idEquipeTechnique);
	}

	@Override
	public List<EquipeSanitaire> listEquipeSanitaires() 
	{
		
		return dao.listEquipeSanitaires();
	}

	@Override
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom) 
	{
		
		return dao.equipeSanitaireParNom(nom);
	}

	@Override
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction)
	{
		
		return dao.equipeSanitaireParFonction(idFonction);
	}

	@Override
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire) 
	{
		
		return dao.getEquipeSanitaire(idEquipeSanitaire);
	}

	@Override
	public List<EquipeEducatif> listEquipeEducatif()
	{
		
		return dao.listEquipeEducatif();
	}

	@Override
	public List<EquipeEducatif> equipeEducatifParNom(String nom)
	{
		
		return dao.equipeEducatifParNom(nom);
	}

	@Override
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction) 
	{
		
		return dao.equipeEducatifParFonction(idFonction);
	}

	@Override
	public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif) 
	{
		
		return dao.getClassesByEquipeEducatif(idEquipeEducatif);
	}

	@Override
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif) 
	{
		
		return dao.getEquipeEducatif(idEquipeEducatif);
	}

	@Override
	public List<Fonction> listFonctions()
	{
		
		return dao.listFonctions();
	}

	@Override
	public Fonction getFonction(Long idFonction) 
	{
		
		return dao.getFonction(idFonction);
	}

	@Override
	public Accompagnateur getAccompagnateur(Long idAccompagnateur) 
	{
		
		return dao.getAccompagnateur(idAccompagnateur);
	}

	@Override
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur) 
	{
		
		return dao.getEnfantsByAccompagnateur(idAccompagnateur);
	}

	@Override
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur)
	{
		
		return dao.ajouterAccompagnateur(accompagnateur);
	}

	@Override
	public List<Accompagnateur> listAccompagnateurs()
	{
		
		return dao.listAccompagnateurs();
	}

	@Override
	public List<Accompagnateur> accompagnateurParNom(String nom) 
	{
		
		return dao.accompagnateurParNom(nom);
	}

	@Override
	public List<Genre> listGenre() 
	{
		
		return dao.listGenre();
	}

	@Override
	public Genre getGenre(Long idGenre) 
	{
		
		return dao.getGenre(idGenre);
	}

	@Override
	public List<Annee> listAnnees() 
	{
		
		return dao.listAnnees();
	}

	@Override
	public Annee getAnnee(Long idAnnee)
	{
		
		return dao.getAnnee(idAnnee);
	}

	@Override
	public List<Annee> getAnneesByEnfantbyClasse(Long idEnfant, Long idClasse) 
	{
		
		return dao.getAnneeByEnfantByClasse(idEnfant, idClasse);
	}

	@Override
	public List<Enfant> getEnfantByClassebyAnnee(Long idClasse, Long idAnnee)
	{
		
		return dao.getEnfantByClassebyAnnee(idClasse, idAnnee);
	}

	@Override
	public List<Classe> getClassesByEnfantbyAnnee(Long idEnfant, Long idAnnee)
    {
		
		return dao.getClassesByEnfantbyAnnee(idEnfant, idAnnee);
	}

	@Override
	public Parent getParent(Long idParent)
	{
		
		return dao.getParent(idParent);
	}

	@Override
	public List<Enfant> getEnfantByParent(Long idParent) 
	{
		
		return dao.getEnfantByParent(idParent);
	}

	@Override
	public List<Enfant> listEnfants() 
	{
		
		return dao.listEnfants();
	}

	@Override
	public List<Enfant> enfantParNom(String nom)
	{
		
		return dao.enfantParNom(nom);
	}

	@Override
	public Enfant getEnfant(Long idEnfant) 
	{
		
		return dao.getEnfant(idEnfant);
	}

	@Override
	public List<Enfant> enfantCertife()
	{
		
		return dao.enfantCertife();
	}

	@Override
	public List<Enfant> enfantPhotoAutorise() 
	{
		
		return dao.enfantPhotoAutorise();
	}

	@Override
	public List<Enfant> enfantSituationParental() 
	{
		
		return dao.enfantSituationParental();
	}

	@Override
	public List<Enfant> enfantInscriptionEvennement() 
	{
		
		return dao.enfantInscriptionEvennement();
	}

	@Override
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant)
	{
		
		return dao.getAccompagnateursByEnfant(idEnfant);
	}

	@Override
	public List<Evennement> getEvennementsByEnfant(Long idEnfant) 
	{
		
		return dao.getEvennementsByEnfant(idEnfant);
	}

	@Override
	public List<Tarif> gettarifbyEnfant(Long idEnfant) 
	{
		
		return dao.gettarifbyEnfant(idEnfant);
	}

	@Override
	public List<Parent> getParentsByEnfant(Long idEnfant) 
	{
		
		return dao.getParentsByEnfant(idEnfant);
	}

	@Override
	public List<Enfant> getEnfantsByAnneeByClasse(Long idAnnee, Long idClasse) 
	{
		
		return dao.getEnfantsByAnneeByClasse(idAnnee, idClasse);
	}

	@Override
	public List<Enfant> getEnfantsByConsultationByEquipeSanitaire(Long idConsultation, Long idEquipeSanitaire) 
			
	{
		
		return dao.getEnfantsByConsultationByEquipeSanitaire(idConsultation, idEquipeSanitaire);
	}

	@Override
	public List<Classe> getClassesByAnneeByEnfant(Long idAnnee, Long idEnfant)
	{
		
		return dao.getClassesByAnneeByEnfant(idAnnee, idEnfant);
	}

	@Override
	public List<EquipeSanitaire> getEquipeSanitaireByConsultationByEnfant(Long idConsultation, Long idEnfant) 
	{
		
		return dao.getEquipeSanitaireByConsultationByEnfant(idConsultation, idEnfant);
	}

	@Override
	public List<Annee> getAnneeByEnfantByClasse(Long idEnfant, Long idClasse)
	{
		
		return dao.getAnneeByEnfantByClasse(idEnfant, idClasse);
	}

	@Override
	public List<Consultation> getConsultationByEnfantByEquipeSanitaire(Long idEnfant, Long idEquipeSanitaire) 
	{
		
		return dao.getConsultationByEnfantByEquipeSanitaire(idEnfant, idEquipeSanitaire);
	}

	@Override
	public List<Evennement> listEvennements()
	{
		
		return dao.listEvennements();
	}

	@Override
	public List<Evennement> evennementParNom(String nom) 
	{
		
		return dao.evennementParNom(nom);
	}

	@Override
	public Evennement getEvennement(Long idEvennement) 
	{
		
		return dao.getEvennement(idEvennement);
	}

	@Override
	public List<Enfant> getEnfantsByEvennement(Long idEvennement) 
	{
		
		return dao.getEnfantsByEvennement(idEvennement);
	}

	@Override
	public List<Consultation> listConsultations()
	{
		
		return dao.listConsultations();
	}

	@Override
	public Consultation getConsultation(Long idConsultation)
	{
		
		return dao.getConsultation(idConsultation);
	}

	@Override
	public List<Consultation> getConsultationsByEnfantbyEquipeSanitaire(Long idEnfant, Long idEquipeSanitaire)
	{
		
		return dao.getConsultationByEnfantByEquipeSanitaire(idEnfant, idEquipeSanitaire);
	}

	@Override
	public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire, Long idConsultation)
	{
		
		return dao.getEnfantByEqSanitaireyConsultation(idEquipeSanitaire, idConsultation);
	}

	@Override
	public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant, Long idConsultation) 
	{
		
		return dao.getEquipeSanitairesByEnfantbyConsultation(idEnfant, idConsultation);
	}

	@Override
	public Long ajouterCategorieClub(CategorieClub categorieClub, Long idClub) 
	{
		
		return dao.ajouterCategorieClub(categorieClub, idClub);
	}

	@Override
	public void supprimerCategorieClub(Long idCategorieClub)
	{
	
		dao.supprimerCategorieClub(idCategorieClub);
	}

	@Override
	public void modifierCategorieClub(CategorieClub categorieClub) 
	{
		dao.modifierCategorieClub(categorieClub);
		
	}

	@Override
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires) 
	{
		
		return dao.ajouterPlanningHorraires(planningHorraires);
	}

	@Override
	public void supprimerPlanningHorraires(Long idPlanningHorraires) 
	{
		
		dao.supprimerPlanningHorraires(idPlanningHorraires);
	}

	@Override
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires) 
	{
		dao.modifierPlanningHorraires(planningHorraires);
		
	}

	@Override
	public Long ajouterTarif(Tarif tarif, Long idPlanningHorraires,Long idEnfant) 
	{
		
		return dao.ajouterTarif(tarif, idPlanningHorraires,idEnfant);
	}

	@Override
	public void supprimerTarif(Long idTarif) 
	{
		dao.supprimerTarif(idTarif);
		
	}

	@Override
	public void modifierTarif(Tarif tarif) 
	{
		dao.modifierTarif(tarif);
		
	}

	@Override
	public Long ajouterMenus(Menus menus, Long idTarif)
	{
		
		return dao.ajouterMenus(menus, idTarif);
	}

	@Override
	public void supprimerMenus(Long idMenus)
	{
		dao.supprimerMenus(idMenus);
		
	}

	@Override
	public void modifierMenus(Menus menus) 
	{
		dao.modifierMenus(menus);
		
	}

	@Override
	public Long ajouterClubs(Clubs clubs, Long idTarif)
	{
		
		return dao.ajouterClubs(clubs, idTarif);
	}

	@Override
	public void supprimerClubs(Long idClubs)
	{
		dao.supprimerClubs(idClubs);
		
	}

	@Override
	public void modifierClubs(Clubs clubs)
	{
		dao.modifierClubs(clubs);
		
	}

	@Override
	public Long ajouterNomClass(NomClass nomClass) 
	{
		
		return dao.ajouterNomClass(nomClass);
	}

	@Override
	public void supprimerNomClass(Long idNomClass) 
	{
		dao.supprimerNomClass(idNomClass);
		
	}

	@Override
	public void modifierNomClass(NomClass nomClass)
	{
		dao.modifierNomClass(nomClass);
		
	}

	@Override
	public Long ajouterCreche(Creche creche)
	{
		
		return dao.ajouterCreche(creche);
	}

	@Override
	public void supprimerCreche(Long idCreche)
	{
		
		dao.supprimerCreche(idCreche);
	}

	@Override
	public void modifierCreche(Creche creche) 
	{
		
		dao.modifierCreche(creche);
		
	}

	@Override
	public Long ajouterClasse(Classe classe, Long idCreche, Long idNomClass)
	{
		
		return dao.ajouterClasse(classe, idCreche, idNomClass);
	}

	@Override
	public void supprimerClasse(Long idClasse)
	{
		dao.supprimerClasse(idClasse);
		
	}

	@Override
	public void modifierClasse(Classe classe) 
	{
		dao.modifierClasse(classe);
		
	}

	@Override
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse)
	{
		dao.ajouterEquipeEducatifPourClasse(idEquipeEducatif, idClasse);
		
	}

	@Override
	public Long ajouterEquipeTechnique(EquipeTechnique equipeTechnique,Long idCreche, Long idFonction)
	{
		
		return dao.ajouterEquipeTechnique(equipeTechnique, idCreche, idFonction);
	}

	@Override
	public void supprimerEquipeTechnique(Long idEquipeTechnique)
	{
		dao.supprimerEquipeTechnique(idEquipeTechnique);
		
	}

	@Override
	public void modifierEquipeTechnique(EquipeTechnique equipeTechnique)
	{
		dao.modifierEquipeTechnique(equipeTechnique);
		
	}

	@Override
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction)
	{
		
		return dao.ajouterEquipeSanitaire(equipeSanitaire, idFonction);
	}

	@Override
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire) 
	{
		dao.supprimerEquipeSanitaire(idEquipeSanitaire);
		
	}

	@Override
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire)
	{
		dao.modifierEquipeSanitaire(equipeSanitaire);
		
	}

	

	@Override
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction) 
	{
	
		return dao.ajouterEquipeEducatif(equipeEducatif, idFonction);
	}

	@Override
	public void supprimerEquipeEducatif(Long idEquipeEducatif) 
	{
		dao.supprimerEquipeEducatif(idEquipeEducatif);
		
	}

	@Override
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif) 
	{
		dao.modifierEquipeEducatif(equipeEducatif);
		
	}

	@Override
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif) 
	{
		dao.ajouterClassesPourEquipeEducatifs(idClasse, idEquipeEducatif);
		
	}

	@Override
	public Long ajouterFonction(Fonction fonction) 
	{
		
		return dao.ajouterFonction(fonction);
	}

	@Override
	public void supprimerFonction(Long idFonction) 
	{
		
		dao.supprimerFonction(idFonction);
	}

	@Override
	public void modifierFonction(Fonction fonction) 
	{
		
		dao.modifierFonction(fonction);
	}

	@Override
	public void supprimerAccompagnateurs(Long idAccompagnateur) 
	{
		dao.supprimerAccompagnateurs(idAccompagnateur);
		
	}

	@Override
	public void modifierAccompagnateurs(Accompagnateur accompagnateur) 
	{
		dao.modifierAccompagnateurs(accompagnateur);
		
	}

	@Override
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur)
	{
		dao.ajouterEnfantsPourAccompagnateur(idEnfant, idAccompagnateur);
		
	}

	@Override
	public Long ajouterGenre(Genre genre) 
	{
		
		return dao.ajouterGenre(genre);
	}

	@Override
	public void supprimerGenre(Long idGenre) 
	{
		dao.supprimerGenre(idGenre);
		
	}

	@Override
	public void modifierGenre(Genre genre)
	{
		dao.modifierGenre(genre);
		
	}

	@Override
	public Long ajouterAnnee(Annee annee) 
	{
		
		return dao.ajouterAnnee(annee);
	}

	@Override
	public void supprimerAnnees(Long idAnnee) 
	{
		dao.supprimerAnnees(idAnnee);
		
	}

	@Override
	public void modifierAnnees(Annee annee) 
	{
		dao.modifierAnnees(annee);
		
	}

	@Override
	public void ajouterAnneesPourEnfantPourClasse(Long idAnnee, Long idEnfant,Long idclass) 
	{
		dao.ajouterAnneesPourEnfantPourClasse(idAnnee, idEnfant, idclass);
		
	}

	@Override
	public void ajouterEnfantsPourAnneePourClasse(Long idEnfant, Long idAnnee,Long idclass) 
	{
		dao.ajouterEnfantsPourAnneePourClasse(idEnfant, idAnnee, idclass);
		
	}

	@Override
	public void ajouterClassesPourAnneePourEnfant(Long idclass, Long idAnnee,Long idEnfant) 
	{
		dao.ajouterClassesPourAnneePourEnfant(idclass, idAnnee, idEnfant);
		
	}

	@Override
	public Long ajouterParent(Parent parent, Long idGenre) 
	{
		
		return dao.ajouterParent(parent, idGenre);
	}

	@Override
	public List<Parent> listParents() 
	{
		
		return dao.listParents();
	}

	@Override
	public List<Parent> parentParNom(String nomParent) 
	{
		
		return dao.parentParNom(nomParent);
	}

	@Override
	public List<Parent> parentParGenre(Long idGenre)
	{
		
		return dao.parentParGenre(idGenre);
	}

	@Override
	public void supprimerParent(Long idParent)
	{
		dao.supprimerParent(idParent);
		
	}

	@Override
	public void modifierParent(Parent parent)
	{
		dao.modifierParent(parent);
		
	}

	@Override
	public void ajouterEnfantsPourParent(Long idEnfant, Long idParent) 
	{
		
		dao.ajouterEnfantsPourParent(idEnfant, idParent);
	}

	@Override
	public Long ajouterEnfant(Enfant enfant)
	{
		
		return dao.ajouterEnfant(enfant);
	}

	@Override
	public void supprimerEnfant(Long idEnfant)
	{
		dao.supprimerEnfant(idEnfant);
		
	}

	@Override
	public void modifierEnfant(Enfant enfant) 
	{
		dao.modifierEnfant(enfant);
		
	}

	@Override
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant)
	{
		dao.ajouterAccompagnateursPourEnfant(idAccompagnateur, idEnfant);
		
	}

	@Override
	public void ajouterEvennementsPourEnfant(Long idEvennement, Long idEnfant)
	{
		
		dao.ajouterEvennementsPourEnfant(idEvennement, idEnfant);
	}

	@Override
	public void ajouterParentsPourEnfant(Long idParent, Long idEnfant) 
	{
		dao.ajouterParentsPourEnfant(idParent, idEnfant);
		
	}

	@Override
	public Enfant enregistrerEnfant(Annee a, Parent p)
	{
		
		
		return dao.enregistrerEnfant(a, p);
	}

	@Override
	public Long ajouterConsultation(Consultation consultation) 
	{
		
		return dao.ajouterConsultation(consultation);
	}

	@Override
	public void modifierConsultations(Consultation consultation)
	{
		
		dao.modifierConsultations(consultation);
	}

	@Override
	public void ajouterConsultationsPourEnfantPourEquipeSanitaire(Long idConsultation, Long idEnfant, Long idEquipeSanitaire) 
	{
		dao.ajouterConsultationsPourEnfantPourEquipeSanitaire(idConsultation, idEnfant, idEquipeSanitaire);
		
	}

	@Override
	public void ajouterEnfantsPourConsultationPourEquipeSanitaire(Long idEnfant, Long idConsultation, Long idEquipeSanitaire) 
	{
		
		dao.ajouterEnfantsPourConsultationPourEquipeSanitaire(idEnfant, idConsultation, idEquipeSanitaire);
	}

	@Override
	public void ajouterEquipeSanitairesPourConsultationPourEnfant(Long idEquipeSanitaire, Long idConsultation, Long idEnfant)
	{
		dao.ajouterEquipeSanitairesPourConsultationPourEnfant(idEquipeSanitaire, idConsultation, idEnfant);
		
	}

	@Override
	public Long ajouterEvennement(Evennement evennement)
	{
		
		return dao.ajouterEvennement(evennement);
	}

	@Override
	public void supprimerEvennements(Long idEvennement) 
	{
	    dao.supprimerEvennements(idEvennement);
		
	}

	@Override
	public void modifierEvennements(Evennement evennement)
	{
		dao.modifierEvennements(evennement);
		
	}

	@Override
	public void ajouterEnfantsPourEvennement(Long idEnfant, Long idEvennement) 
	{
		dao.ajouterEnfantsPourEvennement(idEnfant, idEvennement);
		
	}
	

}
