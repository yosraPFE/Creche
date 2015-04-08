package org.gestion.cr.metier;

import java.util.List;
import org.gestion.cr.dao.ICrecheDAO;
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
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class CrecheMetierImpl implements IAdminMetier

{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
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
	public CategorieClub getCategorieClub(Long idCategorieClub) {
	
		return dao.getCategorieClub(idCategorieClub);
	}


	@Override
	public List<PlanningHorraires> listPlanningHorraires() {
		
		return dao.listPlanningHorraires();
	}


	@Override
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires) {
		
		return dao.getPlanningHorraires(idPlanningHorraires);
	}


	@Override
	public List<Inscription> getInscriptionByPlannigHorraires(
			Long idPlanningHorraires) {
		
		return dao.getInscriptionByPlannigHorraires(idPlanningHorraires);
	}


	@Override
	public List<PlanningHorraires> PlanningHorraireslubParGenrePlanning(
			Long idGenrePlanning) {
		
		return dao.PlanningHorraireslubParGenrePlanning(idGenrePlanning);
	}


	@Override
	public List<Clubs> listClubs() {
		
		return dao.listClubs();
	}


	@Override
	public List<Clubs> clubsParNom(String nomClubs) {
		
		return dao.clubsParNom(nomClubs);
	}


	@Override
	public List<Clubs> clubsParInscription(Long idInscription) {
		
		return dao.clubsParInscription(idInscription);
	}


	@Override
	public Clubs getClubs(Long idClubs) {
		
		return dao.getClubs(idClubs);
	}


	@Override
	public List<GenrePlanning> listGenrePlanning() {
		
		return dao.listGenrePlanning();
	}


	@Override
	public List<GenrePlanning> genrePlanningParLabelle(String labelle) {
		
		return dao.genrePlanningParLabelle(labelle);
	}


	@Override
	public GenrePlanning getGenrePlanning(Long idGenrePlanning) {
		
		return dao.getGenrePlanning(idGenrePlanning);
	}


	@Override
	public List<Creche> listCreches() {
		
		return dao.listCreches();
	}


	@Override
	public List<Creche> crecheParNom(String nomCreche) {
		
		return dao.crecheParNom(nomCreche);
	}


	@Override
	public Creche getCreche(Long idCreche) {
		
		return dao.getCreche(idCreche);
	}


	@Override
	public List<Classe> listClasse() {
		
		return dao.listClasse();
	}


	@Override
	public List<Classe> classeParNom(String nom) {
		
		return dao.classeParNom(nom);
	}


	@Override
	public List<Classe> classeParCreche(Long idCreche) {
		
		return dao.classeParCreche(idCreche);
	}


	@Override
	public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse) {
		
		return dao.getEquipeEducatifByClasse(idClasse);
	}


	@Override
	public Classe getClasse(Long idClasse) {
		
		return dao.getClasse(idClasse);
	}


	@Override
	public List<EquipeSanitaire> listEquipeSanitaires() {
		
		return dao.listEquipeSanitaires();
	}


	@Override
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom) {
		
		return dao.equipeSanitaireParNom(nom);
	}


	@Override
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction) {
		
		return dao.equipeSanitaireParFonction(idFonction);
	}


	@Override
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire) {
		
		return dao.getEquipeSanitaire(idEquipeSanitaire);
	}


	@Override
	public List<EquipeEducatif> listEquipeEducatif() {
		
		return dao.listEquipeEducatif();
	}


	@Override
	public List<EquipeEducatif> equipeEducatifParNom(String nom) {
		
		return dao.equipeEducatifParNom(nom);
	}


	@Override
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction) {
		
		return dao.equipeEducatifParFonction(idFonction);
	}


	@Override
	public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif) {
	
		return dao.getClassesByEquipeEducatif(idEquipeEducatif);
	}


	@Override
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif) {
		
		return dao.getEquipeEducatif(idEquipeEducatif);
	}


	@Override
	public List<Fonction> listFonctions() {
		
		return dao.listFonctions();
	}


	@Override
	public Fonction getFonction(Long idFonction) {
		
		return dao.getFonction(idFonction);
	}


	@Override
	public List<Accompagnateur> listAccompagnateurs(int position,
			int nbrAccompagnateurs) {
		
		return dao.listAccompagnateurs(position, nbrAccompagnateurs);
	}


	@Override
	public List<Accompagnateur> accompagnateurParNom(String nom) {
		
		return dao.accompagnateurParNom(nom);
	}


	@Override
	public Accompagnateur getAccompagnateur(Long idAccompagnateur) {
	
		return dao.getAccompagnateur(idAccompagnateur);
	}


	@Override
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur) {
		
		return dao.getEnfantsByAccompagnateur(idAccompagnateur);
	}


	@Override
	public long getNombreAccompagnateurs() {
		
		return dao.getNombreAccompagnateurs();
	}


	@Override
	public List<Accompagnateur> listAccompagnateurs() {
		
		return dao.listAccompagnateurs();
	}


	@Override
	public List<Inscription> listInscriptions() {
		
		return dao.listInscriptions();
	}


	@Override
	public Inscription getInscription(Long idInscription) {
	
		return dao.getInscription(idInscription);
	}


	@Override
	public List<Inscription> getInscriptionByEnfantbyClasse(Long idEnfant,
			Long idClasse) {
		
		return dao.getInscriptionByEnfantbyClasse(idEnfant, idClasse);
	}


	@Override
	public List<Enfant> getEnfantByClassebyInscription(Long idClasse,
			Long idInscription) {
		
		return dao.getEnfantByClassebyInscription(idClasse, idInscription);
	}


	@Override
	public List<Classe> getClassesByEnfantbyInscription(Long idEnfant,
			Long idInscription) {
		
		return dao.getClassesByEnfantbyInscription(idEnfant, idInscription);
	}


	@Override
	public List<Parent> listParents() {
		
		return dao.listParents();
	}


	@Override
	public List<Parent> parentParNom(String nomParent) {
		
		return dao.parentParNom(nomParent);
	}


	@Override
	public Parent getParent(Long idParent) {
	
		return dao.getParent(idParent);
	}


	@Override
	public List<Enfant> getEnfantByParent(Long idParent) {
		
		return dao.getEnfantByParent(idParent);
	}


	@Override
	public List<Consultation> listConsultations() {
	
		return dao.listConsultations();
	}


	@Override
	public Consultation getConsultation(Long idConsultation) {
		
		return dao.getConsultation(idConsultation);
	}


	@Override
	public List<Consultation> getConsultationsByEnfantbyEquipeSanitaire(
			Long idEnfant, Long idEquipeSanitaire) {
		
		return dao.getConsultationByEnfantByEquipeSanitaire(idEnfant, idEquipeSanitaire);
	}


	@Override
	public List<Enfant> getEnfantByEqSanitaireyConsultation(
			Long idEquipeSanitaire, Long idConsultation) {
		
		return dao.getEnfantByEqSanitaireyConsultation(idEquipeSanitaire, idConsultation);
	}


	@Override
	public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(
			Long idEnfant, Long idConsultation) {
		
		return dao.getEquipeSanitairesByEnfantbyConsultation(idEnfant, idConsultation);
	}


	@Override
	public List<Evennement> listEvennements() {
		
		return dao.listEvennements();
	}


	@Override
	public List<Evennement> evennementParNom(String nom) {
		
		return dao.evennementParNom(nom);
	}


	@Override
	public Evennement getEvennement(Long idEvennement) {
		
		return dao.getEvennement(idEvennement);
	}


	@Override
	public List<Enfant> getEnfantsByEvennement(Long idEvennement) {
		
		return dao.getEnfantsByEvennement(idEvennement);
	}


	@Override
	public List<Enfant> listEnfants() {
		
		return dao.listEnfants();
	}


	@Override
	public List<Enfant> enfantParNom(String nom) {
		
		return dao.enfantParNom(nom);
	}


	@Override
	public Enfant getEnfant(Long idEnfant) {
		
		return dao.getEnfant(idEnfant);
	}


	@Override
	public List<Enfant> enfantCertife() {
		
		return dao.enfantCertife();
	}


	@Override
	public List<Enfant> enfantPhotoAutorise() {
		
		return dao.enfantPhotoAutorise();
	}


	@Override
	public List<Enfant> enfantSituationParental() {
		
		return dao.enfantSituationParental();
	}


	@Override
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant) {
		
		return dao.getAccompagnateursByEnfant(idEnfant);
	}


	@Override
	public List<Evennement> getEvennementsByEnfant(Long idEnfant) {
		
		return dao.getEvennementsByEnfant(idEnfant);
	}


	@Override
	public List<Parent> getParentsByEnfant(Long idEnfant) {
	
		return dao.getParentsByEnfant(idEnfant);
	}


	@Override
	public List<Enfant> getEnfantsByInscriptionByClasse(Long idInscription,
			Long idClasse) {
		
		return dao.getEnfantsByInscriptionByClasse(idInscription, idClasse);
	}


	@Override
	public List<Enfant> getEnfantsByConsultationByEquipeSanitaire(
			Long idConsultation, Long idEquipeSanitaire) {
		
		return dao.getEnfantsByConsultationByEquipeSanitaire(idConsultation, idEquipeSanitaire);
	}


	@Override
	public List<Classe> getClassesByInscriptionByEnfant(Long idInscription,
			Long idEnfant) {
		
		return dao.getClassesByInscriptionByEnfant(idInscription, idEnfant);
	}


	@Override
	public List<EquipeSanitaire> getEquipeSanitaireByConsultationByEnfant(
			Long idConsultation, Long idEnfant) {
		
		return dao.getEquipeSanitaireByConsultationByEnfant(idConsultation, idEnfant);
	}


	@Override
	public List<Inscription> getInscriptionByEnfantByClasse(Long idEnfant,
			Long idClasse) {
		
		return dao.getInscriptionByEnfantbyClasse(idEnfant, idClasse);
	}


	@Override
	public List<Consultation> getConsultationByEnfantByEquipeSanitaire(
			Long idEnfant, Long idEquipeSanitaire) {
		
	return dao.getConsultationByEnfantByEquipeSanitaire(idEnfant, idEquipeSanitaire);
	}


	@Override
	public Enfant enregistrerEnfant(Inscription a, Parent p) {
	
		return dao.enregistrerEnfant(a, p);
	}


	@Override
	public List<Fournisseur> listFournisseurs() {
		
		return dao.listFournisseurs();
	}


	@Override
	public List<Fournisseur> fournisseurParNom(String nom) {
		
		return dao.fournisseurParNom(nom);
	}


	@Override
	public Fournisseur getFournisseur(Long idFournisseur) {
		
		return dao.getFournisseur(idFournisseur);
	}


	@Override
	public List<Materiels> getMaterielsByFournisseur(Long idFournisseur) {
		
		return dao.getMaterielsByFournisseur(idFournisseur);
	}


	@Override
	public List<Materiels> listMateriels() {
		
		return dao.listMateriels();
	}


	@Override
	public List<Materiels> materielsParDesignation(String designation) {
		
		return dao.materielsParDesignation(designation);
	}


	@Override
	public Materiels getMateriels(Long idMateriels) {
	
		return dao.getMateriels(idMateriels);
	}


	@Override
	public List<Fournisseur> getFournisseurByMateriels(Long idMateriels) {
		
		return dao.getFournisseurByMateriels(idMateriels);
	}


	@Override
	public List<Equipe> getEquipeByMateriels(Long idMateriels) {
	
		return dao.getEquipeByMateriels(idMateriels);
	}


	@Override
	public List<Materiels> materielsParFournisseur(Long idFournisseur) {
	
		return dao.materielsParFournisseur(idFournisseur);
	}


	@Override
	public List<Materiels> materielsParEquipe(Long idEquipe) {
		
		return dao.materielsParEquipe(idEquipe);
	}


	@Override
	public List<EquipeSanitaire> materielsParEquipeSanitaire(
			Long idEquipeSanitaire) {
		
		return dao.materielsParEquipeSanitaire(idEquipeSanitaire);
	}


	@Override
	public List<EquipeEducatif> materielsParEquipeEducatif(Long idEquipeEducatif) {
		
		return dao.materielsParEquipeEducatif(idEquipeEducatif);
	}


	@Override
	public List<Equipe> getEquipeEducatifByMateriels(Long idMateriels) {
		
		return dao.getEquipeEducatifByMateriels(idMateriels);
	}


	@Override
	public List<Equipe> getEquipeSanitaireByMateriels(Long idMateriels) {
		
		return dao.getEquipeSanitaireByMateriels(idMateriels);
	}


	@Override
	public List<TypeMateriels> listTypeMateriels() {
		
		return dao.listTypeMateriels();
	}


	@Override
	public List<TypeMateriels> typeMaterielsParLabelle(String labelle) {
		
		return dao.typeMaterielsParLabelle(labelle);
	}


	@Override
	public TypeMateriels getTypeMateriels(Long idTypeMateriels) {
		
		return dao.getTypeMateriels(idTypeMateriels);
	}


	@Override
	public List<Stock> listStock() {
		
		return dao.listStock();
	}


	@Override
	public Stock getStock(Long idStock) {
		
		return dao.getStock(idStock);
	}


	


	@Override
	public void supprimerCategorieClub(Long idCategorieClub) {
		
		dao.supprimerCategorieClub(idCategorieClub);
		
	}


	@Override
	public void modifierCategorieClub(CategorieClub categorieClub) {
		
		dao.modifierCategorieClub(categorieClub);
	}


	@Override
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires,
			Long idGenrePlanning) {
		
		return dao.ajouterPlanningHorraires(planningHorraires, idGenrePlanning);
	}


	@Override
	public void supprimerPlanningHorraires(Long idPlanningHorraires) {
		
		dao.supprimerPlanningHorraires(idPlanningHorraires);
		
	}


	@Override
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires) {
		
		dao.modifierPlanningHorraires(planningHorraires);
	}


	@Override
	public void ajouterInscriptionPourPlanningHorraires(Long idInscription,
			Long idPlanningHorraires) {
		
		dao.ajouterInscriptionPourPlanningHorraires(idInscription, idPlanningHorraires);
		
		
	}


	


	@Override
	public void supprimerClubs(Long idClubs) {
		
		dao.supprimerClubs(idClubs);
		
	}


	@Override
	public void modifierClubs(Clubs clubs) {
		
		dao.modifierClubs(clubs);
	}


	@Override
	public Long ajouterGenrePlanning(GenrePlanning genrePlanning) {
		
		return dao.ajouterGenrePlanning(genrePlanning);
	}


	@Override
	public void supprimerGenrePlanning(Long idGenrePlanning) {
		
		dao.supprimerGenrePlanning(idGenrePlanning);
		
	}


	@Override
	public void modifierGenrePlanning(GenrePlanning genrePlanning) {
		
		dao.modifierGenrePlanning(genrePlanning);
		
	}


	@Override
	public Long ajouterCreche(Creche creche) {
		
		return dao.ajouterCreche(creche);
	}


	@Override
	public void supprimerCreche(Long idCreche) {
		dao.supprimerCreche(idCreche);
		
	}


	@Override
	public void modifierCreche(Creche creche) {
		
		dao.modifierCreche(creche);
	}


	@Override
	public Long ajouterClasse(Classe classe, Long idCreche) {
		
		return dao.ajouterClasse(classe, idCreche);
	}


	@Override
	public void supprimerClasse(Long idClasse) {
		
		dao.supprimerClasse(idClasse);
	}


	@Override
	public void modifierClasse(Classe classe) {
		
		dao.modifierClasse(classe);
		
		
	}


	@Override
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,
			Long idClasse) {
		
		dao.ajouterEquipeEducatifPourClasse(idEquipeEducatif, idClasse);
	}


	@Override
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,
			Long idFonction) {
		
		return dao.ajouterEquipeSanitaire(equipeSanitaire, idFonction);
	}


	@Override
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire) {
		
		dao.supprimerEquipeSanitaire(idEquipeSanitaire);
		
	}


	@Override
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire) {
		
		dao.modifierEquipeSanitaire(equipeSanitaire);
		
	}


	@Override
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,
			Long idFonction) {
		
		return dao.ajouterEquipeEducatif(equipeEducatif, idFonction);
	}


	@Override
	public void supprimerEquipeEducatif(Long idEquipeEducatif) {
		
		dao.supprimerEquipeEducatif(idEquipeEducatif);
	}


	@Override
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif) {
		
		dao.modifierEquipeEducatif(equipeEducatif);
	}


	@Override
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,
			Long idEquipeEducatif) {
		
		dao.ajouterClassesPourEquipeEducatifs(idClasse, idEquipeEducatif);
	}


	@Override
	public Long ajouterFonction(Fonction fonction) {
		
		return dao.ajouterFonction(fonction);
	}


	@Override
	public void supprimerFonction(Long idFonction) {
		
		dao.supprimerFonction(idFonction);
	}


	@Override
	public void modifierFonction(Fonction fonction) {
		
		dao.modifierFonction(fonction);
	}


	@Override
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur) {
		
		return dao.ajouterAccompagnateur(accompagnateur);
	}


	@Override
	public void supprimerAccompagnateurs(Long idAccompagnateur) {
		
		dao.supprimerAccompagnateurs(idAccompagnateur);
	}


	@Override
	public void modifierAccompagnateurs(Accompagnateur accompagnateur) {
		
		dao.modifierAccompagnateurs(accompagnateur);
	}


	@Override
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,
			Long idAccompagnateur) {
		
		dao.ajouterEnfantsPourAccompagnateur(idEnfant, idAccompagnateur);
	}


	@Override
	public Long ajouterInscription(Inscription inscription) {
		
		return dao.ajouterInscription(inscription);
	}


	@Override
	public void supprimerInscriptions(Long idInscription) {
		
		dao.supprimerInscriptions(idInscription);
		
	}


	@Override
	public void modifierInscriptions(Inscription inscription) {
		dao.modifierInscriptions(inscription);
		
		
	}


	@Override
	public void ajouterInscriptionsPourEnfantPourClasse(Long idInscription,
			Long idEnfant, Long idclass) {
		
		dao.ajouterInscriptionsPourEnfantPourClasse(idInscription, idEnfant, idclass);
		
	}


	@Override
	public void ajouterEnfantsPourInscriptionPourClasse(Long idEnfant,
			Long idInscription, Long idclass) {
		
		dao.ajouterEnfantsPourInscriptionPourClasse(idEnfant, idInscription, idclass);
	}


	@Override
	public void ajouterClassesPourInscriptionPourEnfant(Long idclass,
			Long idInscription, Long idEnfant) {
		
		dao.ajouterClassesPourInscriptionPourEnfant(idclass, idInscription, idEnfant);
	}


	@Override
	public void ajouterPlanningHorrairsPourInscription(
			Long idPlanningHorraires, Long idInscription) {
		
		dao.ajouterPlanningHorrairsPourInscription(idPlanningHorraires, idInscription);
	}


	@Override
	public Long ajouterParent(Parent parent) {
		
		return dao.ajouterParent(parent);
	}


	@Override
	public void supprimerParent(Long idParent) {
		
		dao.supprimerParent(idParent);
	}


	@Override
	public void modifierParent(Parent parent) {
		dao.modifierParent(parent);
		
	}


	@Override
	public void ajouterEnfantsPourParent(Long idEnfant, Long idParent) {
		
		dao.ajouterEnfantsPourParent(idEnfant, idParent);
	}


	@Override
	public Long ajouterConsultation(Consultation consultation) {
		
		return dao.ajouterConsultation(consultation);
	}


	@Override
	public void supprimerConsultations(Long idConsultation) {
		
		dao.supprimerConsultations(idConsultation);
	}


	@Override
	public void modifierConsultations(Consultation consultation) {
	
		dao.modifierConsultations(consultation);
	}


	@Override
	public void ajouterConsultationsPourEnfantPourEquipeSanitaire(
			Long idConsultation, Long idEnfant, Long idEquipeSanitaire) {
		
		dao.ajouterConsultationsPourEnfantPourEquipeSanitaire(idConsultation, idEnfant, idEquipeSanitaire);
	}


	@Override
	public void ajouterEnfantsPourConsultationPourEquipeSanitaire(
			Long idEnfant, Long idConsultation, Long idEquipeSanitaire) {
		
		dao.ajouterEnfantsPourConsultationPourEquipeSanitaire(idEnfant, idConsultation, idEquipeSanitaire);
	}


	@Override
	public void ajouterEquipeSanitairesPourConsultationPourEnfant(
			Long idEquipeSanitaire, Long idConsultation, Long idEnfant) {
		
		dao.ajouterEquipeSanitairesPourConsultationPourEnfant(idEquipeSanitaire, idConsultation, idEnfant);
		
	}


	@Override
	public Long ajouterEvennement(Evennement evennement) {
		
		return dao.ajouterEvennement(evennement);
	}


	@Override
	public void supprimerEvennements(Long idEvennement) {
		
		dao.supprimerEvennements(idEvennement);
	}


	@Override
	public void modifierEvennements(Evennement evennement) {
		
		dao.modifierEvennements(evennement);
	}


	@Override
	public void ajouterEnfantsPourEvennement(Long idEnfant, Long idEvennement) {
		
		dao.ajouterEnfantsPourEvennement(idEnfant, idEvennement);
	}


	@Override
	public Long ajouterEnfant(Enfant enfant) {
		
		return dao.ajouterEnfant(enfant);
	}


	@Override
	public void supprimerEnfant(Long idEnfant) {
		
		dao.supprimerEnfant(idEnfant);
		
	}


	@Override
	public void modifierEnfant(Enfant enfant) {
		
		dao.modifierEnfant(enfant);
		
	}


	@Override
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,
			Long idEnfant) {
		
		dao.ajouterAccompagnateursPourEnfant(idAccompagnateur, idEnfant);
	}


	@Override
	public void ajouterEvennementsPourEnfant(Long idEvennement, Long idEnfant) {
		
		dao.ajouterEvennementsPourEnfant(idEvennement, idEnfant);
	}


	@Override
	public void ajouterParentsPourEnfant(Long idParent, Long idEnfant) {
		
		dao.ajouterParentsPourEnfant(idParent, idEnfant);
	}


	@Override
	public Long ajouterFournisseur(Fournisseur fournisseur) {
		
		return dao.ajouterFournisseur(fournisseur);
	}


	@Override
	public void supprimerFournisseur(Long idFournisseur) {
		
		dao.supprimerFournisseur(idFournisseur);
		
	}


	@Override
	public void modifierFournisseur(Fournisseur fournisseur) {
		
		dao.modifierFournisseur(fournisseur);
		
	}


	@Override
	public void ajouterMaterielsPourFournisseur(Long idMateriels,
			Long idFournisseur) {
		
		dao.ajouterMaterielsPourFournisseur(idMateriels, idFournisseur);
	}


	@Override
	public Long ajouterMateriels(Materiels materiels, Long idTypeMateriels,
			Long idStock) {
		
		return dao.ajouterMateriels(materiels, idTypeMateriels, idStock);
	}


	@Override
	public void supprimerMateriels(Long idMateriels) {
		
		dao.supprimerMateriels(idMateriels);
	}


	@Override
	public void modifierMateriels(Materiels materiels) {
		
		dao.modifierMateriels(materiels);
		
	}


	@Override
	public void ajouterFournisseurPourMateriels(Long idFournisseur,
			Long idMateriels) {
		
		dao.ajouterFournisseurPourMateriels(idFournisseur, idMateriels);
		
	}


	@Override
	public void ajouterEquipePourMateriels(Long idEquipe, Long idMateriels) {
	
		dao.ajouterEquipePourMateriels(idEquipe, idMateriels);
		
	}


	@Override
	public Long ajouterTypeMateriel(TypeMateriels typeMateriels) {
		
		return dao.ajouterTypeMateriel(typeMateriels);
	}


	@Override
	public void supprimerTypeMateriels(Long idTypeMateriels) {
		
		dao.supprimerTypeMateriels(idTypeMateriels);
	}


	@Override
	public void modifierTypeMateriels(TypeMateriels typeMateriels) {
		
		dao.modifierTypeMateriels(typeMateriels);
	}


	@Override
	public Long ajouterStock(Stock stock) {
		
		return dao.ajouterStock(stock);
	}


	@Override
	public void supprimerStock(Long idStock) {
	
		dao.supprimerStock(idStock);
		
	}


	@Override
	public void modifierStock(Stock stock) {
	
		dao.modifierStock(stock);
	}


	@Override
	public List<Clubs> clubParcategorieClub(Long idCategorieClub) {
		
		return dao.clubParcategorieClub(idCategorieClub);
	}


	@Override
	public Long ajouterCategorieClub(CategorieClub categorieClub) {
	
		return dao.ajouterCategorieClub(categorieClub);
	}


	@Override
	public Long ajouterClubs(Clubs clubs, Long idInscription,
			Long idCtagorieClubs) {
		
		return dao.ajouterClubs(clubs, idInscription, idCtagorieClubs);
	}


	@Override
	public List<Parent> listParents(int position, int nbrParents) 
	{
		
		return dao.listParents(position, nbrParents);
	}


	@Override
	public long getNombreParents()
	{
		
		return dao.getNombreParents();
	}


	@Override
	public List<Enfant> listEnfants(int position, int nbrEnfants) {
	
		return dao.listEnfants(position, nbrEnfants);
	}


	@Override
	public long getNombreEnfants() {
		
		return dao.getNombreEnfants();
	}


	@Override
	public long getNombreEvennements() {
		
		return dao.getNombreEvennements();
	}


	@Override
	public List<Evennement> listEvennements(int position, int nbrEvennements) {
		
		return dao.listEvennements(position, nbrEvennements);
	}


	@Override
	public long getNombreEquipesSan() {
		
		return dao.getNombreEquipesSan();
	}


	@Override
	public List<EquipeSanitaire> listEquipeSanitaires(int position,int nbrEquipesSan) {
		
		return dao.listEquipeSanitaires(position, nbrEquipesSan);
	}


	@Override
	public long getNombreFournisseurs() 
	{
		
		return dao.getNombreFournisseurs();
	}


	@Override
	public List<Fournisseur> listFournisseurs(int position, int nbrFournisseurs) 
	{
		
		return dao.listFournisseurs(position, nbrFournisseurs);
	}


	@Override
	public List<Equipe> equipeParNom(String nom) {
		
		return dao.equipeParNom(nom);
	}


	@Override
	public Equipe getEquipe(Long idEquipe) {
		
		return dao.getEquipe(idEquipe);
	}


	@Override
	public List<Equipe> getMaterielByEquipe(Long idEquipe) {
		
		return dao.getMaterielByEquipe(idEquipe);
	}


	@Override
	public long getNombreEquipes() {
		
		return dao.getNombreEquipes();
	}


	@Override
	public List<Equipe> listEquipes() {
		
		return dao.listEquipes();
	}


	@Override
	public List<Equipe> listEquipes(int position, int nbrEquipes) {
		
		return dao.listEquipes(position, nbrEquipes);
	}


	@Override
	public Long ajouterEquipe(Equipe equipe) {
		
		return dao.ajouterEquipe(equipe);
	}


	@Override
	public void supprimerEquipes(Long idEquipe) {
		
		dao.supprimerEquipes(idEquipe);
		
	}


	@Override
	public void modifierEquipes(Equipe equipe) {
		
		dao.modifierEquipes(equipe);
		
	}


	@Override
	public void ajouterMaterielPourEquipe(Long idMateriel, Long idEquipe) {
		
		dao.ajouterMaterielPourEquipe(idMateriel, idEquipe);
		
	}


	@Override
	public Personnage getPersonnage(Long idPersonnage) {
		
		return dao.getPersonnage(idPersonnage);
	}


	@Override
	public long getNombrePersonnages() {
		
		return dao.getNombrePersonnages();
	}


	@Override
	public List<Personnage> personnageParNom(String nom) {
		
		return dao.personnageParNom(nom);
	}


	@Override
	public List<Personnage> listPersonnage(int position, int nbrPersonnage) {
		
		return dao.listPersonnage(position, nbrPersonnage);
	}


	@Override
	public List<Personnage> listPersonnage() {
		
		return dao.listPersonnage();
	}


	@Override
	public Long ajouterPersonnage(Personnage personnage) {
		
		return dao.ajouterPersonnage(personnage);
	}


	@Override
	public void supprimerPersonnage(Long idPersonnage) {
		dao.supprimerPersonnage(idPersonnage);
		
	}


	@Override
	public void modifierPersonnages(Personnage personnage) {
		
		dao.modifierPersonnages(personnage);
		
	}


	@Override
	public long getNombreFonctions() {
		
		return dao.getNombreFonctions();
	}


	@Override
	public List<Fonction> listFonctions(int position, int nbrFonctions) {
	
		return dao.listFonctions(position, nbrFonctions);
	}


	@Override
	public long getNombreCreches() {
		
		return dao.getNombreCreches();
	}


	@Override
	public List<Creche> listCreches(int position, int nbrCreches) {
		
		return dao.listCreches(position, nbrCreches);
	}


	@Override
	public long getNombreEquipesEdu() {
		
		return dao.getNombreEquipesEdu();
	}


	@Override
	public List<EquipeEducatif> listEquipeEducatif(int position,int nbrEquipesEdu) {
		
		return dao.listEquipeEducatif(position, nbrEquipesEdu);
	}


	@Override
	public long getNombreClasses() {
		
		return dao.getNombreClasses();
	}


	@Override
	public List<Classe> listClasse(int position, int nbrClasses) {
	
		return dao.listClasse(position, nbrClasses);
	}


	@Override
	public long getNombreTypesMateriels() {
		
		return dao.getNombreTypesMateriels();
	}


	@Override
	public List<TypeMateriels> listTypeMateriels(int position,int nbrTypesMateriels) {
		
		return dao.listTypeMateriels(position, nbrTypesMateriels);
	}


	@Override
	public long getNombreStocks() {
		
		return dao.getNombreStocks();
	}


	@Override
	public List<Stock> listStock(int position, int nbrStocks) {
		
		return dao.listStock(position, nbrStocks);
	}


	@Override
	public long getNombreCategorieClubs() {
		
		return dao.getNombreCategorieClubs();
	}


	@Override
	public List<CategorieClub> listCategorieClubs(int position,int nbrCategorieClubs) 
	{
		
		return dao.listCategorieClubs(position, nbrCategorieClubs);
	}


	@Override
	public long getNombreGenrePlanning() {
		
		return dao.getNombreGenrePlanning();
	}


	@Override
	public List<GenrePlanning> listGenrePlanning(int position,
			int nbrGenrePlanning) {
		
		return dao.listGenrePlanning(position, nbrGenrePlanning);
	}


	@Override
	public long getNombreInscriptions() {
		
		return dao.getNombreInscriptions();
	}


	@Override
	public List<Inscription> listInscriptions(int position, int nbrInscriptions) {
		
		return dao.listInscriptions(position, nbrInscriptions);
	}


	@Override
	public long getNombreConsultations() {
		
		return dao.getNombreConsultations();
	}


	@Override
	public List<Consultation> listConsultations(int position,
			int nbrConsultations) {
	
		return dao.listConsultations(position, nbrConsultations);
	}


	@Override
	public long getNombreClubs() {
		
		return dao.getNombreClubs();
	}


	@Override
	public List<Clubs> listClubs(int position, int nbrClubs) {
		
		return dao.listClubs(position, nbrClubs);
	}


	@Override
	public long getNombrePlanningHorraires() {
		
		return dao.getNombrePlanningHorraires();
	}


	@Override
	public List<PlanningHorraires> listPlanningHorraires(int position,int nbrPlanningHorraires) {
		
		return dao.listPlanningHorraires(position, nbrPlanningHorraires);
	}


	@Override
	public long getNombreMateriels() {
		
		return dao.getNombreMateriels();
	}


	@Override
	public List<Materiels> listMateriels(int position, int nbrMateriels) {
		
		return dao.listMateriels(position, nbrMateriels);
	}
	
	

}
