package org.gestion.cr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Annee;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Clubs;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.EquipeTechnique;
import org.gestion.cr.entities.FicheAnnexeEnfant;
import org.gestion.cr.entities.Fonction;
import org.gestion.cr.entities.Genre;
import org.gestion.cr.entities.Menus;
import org.gestion.cr.entities.NomClass;
import org.gestion.cr.entities.Parent;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.entities.Tarif;

public class CrecheDaoImpl implements ICrecheDAO
{
	@PersistenceContext
	private EntityManager em;
	
	
	
	
	
	//Gestion des CategorieClubs

	@Override
	public Long ajouterCategorieClub(CategorieClub categorieClub, Long idClub) 
	{
		Clubs club=em.find(Clubs.class, idClub);
		categorieClub.setClubs(club);
		em.persist(categorieClub); //enregistrer le nouveau categorieClub avec un id club
		
		return categorieClub.getIdCateg();
	}

	@Override
	public List<CategorieClub> listCategorieClubs()
	{
		
       Query req=em.createQuery("select cat from CategorieClub cat");
		
	   return req.getResultList();
			
	}

	@Override
	public List<CategorieClub> categorieClubParNom(String nomCategorieClub) 
	{
		
       Query req=em.createQuery("select cat from CategorieClub cat where cat.labelle like :x ");
	   req.setParameter("x", "%"+nomCategorieClub+"%"); //"%" c a d quelque soit la position du nomCategorieClub dans labelle du categorie"
	   return req.getResultList();
	}

	@Override
	public List<CategorieClub> categorieClubParClub(Long idClub) 
	{
		
		 Query req=em.createQuery("select cat from CategorieClub cat join cat.Clubs club where club.ID_CLUB=:x");
		 req.setParameter("x", idClub);	
		 return req.getResultList();
	}

	@Override
	public CategorieClub getCategorieClub(Long idCategorieClub) 
	{
		
		return em.find(CategorieClub.class, idCategorieClub);
	}

	@Override
	public void supprimerCategorieClub(Long idCategorieClub)
	{
	
		CategorieClub c=em.find(CategorieClub.class, idCategorieClub);
		em.remove(c);
		
	}

	@Override
	public void modifierCategorieClub(CategorieClub categorieClub) 
	{
	
		em.merge(categorieClub);
	}
	
	
	
	//Gestion des PlanningHorraires

	@Override
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires) 
	{
		em.persist(planningHorraires);
		
		return planningHorraires.getIdPlanning();
	}

	@Override
	public List<PlanningHorraires> listPlanningHorraires() 
	{
		Query req=em.createQuery("select pl from PlanningHorraires pl");
		
		return req.getResultList();
	}

	@Override
	public PlanningHorraires getPlanningHorraires(Long idPlanningHorraires) 
	{
			
		return em.find(PlanningHorraires.class, idPlanningHorraires);
	}

	@Override
	public void supprimerPlanningHorraires(Long idPlanningHorraires)
	{
		
		PlanningHorraires p=em.find(PlanningHorraires.class, idPlanningHorraires);
		em.remove(p);
	}

	@Override
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires)
	{
		
		em.merge(planningHorraires);
	}
	
	
	
	//Gestion des Tarifs

	@Override
	public Long ajouterTarif(Tarif tarif, Long idPlanningHorraires,Long idEnfant) 
	{
		
		PlanningHorraires planing=em.find(PlanningHorraires.class, idPlanningHorraires);
		Enfant enf=em.find(Enfant.class, idEnfant);
		tarif.setPlannigHorraires(planing);
		tarif.setEnfant(enf);
		em.persist(tarif); 
		return tarif.getIdTarif();
	}

	@Override
	public List<Tarif> listTarifs() 
	{
		
        Query req=em.createQuery("select ta from Tarif ta");
		
		return req.getResultList();
	}

	@Override
	public List<Tarif> tarifParPlanningHorraires(Long idPlanningHorraires)
	{
		
		 Query req=em.createQuery("select ta from Tarif ta join ta.PlanningHorraires plan where plan.ID_PLANNING_HORRAIRES=:x");
		 req.setParameter("x", idPlanningHorraires);	
		 return req.getResultList();
	}

	
	@Override
	public Tarif getTarif(Long idTarif)
	{
		
		return em.find(Tarif.class, idTarif);
	}

	@Override
	public void supprimerTarif(Long idTarif) 
	{
		Tarif t=em.find(Tarif.class, idTarif);
		em.remove(t);
		
	}

	@Override
	public void modifierTarif(Tarif tarif) 
	{
		em.merge(tarif);
		
	}
	
	
	
	//Gestion des Menus

	@Override
	public Long ajouterMenus(Menus menus, Long idTarif) 
	{
		
		Tarif tar=em.find(Tarif.class, idTarif);
		menus.setTarif(tar);
		em.persist(menus); 
		
		return menus.getIdMenu();
	}

	@Override
	public List<Menus> listMenus() 
	{
		
       Query req=em.createQuery("select me from Menus me");
		
		return req.getResultList();
		
	}

	@Override
	public List<Menus> menusParNom(String nomMenus) 
	{
		
	  Query req=em.createQuery("select me from Menus me where me.nom like :x ");
	  req.setParameter("x", "%"+nomMenus+"%"); 
	  return req.getResultList();
	}

	@Override
	public List<Menus> menusParTarif(Long idTarif)
	{
		
		 Query req=em.createQuery("select me from Menus me join me.Tarif tar where tar.ID_TARIF=:x");
		 req.setParameter("x", idTarif);	
		 return req.getResultList();
	}

	@Override
	public Menus getMenus(Long idMenus) 
	{
		
		return em.find(Menus.class, idMenus);
	}

	@Override
	public void supprimerMenus(Long idMenus) 
	{
		Menus m=em.find(Menus.class, idMenus);
		em.remove(m);
		
	}

	@Override
	public void modifierMenus(Menus menus) 
	{
		em.merge(menus);
		
	}
	
	
	
	//Gestion des Clubs

	@Override
	public Long ajouterClubs(Clubs clubs, Long idTarif) 
	{
		
		Tarif tar=em.find(Tarif.class, idTarif);
		clubs.setTarif(tar);
		em.persist(clubs); 
		
		return clubs.getIdClub();
	}

	@Override
	public List<Clubs> listClubs() 
	{
		
		 Query req=em.createQuery("select cl from Clubs cl");
			
		 return req.getResultList();
	}

	@Override
	public List<Clubs> clubsParNom(String nomClubs) 
	{
		
		Query req=em.createQuery("select cl from Clubs cl where cl.nom like :x ");
		req.setParameter("x", "%"+nomClubs+"%"); 
		return req.getResultList();
	}

	@Override
	public List<Clubs> clubsParTarif(Long idTarif)
	{
		
		 Query req=em.createQuery("select cl from Clubs cl join cl.Tarif tar where tar.ID_TARIF=:x");
		 req.setParameter("x", idTarif);	
		 return req.getResultList();
	}

	@Override
	public Clubs getClubs(Long idClubs) 
	{
		
		return em.find(Clubs.class, idClubs);
	}

	@Override
	public void supprimerClubs(Long idClubs)
	{
		
		Clubs cl=em.find(Clubs.class, idClubs);
		em.remove(cl);
		
	}

	@Override
	public void modifierClubs(Clubs clubs)
	{
		em.merge(clubs);
		
	}
	
	
	
	//Gestion des Nom Classes

	@Override
	public Long ajouterNomClass(NomClass nomClass) 
	{
	
        em.persist(nomClass);
		
		return nomClass.getIdNomClass();
	}

	@Override
	public List<NomClass> listNomClass() 
	{
		
		 Query req=em.createQuery("select ncl from NomClass ncl");
			
		 return req.getResultList();
	}

	@Override
	public NomClass getNomClass(Long idNomClass) 
	{
		
		return em.find(NomClass.class, idNomClass);
	}

	@Override
	public void supprimerNomClass(Long idNomClass) 
	{
		NomClass nomcl=em.find(NomClass.class, idNomClass);
		em.remove(nomcl);
		
	}

	@Override
	public void modifierNomClass(NomClass nomClass)
	{
		em.merge(nomClass);
		
	}
	
	
	
	//gestion des Creches   Composition des Classes

	@Override
	public Long ajouterCreche(Creche creche)
	{
		
        em.persist(creche);
		
		return creche.getIdCreche();
	}

	@Override
	public List<Creche> listCreches() 
	{
		
		 Query req=em.createQuery("select cr from Creche cr");
			
		 return req.getResultList();
	}

	@Override
	public List<Creche> crecheParNom(String nomCreche) 
	{
		
		Query req=em.createQuery("select cr from Creche cr where cr.nom like :x ");
		req.setParameter("x", "%"+nomCreche+"%"); 
		return req.getResultList();
	}

	@Override
	public Creche getCreche(Long idCreche) 
	{
		
		return em.find(Creche.class, idCreche);
	}

	@Override
	public void supprimerCreche(Long idCreche)
	{
		
		Creche cr=em.find(Creche.class, idCreche);
		em.remove(cr);
		
	}

	@Override
	public void modifierCreche(Creche creche) 
	{
		
		em.merge(creche);
		
	}
	
	
	
	
	//Gestion des Classes

	@Override
	public Long ajouterClasse(Classe classe, Long idCreche,Long idNomClass) 
	{
		
		Creche crech=em.find(Creche.class, idCreche);
		NomClass nomclass=em.find(NomClass.class, idNomClass);
		classe.setCreche(crech);
		classe.setNomClasse(nomclass);
		em.persist(classe); 
		return classe.getIdClass();
	}

	@Override
	public List<Classe> listClasse()
	{
		
		 Query req=em.createQuery("select clas from Classe clas");
			
		 return req.getResultList();
	}

	@Override
	public List<Classe> classeParNom(String nomClasse) 
	{
		
		Query req=em.createQuery("select clas from Classe clas where clas.nom like :x ");
		req.setParameter("x", "%"+nomClasse+"%"); 
		return req.getResultList();
	}

	@Override
	public List<Classe> classeParCreche(Long idCreche) 
	{
		Query req=em.createQuery("select clas from Classe clas join clas.Creche cr where cr.ID_CRECHE=:x");
		req.setParameter("x", idCreche);	
		return req.getResultList();
		
		
	}

	@Override
	public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse)
	{
		Query req=em.createQuery("select edu from EquipeEducatif edu  join edu.Classe cl where cl.ID_CLASSE=:x");
		
		return req.getResultList();
	}

	

	@Override
	public Classe getClasse(Long idClasse) 
	{
		
		return em.find(Classe.class, idClasse);
	}

	@Override
	public void supprimerClasse(Long idClasse) 
	{
		Classe clas=em.find(Classe.class, idClasse);
		em.remove(clas);
		
	}

	@Override
	public void modifierClasse(Classe classe) 
	{
		
		em.merge(classe);
	}
	
	@Override
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse)
	{
		EquipeEducatif edu=em.find(EquipeEducatif.class, idEquipeEducatif);
		Classe cl=em.find(Classe.class, idClasse);
		edu.getClasses().add(cl);
		cl.getEquipeEducatifs().add(edu);
			
	}
	
	
	//Gestion des Equipes Technique

	@Override
	public Long ajouterEquipeTechnique(EquipeTechnique equipeTechnique,Long idCreche,Long idFonction) 
	{
		
		Creche crech=em.find(Creche.class, idCreche);
		Fonction fon=em.find(Fonction.class, idFonction);
		equipeTechnique.setCreche(crech);
		equipeTechnique.setFonction(fon);
		em.persist(equipeTechnique); 
		return equipeTechnique.getIdPerson();
	}

	@Override
	public List<EquipeTechnique> listEquipeTechniques() 
	{
		
		 Query req=em.createQuery("select tech from EquipeTechnique tech");
			
		 return req.getResultList();
	}
	
	
	@Override
	public List<EquipeTechnique> equipeTechniqueParNom(String nom) 
	
	{
		
		Query req=em.createQuery("select tech from EquipeTechnique tech where tech.nom like :x or tech.prenom :x");
		req.setParameter("x", "%"+nom+"%"); 
		return req.getResultList();
	}

	@Override
	public List<EquipeTechnique> equipeTechniqueParCreche(Long idCreche) 
	{
		
		Query req=em.createQuery("select tech from EquipeTechnique tech join tech.Creche cr where cr.ID_CRECHE=:x");
		req.setParameter("x", idCreche);	
		return req.getResultList();
	}

	@Override
	public List<EquipeTechnique> equipeTechniqueParFonction(Long idFonction)
	{
		
		Query req=em.createQuery("select tech from EquipeTechnique tech join tech.Fonction fon where fon.ID_FONCTION=:x");
		req.setParameter("x", idFonction);	
		return req.getResultList();
	}

	@Override
	public EquipeTechnique getEquipeTechnique(Long idEquipeTechnique)
	{
		
		return em.find(EquipeTechnique.class, idEquipeTechnique);
	}

	@Override
	public void supprimerEquipeTechnique(Long idEquipeTechnique) 
	{
		EquipeTechnique tech=em.find(EquipeTechnique.class, idEquipeTechnique);
		em.remove(tech);
		
	}

	@Override
	public void modifierEquipeTechnique(EquipeTechnique equipeTechnique)
	{
		
		em.merge(equipeTechnique);
	}
	
	
	
	//Gestion des Equipes Sanitaire

	@Override
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction) 
	{
		
		Fonction fon=em.find(Fonction.class, idFonction);
		equipeSanitaire.setFonction(fon);
		em.persist(equipeSanitaire); 
		return equipeSanitaire.getIdPerson();
	}

	@Override
	public List<EquipeSanitaire> listEquipeSanitaires()
	{
		
		Query req=em.createQuery("select san from EquipeSanitaire san");
		
		 return req.getResultList();
	}
	
	@Override
	public List<EquipeSanitaire> equipeSanitaireParNom(String nom)
	{
		
		Query req=em.createQuery("select san from EquipeSanitaire san where san.nom like :x or san.prenom :x");
		req.setParameter("x", "%"+nom+"%"); 
		return req.getResultList();
	}

	@Override
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction)
	{
		
		Query req=em.createQuery("select san from EquipeSanitaire san join san.Fonction fon where fon.ID_FONCTION=:x");
		req.setParameter("x", idFonction);	
		return req.getResultList();
	}

	@Override
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire)
	{
		
		return em.find(EquipeSanitaire.class, idEquipeSanitaire);
	}

	@Override
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire) 
	{
		EquipeSanitaire sa=em.find(EquipeSanitaire.class, idEquipeSanitaire);
		em.remove(sa);
	
		
	}

	@Override
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire) 
	{
		em.merge(equipeSanitaire);
		
	}

	@Override
	public List<Enfant> getEnfantsByEquipeSanitaire(Long idEquipeSanitaire) 
	{
		
		Query req=em.createQuery("select enf from Enfant enf join enf.EquipeSanitaire san where san.ID_EQ_SAN=:x");
		req.setParameter("x", idEquipeSanitaire);	
		return req.getResultList();
	}
	@Override
	public void ajouterEnfantsPourEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire) 
	{
		Enfant enf=em.find(Enfant.class, idEnfant);
		EquipeSanitaire sa=em.find(EquipeSanitaire.class, idEquipeSanitaire);
		enf.getEquipeSanitaires().add(sa);
		sa.getEnfants().add(enf);
		
	}
	
	
	//Gestion des Equipes Educatifs

	@Override
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction) 
	{
		
		Fonction fon=em.find(Fonction.class, idFonction);
		equipeEducatif.setFonction(fon);
		em.persist(equipeEducatif); 
		return equipeEducatif.getIdPerson();
	}

	@Override
	public List<EquipeEducatif> listEquipeEducatif() 
	{


		Query req=em.createQuery("select edu from EquipeEducatif edu");
		
		 return req.getResultList();
	}
	
	@Override
	public List<EquipeEducatif> equipeEducatifParNom(String nom)
	{
	
		Query req=em.createQuery("select edu from EquipeEducatif edu where edu.nom like :x or edu.prenom :x");
		req.setParameter("x", "%"+nom+"%"); 
		return req.getResultList();
	}

	@Override
	public List<EquipeEducatif> equipeEducatifParFonction(Long idFonction) 
	{
		

		Query req=em.createQuery("select edu from EquipeEducatif edu join edu.Fonction fon where fon.ID_FONCTION=:x");
		req.setParameter("x", idFonction);	
		return req.getResultList();
	}

	@Override
	public List<Classe> getClassesByEquipeEducatif(Long idEquipeEducatif) 
	{
		Query req=em.createQuery("select cla from Classe cla join cla.EquipeEducatif edu where edu.ID_EQ_EDU=:x");
		req.setParameter("x", idEquipeEducatif);	
		return req.getResultList();
		
	}

	

	@Override
	public EquipeEducatif getEquipeEducatif(Long idEquipeEducatif) 
	{
		
		return em.find(EquipeEducatif.class, idEquipeEducatif);
	}

	@Override
	public void supprimerEquipeEducatif(Long idEquipeEducatif) 
	{
		EquipeEducatif edu=em.find(EquipeEducatif.class, idEquipeEducatif);
		em.remove(edu);
		
	}

	@Override
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif) 
	{
		em.merge(equipeEducatif);
		
	}
	
	@Override
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif) 
	{
	
		Classe cla=em.find(Classe.class, idClasse);
		EquipeEducatif edu=em.find(EquipeEducatif.class, idEquipeEducatif);
		cla.getEquipeEducatifs().add(edu);
		edu.getClasses().add(cla);
	}
	
	
	//Gestion des Fonctions

	@Override
	public Long ajouterFonction(Fonction fonction) 
	{
	
        em.persist(fonction);
		
		return fonction.getIdFonction();
	}

	@Override
	public List<Fonction> listFonctions()
	{
		
		Query req=em.createQuery("select fon from Fonction fon");
			
		return req.getResultList();
	}

	@Override
	public Fonction getFonction(Long idFonction) 
	{
		
		return em.find(Fonction.class, idFonction);
	}

	@Override
	public void supprimerFonction(Long idFonction)
	{
		Fonction fon=em.find(Fonction.class, idFonction);
		em.remove(fon);
	
		
	}

	@Override
	public void modifierFonction(Fonction fonction)
	{
		em.merge(fonction);
		
	}
	
	
	
	//Gestion des Accompahnateurs

	@Override
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur) 
	{
		
		    em.persist(accompagnateur);
			
			return accompagnateur.getIdPerson();
	}

	@Override
	public List<Accompagnateur> listAccompagnateurs() 
	{
		
		Query req=em.createQuery("select accomp from Accompagnateur accomp");
		
		return req.getResultList();
	}
	
	@Override
	public List<Accompagnateur> accompagnateurParNom(String nom)
	{
	
		Query req=em.createQuery("select accomp from Accompagnateur accomp where accomp.nom like :x or accomp.prenom :x");
		req.setParameter("x", "%"+nom+"%"); 
		return req.getResultList();
	}

	@Override
	public Accompagnateur getAccompagnateur(Long idAccompagnateur) 
	{
		
		return em.find(Accompagnateur.class, idAccompagnateur);
	}

	@Override
	public void supprimerAccompagnateurs(Long idAccompagnateur) 
	{
		
		Accompagnateur acc=em.find(Accompagnateur.class, idAccompagnateur);
		em.remove(acc);
	}

	@Override
	public void modifierAccompagnateurs(Accompagnateur accompagnateur) 
	{
		em.merge(accompagnateur);
		
	}

	@Override
	public List<Enfant> getEnfantsByAccompagnateur(Long idAccompagnateur)
	{
		
		Query req=em.createQuery("select enf from Enfant enf join enf.Accompagnateur acc where acc.ID_ACOMP_ABSENCE=:x");
		req.setParameter("x", idAccompagnateur);	
		return req.getResultList();
	}

	@Override
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur) 
	{
		
		Enfant e=em.find(Enfant.class, idEnfant);
		Accompagnateur acc=em.find(Accompagnateur.class, idAccompagnateur);
		e.getAccompagnateurs().add(acc);
		acc.getEnfants().add(e);
	}
	
	
	
	
	//Gestion des Genres

	@Override
	public Long ajouterGenre(Genre genre) 
	{
		
		 em.persist(genre);
			
		 return genre.getIdGenre();
	}

	@Override
	public List<Genre> listGenre() 
	{
	
        Query req=em.createQuery("select gen from Genre gen");
		
		return req.getResultList();
	}

	@Override
	public Genre getGenre(Long idGenre)
	{
		
		return em.find(Genre.class, idGenre);
	}

	@Override
	public void supprimerGenre(Long idGenre) 
	{
		Genre ge=em.find(Genre.class, idGenre);
		em.remove(ge);
		
	}

	@Override
	public void modifierGenre(Genre genre) 
	{
		
		em.merge(genre);
	}
	
	
	
	
	//Gestion des Annees
	

	@Override
	public Long ajouterAnnee(Annee annee)
	{
		
		 em.persist(annee);
			
		 return annee.getIdAnnee();
	}

	@Override
	public List<Annee> listAnnees() 
	{
		
        Query req=em.createQuery("select an from Annee an");
		
		return req.getResultList();
	}

	@Override
	public Annee getAnnee(Long idAnnee)
	{
		
		return em.find(Annee.class, idAnnee);
	}

	@Override
	public void supprimerAnnees(Long idAnnee) 
	{
		Annee ann=em.find(Annee.class, idAnnee);
		em.remove(ann);
		
	}

	@Override
	public void modifierAnnees(Annee annee) 
	{
		em.merge(annee);
		
	}

	@Override
	public List<Annee> getAnneesByEnfantbyClasse(Long idEnfant, Long idClasse) 
	{
		
		 Query req=em.createQuery("select an from Annee as an, an.enfant as enf, an.classe as cl where enf.ID_ENFANT=:x and cl.ID_CLASSE=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idClasse);	
		 return req.getResultList();
	}

	@Override
	public List<Enfant> getEnfantByClassebyAnnee(Long idClasse, Long idAnnee) 
	{
	
		Query req=em.createQuery("select enf from Enfant as enf, enf.Classe as cla, enf.Annee as an where cla.ID_CLASSE=:x and an.ID_ANNEE=:y");
		 req.setParameter("x", idClasse);	
		 req.setParameter("y", idAnnee);	
		 return req.getResultList();
	}

	@Override
	public List<Classe> getClassesByEnfantbyAnnee(Long idEnfant, Long idAnnee) 
	{
		
		Query req=em.createQuery("select cl from Classe as cl, cl.enfant as enf, cl.Annee as an where enf.ID_ENFANT=:x and an.ID_ANNEE=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idAnnee);	
		 return req.getResultList();
	}

	@Override
	public void ajouterAnneesPourEnfantPourClasse(Long idAnnee, Long idEnfant,Long idclass) 
	{
		Annee an=em.find(Annee.class, idAnnee);
		Enfant e=em.find(Enfant.class, idEnfant);
		Classe cl=em.find(Classe.class, idclass);
		an.getEnfants().add(e);
		an.getClasses().add(cl);
		e.getAnnees().add(an);
		e.getClasses().add(cl);
		cl.getAnnees().add(an);
		cl.getEnfants().add(e);
		
	}

	@Override
	public void ajouterEnfantsPourAnneePourClasse(Long idEnfant, Long idAnnee,Long idclass) 
	{
		
		Enfant e=em.find(Enfant.class, idEnfant);
		Annee an=em.find(Annee.class, idAnnee);
		Classe cl=em.find(Classe.class, idclass);
		e.getAnnees().add(an);
		e.getClasses().add(cl);
		an.getEnfants().add(e);
		an.getClasses().add(cl);
		cl.getAnnees().add(an);
		cl.getEnfants().add(e);
		
	}
	
	@Override
	public void ajouterClassesPourAnneePourEnfant(Long idclass, Long idAnnee,Long idEnfant) 
	{
		
		Classe cl=em.find(Classe.class, idclass);
		Annee an=em.find(Annee.class, idAnnee);
		Enfant e=em.find(Enfant.class, idEnfant);
		cl.getAnnees().add(an);
		cl.getEnfants().add(e);
		an.getEnfants().add(e);
		an.getClasses().add(cl);
		e.getAnnees().add(an);
		e.getClasses().add(cl);
		
	}
	
	
	
	 //Gestion des Parents

	@Override
	public Long ajouterParent(Parent parent, Long idGenre)
	{
		
		Genre gen=em.find(Genre.class, idGenre);
		parent.setGenre(gen);
		em.persist(parent); 
		return parent.getIdPerson();
	}

	@Override
	public List<Parent> listParents() 
	{
		 Query req=em.createQuery("select par from Parent par");
			
		 return req.getResultList();
	}

	@Override
	public List<Parent> parentParNom(String nomParent) 
	{
		
		Query req=em.createQuery("select par from Parent par where par.nom like :x or par.prenom :x");
		req.setParameter("x", "%"+nomParent+"%"); 
		return req.getResultList();
	}

	@Override
	public List<Parent> parentParGenre(Long idGenre) 
	{
		Query req=em.createQuery("select par from Parent par join gr.Genre fon where gr.ID_GENRE=:x");
		req.setParameter("x", idGenre);	
		return req.getResultList();
	}

	@Override
	public Parent getParent(Long idParent) 
	{
		
		return em.find(Parent.class, idParent);
	}

	@Override
	public void supprimerParent(Long idParent) 
	{
		Parent par=em.find(Parent.class, idParent);
		em.remove(par);
		
	}

	@Override
	public void modifierParent(Parent parent)
	{
		em.merge(parent);
		
	}

	@Override
	public List<Enfant> getEnfantByParent(Long idParent) 
	{
		
		Query req=em.createQuery("select enf from Enfant enf join enf.Parent pr where pr.ID_PARENT=:x");
		req.setParameter("x", idParent);	
		return req.getResultList();
	}

	@Override
	public void ajouterEnfantsPourParent(Long idEnfant, Long idParent) 
	{
		Enfant e=em.find(Enfant.class, idEnfant);
		Parent pr=em.find(Parent.class, idParent);
		e.getParents().add(pr);
		pr.getEnfants().add(e);
		
	}
	
	
	
	//Gestion des Fiches Annexes Enfants

	@Override
	public Long ajouterFicheAnnexeEnfant(FicheAnnexeEnfant ficheAnnexeEnfant) 
	{
		
        em.persist(ficheAnnexeEnfant);
		
		return ficheAnnexeEnfant.getIdFiche();
	}

	@Override
	public List<FicheAnnexeEnfant> listFicheAnnexeEnfant() 
	{
	
		Query req=em.createQuery("select fich from FicheAnnexeEnfant fich");
		
		 return req.getResultList();
	}

	@Override
	public FicheAnnexeEnfant getFicheAnnexeEnfant(Long idFicheAnnexeEnfant) 
	{
		
		return em.find(FicheAnnexeEnfant.class, idFicheAnnexeEnfant);
	}

	@Override
	public void supprimerFicheAnnexeEnfant(Long idFicheAnnexeEnfant) 
	{
		FicheAnnexeEnfant fi=em.find(FicheAnnexeEnfant.class, idFicheAnnexeEnfant);
		em.remove(fi);
		
	}

	@Override
	public void modifierFicheAnnexeEnfant(FicheAnnexeEnfant ficheAnnexeEnfant) 
	{
		em.merge(ficheAnnexeEnfant);
		
	}
	
	
	
	
	//Gestion des Enfants

	@Override
	public Long ajouterEnfant(Enfant enfant, Long idFicheAnnexeEnfant) 
	{
		
		FicheAnnexeEnfant fich=em.find(FicheAnnexeEnfant.class, idFicheAnnexeEnfant);
		enfant.setFicheAnnexeEnfant(fich);
		em.persist(enfant); 
		return enfant.getIdPerson();
	}
	
	@Override
	public List<Enfant> listEnfants() 
	{
		
		Query req=em.createQuery("select enf from Enfant enf");
		
		 return req.getResultList();
	}
	
	@Override
	public List<Enfant> enfantParNom(String nom) 
	{
		
		Query req=em.createQuery("select enf from Enfant enf where enf.nom like :x or enf.prenom :x");
		req.setParameter("x", "%"+nom+"%"); 
		return req.getResultList();
	}

	@Override
	public Enfant getEnfant(Long idEnfant) 
	{
		
		return em.find(Enfant.class, idEnfant);
	}
	
	@Override
	public List<Enfant> enfantCertife() 
	{
		
		Query req=em.createQuery("select enf from Enfant enf where enf.certificatMedicale=true");
		
		return req.getResultList();
	}

	@Override
	public List<Enfant> enfantPhotoAutorise() 
	{
	
		Query req=em.createQuery("select enf from Enfant enf where enf.autorisationPrisePhoto=true");
		
		return req.getResultList();
	}

	@Override
	public void supprimerEnfant(Long idEnfant)
	{
		Enfant en=em.find(Enfant.class, idEnfant);
		em.remove(en);
		
	}

	@Override
	public void modifierEnfant(Enfant enfant)
	{
		em.merge(enfant);
		
	}

	@Override
	public List<Accompagnateur> getAccompagnateursByEnfant(Long idEnfant)
	{
		
		Query req=em.createQuery("select acc from Accompagnateur acc join acc.Enfant enf where enf.ID_ENFANT=:x");
		req.setParameter("x", idEnfant);	
		return req.getResultList();
	}

	@Override
	public List<Parent> getParentsByEnfant(Long idEnfant) 
	{
		
		Query req=em.createQuery("select par from Parent par join par.Enfant enf where enf.ID_ENFANT=:x");
		req.setParameter("x", idEnfant);	
		return req.getResultList();
	}

	@Override
	public List<EquipeSanitaire> getEquipeSanitairesByEnfant(Long idEnfant) 
	{
		
		Query req=em.createQuery("select san from EquipeSanitaire san join san.Enfant enf where enf.ID_ENFANT=:x");
		req.setParameter("x", idEnfant);	
		return req.getResultList();
	}

	@Override
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant) 
	{
		Accompagnateur acc=em.find(Accompagnateur.class, idAccompagnateur);
		Enfant e=em.find(Enfant.class, idEnfant);
		acc.getEnfants().add(e);
		e.getAccompagnateurs().add(acc);
		
	}

	@Override
	public void ajouterParentsPourEnfant(Long idParent, Long idEnfant) 
	{
		
		Parent pr=em.find(Parent.class, idParent);
		Enfant e=em.find(Enfant.class, idEnfant);
		pr.getEnfants().add(e);
		e.getParents().add(pr);
	}

	@Override
	public void ajouterEquipesSanitairesPourEnfant(Long idEquipeSanitaire,Long idEnfant) 
	{
		
		EquipeSanitaire san=em.find(EquipeSanitaire.class, idEquipeSanitaire);
		Enfant e=em.find(Enfant.class, idEnfant);
		san.getEnfants().add(e);
		e.getEquipeSanitaires().add(san);
	}

	@Override
	public List<Enfant> getEnfantsByAnneeByClasse(Long idAnnee, Long idClasse) 
	{
		
		Query req=em.createQuery("select enf from Enfant as enf, enf.Annee as an, enf.Classe as cl where an.ID_ANNEE=:x and cl.ID_CLASSE=:y");
		 req.setParameter("x", idAnnee);	
		 req.setParameter("y", idClasse);	
		 return req.getResultList();
	}

	@Override
	public List<Classe> getClassesByAnneeByEnfant(Long idAnnee, Long idEnfant) 
	{
		
		Query req=em.createQuery("select cl from Classe as cl, cl.Annee as an, cl.Enfant as enf where an.ID_ANNEE=:x and enf.ID_ENFANT=:y");
		 req.setParameter("x", idAnnee);	
		 req.setParameter("y", idEnfant);	
		 return req.getResultList();
	}

	@Override
	public List<Annee> getAnneeByEnfantByClasse(Long idEnfant, Long idClasse) 
	{
		
		Query req=em.createQuery("select an from Annee as an, an.Enfant as enf, an.Classe as cl where enf.ID_ENFANT=:x and cl.ID_CLASSE=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idClasse);	
		 return req.getResultList();
	}

	@Override
	public Enfant enregistrerEnfant(Annee a, Parent p) 
	{
		
		return null;
	}

	


}
