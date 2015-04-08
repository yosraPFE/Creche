package org.gestion.cr.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

public class CrecheDaoImpl implements ICrecheDAO
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	
	
	//Gestion des CategorieClubs

	@Override
	public Long ajouterCategorieClub(CategorieClub categorieClub) 
	{
		 em.persist(categorieClub);
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
	
	@Override
	public long getNombreCategorieClubs() {
		
		Query req=em.createQuery("select count(categ) from CategorieClub categ ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<CategorieClub> listCategorieClubs(int position,int nbrCategorieClubs) {
		
		Query req=em.createQuery("select categ from CategorieClub categ");
		req.setFirstResult(position);
		req.setMaxResults(nbrCategorieClubs);
		return req.getResultList();
	}

	

	
	//Gestion des Genres de plannings horraires

	
		@Override
		public Long ajouterGenrePlanning(GenrePlanning genrePlanning) 
		{
			
		    em.persist(genrePlanning);
			return genrePlanning.getIdGenrePlanning();
		}

		@Override
		public List<GenrePlanning> listGenrePlanning() 
		{
			
			Query req=em.createQuery("select gen from GenrePlanning gen");
			return req.getResultList();
		}

		@Override
		public List<GenrePlanning> genrePlanningParLabelle(String labelle) 
		{
			
			Query req=em.createQuery("select gen from GenrePlanning gen where gen.nom labelle :x");
			req.setParameter("x", "%"+labelle+"%"); 
			return req.getResultList();
		}

		@Override
		public GenrePlanning getGenrePlanning(Long idGenrePlanning) 
		{
			
			return em.find(GenrePlanning.class, idGenrePlanning);
		}

		@Override
		public void supprimerGenrePlanning(Long idGenrePlanning) 
		{

			GenrePlanning gen=em.find(GenrePlanning.class, idGenrePlanning);
			em.remove(gen);
			
		}

		@Override
		public void modifierGenrePlanning(GenrePlanning genrePlanning)
		{
			em.merge(genrePlanning);
			
		}
		
		@Override
		public long getNombreGenrePlanning() {
			
			Query req=em.createQuery("select count(gla) from GenrePlanning gla ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<GenrePlanning> listGenrePlanning(int position,int nbrGenrePlanning) {
			
			Query req=em.createQuery("select gla from GenrePlanning gla");
			req.setFirstResult(position);
			req.setMaxResults(nbrGenrePlanning);
			return req.getResultList();
		}

		
			

	
	//Gestion des PlanningHorraires

	@Override
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires,Long idGenrePlanning) 
	{
		
			GenrePlanning gen=em.find(GenrePlanning.class, idGenrePlanning);
			planningHorraires.setGenresPlannings(gen);
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
	@Override
	public List<PlanningHorraires> PlanningHorraireslubParGenrePlanning(Long idGenrePlanning)
	{
       	Query req=em.createQuery("select pl from PlanningHorraires pl join pl.GenrePlanning ger where ger.idGenrePlanning=:x");
		req.setParameter("x", idGenrePlanning);	
		return req.getResultList();
		
	}
	
	
	@Override
	public List<Inscription> getInscriptionByPlannigHorraires(Long idPlanningHorraires) 
	{
		
		Query req=em.createQuery("select ins from Inscription ins join ins.PlanningHorraires pl where pl.idPlanning=:x");
		req.setParameter("x", idPlanningHorraires);	
		return req.getResultList();
	}
	

	@Override
	public void ajouterInscriptionPourPlanningHorraires(Long idInscription,Long idPlanningHorraires) 
	{

		Inscription ins=em.find(Inscription.class, idInscription);
		PlanningHorraires pl=em.find(PlanningHorraires.class, idPlanningHorraires);
		ins.getPlanningHorraires().add(pl);
		pl.getInscriptions().add(ins);
		
	}
	
	@Override
	public long getNombrePlanningHorraires() {
		
		Query req=em.createQuery("select count(plan) from PlanningHorraires plan ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<PlanningHorraires> listPlanningHorraires(int position,int nbrPlanningHorraires) {
		
		Query req=em.createQuery("select plan from PlanningHorraires plan");
		req.setFirstResult(position);
		req.setMaxResults(nbrPlanningHorraires);
		return req.getResultList();
	}

	


	
	//Gestion des Clubs
	
		@Override
		public Long ajouterClubs(Clubs clubs,Long idInscription,Long idCtagorieClubs)
		{

			Inscription ins=em.find(Inscription.class, idInscription);
            CategorieClub cat=em.find(CategorieClub.class, idCtagorieClubs);
			clubs.setInscription(ins);
			clubs.setCategorieClub(cat);
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
	
	@Override
	public List<Clubs> clubParcategorieClub(Long idCategorieClub)
	{
		
		 Query req=em.createQuery("select cl from Clubs cl join cl.CategorieClub cat where cat.idCateg=:x");
		 req.setParameter("x", idCategorieClub);	
		 return req.getResultList();
	}
	
	@Override
	public long getNombreClubs() {
		
		Query req=em.createQuery("select count(clu) from Clubs clu ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Clubs> listClubs(int position, int nbrClubs) {
	
		Query req=em.createQuery("select clu from Clubs clu");
		req.setFirstResult(position);
		req.setMaxResults(nbrClubs);
		return req.getResultList();
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
	

	@Override
	public long getNombreCreches() 
	{
		
		Query req=em.createQuery("select count(cr) from Creche cr ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Creche> listCreches(int position, int nbrCreches)
	{
		
		Query req=em.createQuery("select cr from Creche cr ");
		req.setFirstResult(position);
		req.setMaxResults(nbrCreches);
		return req.getResultList();
	}


	
	
	
	
	//Gestion des Classes

	@Override
	public Long ajouterClasse(Classe classe, Long idCreche) 
	{
		
		Creche crech=em.find(Creche.class, idCreche);
		classe.setCreche(crech);
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
		Query req=em.createQuery("select clas from Classe clas join clas.Creche cr where cr.idCreche=:x");
		req.setParameter("x", idCreche);	
		return req.getResultList();
		
		
	}

	@Override
	public List<EquipeEducatif> getEquipeEducatifByClasse(Long idClasse)
	{
		Query req=em.createQuery("select edu from EquipeEducatif edu  join edu.Classe cl where cl.idClass=:x");
		
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
	
	
	
	@Override
	public long getNombreClasses() {
		
		Query req=em.createQuery("select count(clas) from Classe clas ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Classe> listClasse(int position, int nbrClasses) {
		
		Query req=em.createQuery("select clas from Classe clas  order by clas.idClass desc");
		req.setFirstResult(position);
		req.setMaxResults(nbrClasses);
		return req.getResultList();
	}

	
	//Gestion des Equipes

		@Override
		public Long ajouterEquipe(Equipe equipe) 
		{
			
			 em.persist(equipe);
				
			 return equipe.getIdPerson();
		}

		@Override
		public List<Equipe> equipeParNom(String nom)
		{
			
			Query req=em.createQuery("select eq from Equipe eq where eq.nom like :x or eq.prenom :x");
			req.setParameter("x", "%"+nom+"%"); 
			return req.getResultList();
		}

		@Override
		public Equipe getEquipe(Long idEquipe) 
		{
			

			return em.find(Equipe.class, idEquipe);
		}

		@Override
		public void supprimerEquipes(Long idEquipe) 
		{
			Equipe eq=em.find(Equipe.class, idEquipe);
			em.remove(eq);
			
		}

		@Override
		public void modifierEquipes(Equipe equipe) 
		{
			
			em.merge(equipe);
		}

		@Override
		public List<Equipe> getMaterielByEquipe(Long idEquipe)
		{
			

			Query req=em.createQuery("select ma from Materiels ma join ma.Equipe eq where acc.ID_EQUIPE=:x");
			req.setParameter("x", idEquipe);	
			return req.getResultList();
		}

		@Override
		public void ajouterMaterielPourEquipe(Long idMateriel,Long idEquipe)
		{
			Materiels m=em.find(Materiels.class, idMateriel);
			Equipe eq=em.find(Equipe.class, idMateriel);
			m.getEquipes().add(eq);
			eq.getMateriels().add(m);
			
		}

		@Override
		public long getNombreEquipes() 
		{
			
			Query req=em.createQuery("select count(eq) from Equipe eq ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Equipe> listEquipes() 
		{
		
	        Query req=em.createQuery("select eq from Equipe eq");
			
			return req.getResultList();
		}

		@Override
		public List<Equipe> listEquipes(int position, int nbrEquipes) 
		{
			

			Query req=em.createQuery("select eq from Equipe eq order by eq.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrEquipes);
			return req.getResultList();
		}
		
		
		//Gestion des Personnages

		@Override
		public Long ajouterPersonnage(Personnage personnage)
		{
				

			em.persist(personnage);
					
			return personnage.getIdPerson();
		}

		@Override
		public Personnage getPersonnage(Long idPersonnage) 
		{
			

			return em.find(Personnage.class, idPersonnage);
		}

		@Override
		public void supprimerPersonnage(Long idPersonnage)
		{
			Personnage per=em.find(Personnage.class, idPersonnage);
			em.remove(per);
				
		}

		@Override
		public void modifierPersonnages(Personnage personnage) 
		{
			em.merge(personnage);
				
		}

		@Override
		public long getNombrePersonnages() 
		{
				

			Query req=em.createQuery("select count(per) from Personnage per ");
			return (Long)req.getResultList().get(0);
		}

		@Override
		public List<Personnage> personnageParNom(String nom) 
		{
				
			Query req=em.createQuery("select per from Personnage per where per.nom like :x or per.prenom :x");
			req.setParameter("x", "%"+nom+"%"); 
			return req.getResultList();
		}

		@Override
		public List<Personnage> listPersonnage(int position,int nbrPersonnage)
		{
				
			Query req=em.createQuery("select per from Personnage per order by per.idPerson desc ");
			req.setFirstResult(position);
			req.setMaxResults(nbrPersonnage);
			return req.getResultList();
		}
		
		

		@Override
		public List<Personnage> listPersonnage()
		{
				
			Query req=em.createQuery("select per from Personnage per");
				
			return req.getResultList();
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
	public List<EquipeSanitaire> equipeSanitaireParFonction(Long idFonction) 
	{
				
		Query req=em.createQuery("select san from EquipeSanitaire san join san.Fonction fon where fon.idFonction=:x");
		req.setParameter("x", idFonction);	
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
	public EquipeSanitaire getEquipeSanitaire(Long idEquipeSanitaire)
	{
		
		return em.find(EquipeSanitaire.class, idEquipeSanitaire);
	}

	@Override
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire)
	{
		EquipeSanitaire san=em.find(EquipeSanitaire.class, idEquipeSanitaire);
		em.remove(san);
		
	}

	@Override
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire) 
	{
		em.merge(equipeSanitaire);
		
	}
	
	
	@Override
	public long getNombreEquipesSan() 
	{
		
		Query req=em.createQuery("select count(eqSa) from EquipeSanitaire eqSa ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<EquipeSanitaire> listEquipeSanitaires(int position,int nbrEquipesSan) 
	{
		
		Query req=em.createQuery("select eqSa from EquipeSanitaire eqSa order by eqSa.idPerson desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrEquipesSan);
		return req.getResultList();
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
		

		Query req=em.createQuery("select edu from EquipeEducatif edu join edu.Fonction fon where fon.idFonction=:x");
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
	
	@Override
	public long getNombreEquipesEdu()
	{
		
		Query req=em.createQuery("select count(eqEdu) from EquipeEducatif eqEdu ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<EquipeEducatif> listEquipeEducatif(int position,int nbrEquipesEdu)
	{
		
		Query req=em.createQuery("select eqEdu from EquipeEducatif eqEdu order by eqEdu.idPerson desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrEquipesEdu);
		return req.getResultList();
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
	
	@Override
	public long getNombreFonctions()
	{
		
		Query req=em.createQuery("select count(fon) from Fonction fon ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Fonction> listFonctions(int position, int nbrFonctions)
	{
		
		Query req=em.createQuery("select fon from Fonction fon");
		req.setFirstResult(position);
		req.setMaxResults(nbrFonctions);
		return req.getResultList();
	}
	

	
    //Gestion des Accompagnateurs

	@Override
	public Long ajouterAccompagnateur(Accompagnateur accompagnateur) 
	{
		
		    em.persist(accompagnateur);
			
			return accompagnateur.getIdPerson();
	}

	@Override
	public List<Accompagnateur> listAccompagnateurs(int position,int nbrAccompagnateurs) 
	{
		
		Query req=em.createQuery("select accomp from Accompagnateur accomp order by accomp.idPerson desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrAccompagnateurs);
		return req.getResultList();
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
	
	@Override
	public long getNombreAccompagnateurs()
	{
		Query req=em.createQuery("select count(acc) from Accompagnateur acc ");
		return (Long)req.getResultList().get(0);
	}
	
	
	
	
	//Gestion des Inscriptions
	

	@Override
	public Long ajouterInscription(Inscription inscription)
	{
		
		 em.persist(inscription);
			
		 return inscription.getIdinscription();
	}

	@Override
	public List<Inscription> listInscriptions()
	{
		
        Query req=em.createQuery("select ins from Inscription ins");
		
		return req.getResultList();
	}

	@Override
	public Inscription getInscription(Long idInscription)
	{
		
		return em.find(Inscription.class, idInscription);
	}

	@Override
	public void supprimerInscriptions(Long idInscription) 
	{
		Inscription insc=em.find(Inscription.class, idInscription);
		em.remove(insc);
		
	}

	@Override
	public void modifierInscriptions(Inscription inscription)
	{
		em.merge(inscription);
		
	}

	@Override
	public List<Inscription> getInscriptionByEnfantbyClasse(Long idEnfant,Long idClasse)
	{
		
		 Query req=em.createQuery("select ins from Inscription as ins, ins.Enfant as enf, ins.Classe as cl where enf.ID_ENFANT=:x and cl.idClass=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idClasse);	
		 return req.getResultList();
	}

	@Override
	public List<Enfant> getEnfantByClassebyInscription(Long idClasse,Long idInscription) 
	{
	
		Query req=em.createQuery("select enf from Enfant as enf, enf.Classe as cla, enf.Inscription as ins where cla.idClass=:x and ins.idinscription=:y");
		 req.setParameter("x", idClasse);	
		 req.setParameter("y", idInscription);	
		 return req.getResultList();
	}

	@Override
	public List<Classe> getClassesByEnfantbyInscription(Long idEnfant,Long idInscription)
	{
		
		Query req=em.createQuery("select cl from Classe as cl, cl.Enfant as enf, cl.Inscription as ins where enf.ID_ENFANT=:x and ins.idinscription=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idInscription);	
		 return req.getResultList();
	}

	@Override
	public void ajouterInscriptionsPourEnfantPourClasse(Long idInscription,Long idEnfant,Long idclass)
	{
		Inscription ins=em.find(Inscription.class, idInscription);
		Enfant e=em.find(Enfant.class, idEnfant);
		Classe cl=em.find(Classe.class, idclass);
		ins.getEnfants().add(e);
		ins.getClasses().add(cl);
		e.getInscriptions().add(ins);
		e.getClasses().add(cl);
		cl.getInscriptions().add(ins);
		cl.getEnfants().add(e);
		
	}

	@Override
	public void ajouterEnfantsPourInscriptionPourClasse(Long idEnfant,Long idInscription,Long idclass)
	{
		
		Enfant e=em.find(Enfant.class, idEnfant);
		Inscription ins=em.find(Inscription.class, idInscription);
		Classe cl=em.find(Classe.class, idclass);
		e.getInscriptions().add(ins);
		e.getClasses().add(cl);
		ins.getEnfants().add(e);
		ins.getClasses().add(cl);
		cl.getInscriptions().add(ins);
		cl.getEnfants().add(e);
		
	}
	
	@Override
	public void ajouterClassesPourInscriptionPourEnfant(Long idclass,Long idInscription,Long idEnfant )
	{
		
		Classe cl=em.find(Classe.class, idclass);
		Inscription ins=em.find(Inscription.class, idInscription);
		Enfant e=em.find(Enfant.class, idEnfant);
		cl.getInscriptions().add(ins);
		cl.getEnfants().add(e);
		ins.getEnfants().add(e);
		ins.getClasses().add(cl);
		e.getInscriptions().add(ins);
		e.getClasses().add(cl);
		
	}
	
	
	@Override
	public List<Clubs> clubsParInscription(Long idInscription)
	{
		
		Query req=em.createQuery("select cl from Clubs cl join cl.Inscription ins where ins.idinscription=:x");
		req.setParameter("x", idInscription);	
		return req.getResultList();
	}
	@Override
	public void ajouterPlanningHorrairsPourInscription(Long idPlanningHorraires, Long idInscription)
	{
		
		PlanningHorraires pl=em.find(PlanningHorraires.class, idPlanningHorraires);
		Inscription ins=em.find(Inscription.class, idInscription);
		pl.getInscriptions().add(ins);
		ins.getPlanningHorraires().add(pl);
	}
	

	@Override
	public long getNombreInscriptions() {
		
		Query req=em.createQuery("select count(ins) from Inscription ins ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Inscription> listInscriptions(int position, int nbrInscriptions) {
		
		Query req=em.createQuery("select ins from Inscription ins order by ins.idinscription desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrInscriptions);
		return req.getResultList();
	}

	

	
	
	 //Gestion des Parents

	@Override
	public Long ajouterParent(Parent parent)
	{
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
	
	
	@Override
	public List<Parent> listParents(int position, int nbrParents) 
	{
		
		Query req=em.createQuery("select par from Parent par order by par.idPerson desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrParents);
		return req.getResultList();
	}

	@Override
	public long getNombreParents() 
	{


		Query req=em.createQuery("select count(par) from Parent par ");
		return (Long)req.getResultList().get(0);
	}
	
	//Gestion des Consultations

	@Override
	public Long ajouterConsultation(Consultation consultation) 
	{
		
        em.persist(consultation);
		
		return consultation.getIdConsultation();
	}

	@Override
	public List<Consultation> listConsultations() 
	{
		
        Query req=em.createQuery("select cons from Consultation cons");
		
		return req.getResultList();
	}

	@Override
	public Consultation getConsultation(Long idConsultation) 
	{
		
		return em.find(Consultation.class, idConsultation);
	}

	@Override
	public void supprimerConsultations(Long idConsultation) 
	{
		Consultation cons=em.find(Consultation.class, idConsultation);
		em.remove(cons);
		
	}

	@Override
	public void modifierConsultations(Consultation consultation)
    {
		em.merge(consultation);
		
	}

	@Override
	public List<Consultation> getConsultationsByEnfantbyEquipeSanitaire(Long idEnfant, Long idEquipeSanitaire) 
	{
		
		 Query req=em.createQuery("select cons from Consultation as cons, cons.Enfant as enf, cons.EquipeSanitaire as eqSa where enf.ID_ENFANT=:x and eqSa.ID_EQ_SAN=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idEquipeSanitaire);	
		 return req.getResultList();
	}

	@Override
	public List<Enfant> getEnfantByEqSanitaireyConsultation(Long idEquipeSanitaire, Long idConsultation) 
	{
		
		 Query req=em.createQuery("select enf from Enfant as enf, enf.EquipeSanitaire as eqSan, enf.Consultation as cons where eqSan.ID_EQ_SAN=:x and cons.idConsultation=:y");
		 req.setParameter("x", idEquipeSanitaire);	
		 req.setParameter("y", idConsultation);	
		 return req.getResultList();
	}

	@Override
	public List<EquipeSanitaire> getEquipeSanitairesByEnfantbyConsultation(Long idEnfant, Long idConsultation) 
	{
		
		 Query req=em.createQuery("select eqSan from EquipeSanitaire as eqSan, eqSan.Enfant as enf, eqSan.Consultation as cons where enf.ID_ENFANT=:x and cons.idConsultation=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idConsultation);	
		 return req.getResultList();
	}

	@Override
	public void ajouterConsultationsPourEnfantPourEquipeSanitaire(Long idConsultation, Long idEnfant, Long idEquipeSanitaire) 
	{
		Consultation con=em.find(Consultation.class, idConsultation);
		Enfant e=em.find(Enfant.class, idEnfant);
		EquipeSanitaire eqSan=em.find(EquipeSanitaire.class, idEquipeSanitaire);
		con.getEnfants().add(e);
		con.getEquipeSanitaires().add(eqSan);
		e.getConsultations().add(con);
		e.getEquipeSanitaires().add(eqSan);
		eqSan.getConsultations().add(con);
		eqSan.getEnfants().add(e);
		
		
		
	}
	

	@Override
	public void ajouterEnfantsPourConsultationPourEquipeSanitaire(Long idEnfant, Long idConsultation, Long idEquipeSanitaire) 
	{
		
		Enfant e=em.find(Enfant.class, idEnfant);
		Consultation con=em.find(Consultation.class, idConsultation);
		EquipeSanitaire eqSan=em.find(EquipeSanitaire.class, idEquipeSanitaire);
		e.getConsultations().add(con);
		e.getEquipeSanitaires().add(eqSan);
		con.getEnfants().add(e);
		con.getEquipeSanitaires().add(eqSan);
		eqSan.getConsultations().add(con);
		eqSan.getEnfants().add(e);
		
	}

	@Override
	public void ajouterEquipeSanitairesPourConsultationPourEnfant(Long idEquipeSanitaire, Long idConsultation, Long idEnfant) 
	{
		
		
		EquipeSanitaire eqSan=em.find(EquipeSanitaire.class, idEquipeSanitaire);
		Consultation con=em.find(Consultation.class, idConsultation);
		Enfant e=em.find(Enfant.class, idEnfant);
		eqSan.getConsultations().add(con);
		eqSan.getEnfants().add(e);
		con.getEnfants().add(e);
		con.getEquipeSanitaires().add(eqSan);
		e.getConsultations().add(con);
		e.getEquipeSanitaires().add(eqSan);
	}
	
	
	@Override
	public long getNombreConsultations() {
		
		Query req=em.createQuery("select count(cons) from Consultation cons ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Consultation> listConsultations(int position,int nbrConsultations) {
		
		Query req=em.createQuery("select cons from Consultation cons order by cons.idConsultation desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrConsultations);
		return req.getResultList();
	}
	
	//Gestion des Evennements

	@Override
	public Long ajouterEvennement(Evennement evennement) 
	{
		
        em.persist(evennement);
		
		return evennement.getIdEvenement();
	}

	@Override
	public List<Evennement> listEvennements()
	{
		
       Query req=em.createQuery("select even from Evennement even");
		
		return req.getResultList();
	}

	@Override
	public List<Evennement> evennementParNom(String nom) 
	{
		
		Query req=em.createQuery("select even from Evennement even where even.nom like :x ");
		req.setParameter("x", "%"+nom+"%"); 
		return req.getResultList();
	}

	@Override
	public Evennement getEvennement(Long idEvennement) 
	{
	
		return em.find(Evennement.class, idEvennement);
	}

	@Override
	public void supprimerEvennements(Long idEvennement) 
	{
		

		Evennement even=em.find(Evennement.class, idEvennement);
		em.remove(even);
	}

	@Override
	public void modifierEvennements(Evennement evennement)
	{
		
		em.merge(evennement);
		
	}
	
	@Override
	public long getNombreEvennements()
	{
		
		Query req=em.createQuery("select count(even) from Evennement even ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Evennement> listEvennements(int position, int nbrEvennements) 
	{
		
		Query req=em.createQuery("select even from Evennement even");
		req.setFirstResult(position);
		req.setMaxResults(nbrEvennements);
		return req.getResultList();
	}

	@Override
	public List<Enfant> getEnfantsByEvennement(Long idEvennement) 
	{
		
		Query req=em.createQuery("select enf from Enfant enf join enf.Evennement even where even.idEvenement=:x");
		req.setParameter("x", idEvennement);	
		return req.getResultList();
	}

	@Override
	public void ajouterEnfantsPourEvennement(Long idEnfant, Long idEvennement) 
	{
		Enfant e=em.find(Enfant.class, idEnfant);
		Evennement even=em.find(Evennement.class, idEvennement);
		e.getEvenements().add(even);
		even.getEnfants().add(e);
		
	}
	
	//Gestion des Enfants

	@Override
	public Long ajouterEnfant(Enfant enfant)
	{
	
		
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
	public List<Enfant> enfantSituationParental() 
	{
		
        Query req=em.createQuery("select enf from Enfant enf where enf.situationParentale=true");
		
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
	public List<Evennement> getEvennementsByEnfant(Long idEnfant)
	{
		
		Query req=em.createQuery("select even from Evennement even join even.Enfant enf where enf.ID_ENFANT=:x");
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
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant)
	{
		
		Accompagnateur acc=em.find(Accompagnateur.class, idAccompagnateur);
		Enfant e=em.find(Enfant.class, idEnfant);
		acc.getEnfants().add(e);
		e.getAccompagnateurs().add(acc);
	}
	
	@Override
	public void ajouterEvennementsPourEnfant(Long idEvennement, Long idEnfant) 
	{
		Evennement even=em.find(Evennement.class, idEvennement);
		Enfant e=em.find(Enfant.class, idEnfant);
		even.getEnfants().add(e);
		e.getEvenements().add(even);
		
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
	public List<Enfant> getEnfantsByInscriptionByClasse(Long idInscription,Long idClasse)
	{
		

		 Query req=em.createQuery("select enf from Enfant as enf, enf.Inscription as ins, enf.Classe as cl where ins.ID_INSCRIPTION=:x and cl.ID_CLASSE=:y");
		 req.setParameter("x", idInscription);	
		 req.setParameter("y", idClasse);	
		 return req.getResultList();
	}

	@Override
	public List<Enfant> getEnfantsByConsultationByEquipeSanitaire(Long idConsultation, Long idEquipeSanitaire) 
	{
		
		 Query req=em.createQuery("select enf from Enfant as enf, enf.Consultation as cons, enf.EquipeSanitaire as eqSan where cons.idinscription=:x and eqSan.ID_EQ_SAN=:y");
		 req.setParameter("x", idConsultation);	
		 req.setParameter("y", idEquipeSanitaire);	
		 return req.getResultList();
	}

	@Override
	public List<Classe> getClassesByInscriptionByEnfant(Long idInscription, Long idEnfant) 
	{
		
		 Query req=em.createQuery("select cl from Classe as cl, cl.Inscription as ins, cl.Enfant as enf where ins.idinscription=:x and enf.ID_ENFANT=:y");
		 req.setParameter("x", idInscription);	
		 req.setParameter("y", idEnfant);	
		 return req.getResultList();
	}

	@Override
	public List<EquipeSanitaire> getEquipeSanitaireByConsultationByEnfant(Long idConsultation, Long idEnfant) 
	{
		
		 Query req=em.createQuery("select eqSan from EquipeSanitaire as eqSan, eqSan.Consultation as cons, eqSan.Enfant as enf where cons.idConsultation=:x and enf.ID_ENFANT=:y");
		 req.setParameter("x", idConsultation);	
		 req.setParameter("y", idEnfant);	
		 return req.getResultList();
	}

	@Override
	public List<Inscription> getInscriptionByEnfantByClasse(Long idEnfant,Long idClasse)
	{
		
		 Query req=em.createQuery("select ins from Inscription as ins, ins.Enfant as enf, ins.Classe as cl where enf.ID_ENFANT=:x and cl.idClass=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idClasse);	
		 return req.getResultList();
	

	}

	@Override
	public List<Consultation> getConsultationByEnfantByEquipeSanitaire(Long idEnfant, Long idEquipeSanitaire) 
	{
		
		 Query req=em.createQuery("select cons from Consultation as cons, cons.Enfant as enf, cons.EquipeSanitaire as eqSan where enf.ID_ENFANT=:x and eqSan.ID_EQ_SAN=:y");
		 req.setParameter("x", idEnfant);	
		 req.setParameter("y", idEquipeSanitaire);	
		 return req.getResultList();
	}

	@Override
	public Enfant enregistrerEnfant(Inscription a, Parent p) 
	{
	
		return null;
	}
	
	
	@Override
	public List<Enfant> listEnfants(int position, int nbrEnfants) 
	{
		
		Query req=em.createQuery("select enf from Enfant enf order by enf.idPerson desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrEnfants);
		return req.getResultList();
	}

	@Override
	public long getNombreEnfants()
   {
		
		
		Query req=em.createQuery("select count(enf) from Enfant enf ");
		return (Long)req.getResultList().get(0);
	}


	

	
 

	//Gestion des Fournisseurs
	@Override
	public Long ajouterFournisseur(Fournisseur fournisseur) 
	{
	    em.persist(fournisseur);
 
	     return fournisseur.getIdPerson();
	}

	@Override
	public List<Fournisseur> listFournisseurs() 
	{
		
        Query req=em.createQuery("select four from Fournisseur four");
		
		return req.getResultList();
	}

	@Override
	public List<Fournisseur> fournisseurParNom(String nom) 
	{
		

		Query req=em.createQuery("select four Fournisseur four where four.nom like :x or four.prenom :x");
		req.setParameter("x", "%"+nom+"%"); 
		return req.getResultList();
	}

	@Override
	public Fournisseur getFournisseur(Long idFournisseur) 
	{
		

		return em.find(Fournisseur.class, idFournisseur);
	}

	@Override
	public void supprimerFournisseur(Long idFournisseur) 
	{
		Fournisseur four=em.find(Fournisseur.class, idFournisseur);
		em.remove(four);
		
	}

	@Override
	public void modifierFournisseur(Fournisseur fournisseur) 
	{
		em.merge(fournisseur);
		
	}

	@Override
	public List<Materiels> getMaterielsByFournisseur(Long idFournisseur) 
	{
		
		Query req=em.createQuery("select mat from Materiels mat join mat.Fournisseur four where four.ID_FOURNISSEUR=:x");
		req.setParameter("x", idFournisseur);	
		return req.getResultList();
	}

	@Override
	public void ajouterMaterielsPourFournisseur(Long idMateriels,Long idFournisseur) 
	{
	
		Materiels m=em.find(Materiels.class, idMateriels);
		Fournisseur four=em.find(Fournisseur.class, idFournisseur);
		m.getFournisseurs().add(four);
		four.getMateriels().add(m);
		
	}
	
	@Override
	public long getNombreFournisseurs()
	{
		
		Query req=em.createQuery("select count(four) from Fournisseur four ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Fournisseur> listFournisseurs(int position, int nbrFournisseurs) 
	{
		
		Query req=em.createQuery("select four from Fournisseur four order by four.idPerson desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrFournisseurs);
		return req.getResultList();
	}
	
	//Gestion des Materiels

	@Override
	public Long ajouterMateriels(Materiels materiels, Long idTypeMateriels,Long idStock)
	{
		
		TypeMateriels typ=em.find(TypeMateriels.class, idTypeMateriels);
		Stock st=em.find(Stock.class, idStock);
		
		materiels.setTypeMateriel(typ);
		materiels.setStock(st);
		
		em.persist(materiels); 
		
		return materiels.getIdMateriel();
	}

	@Override
	public List<Materiels> listMateriels() 
	{
		
        Query req=em.createQuery("select mat from Materiels mat");
		
		return req.getResultList();
	}

	@Override
	public List<Materiels> materielsParDesignation(String designation) 
	{
		
		Query req=em.createQuery("select mat from Materiels matt where mat.designation like :x ");
		req.setParameter("x", "%"+designation+"%");
		return req.getResultList();
	}

	@Override
	public Materiels getMateriels(Long idMateriels) 
	{
		
		return em.find(Materiels.class, idMateriels);
	}

	@Override
	public void supprimerMateriels(Long idMateriels)
	{
		Materiels mat=em.find(Materiels.class, idMateriels);
		em.remove(mat);
		
	}

	@Override
	public void modifierMateriels(Materiels materiels)
	{
		
		em.merge(materiels);
		
	}

	@Override
	public List<Fournisseur> getFournisseurByMateriels(Long idMateriels) 
	{
		
		Query req=em.createQuery("select four from Fournisseur four join four.Materiels mat where mat.ID_MATERIEL=:x");
		req.setParameter("x", idMateriels);	
		return req.getResultList();
	}

	@Override
	public List<Equipe> getEquipeByMateriels(Long idMateriels) 
	{
		
		Query req=em.createQuery("select eq from Equipe eq join eq.Materiels mat where mat.idMateriel=:x");
		req.setParameter("x", idMateriels);	
		return req.getResultList();
	}
	@Override
	public List<Equipe> getEquipeSanitaireByMateriels(Long idMateriels) 
	{
		
		Query req=em.createQuery("select eqSan from EquipeSanitaire eqSan join eqSan.Materiels mat where mat.idMateriel=:x");
		req.setParameter("x", idMateriels);	
		return req.getResultList();
	}
	@Override
	public List<Equipe> getEquipeEducatifByMateriels(Long idMateriels) 
	{
		
		Query req=em.createQuery("select eqEd from EquipeEducatif eqEd join eqEd.Materiels mat where mat.idMateriel=:x");
		req.setParameter("x", idMateriels);	
		return req.getResultList();
	}

	@Override
	public void ajouterFournisseurPourMateriels(Long idFournisseur,Long idMateriels) 
	{
		Fournisseur f=em.find(Fournisseur.class, idFournisseur);
		Materiels mat=em.find(Materiels.class, idMateriels);
		f.getMateriels().add(mat);
		mat.getFournisseurs().add(f);
		
	}

	

	@Override
	public void ajouterEquipePourMateriels(Long idEquipe, Long idMateriels)
	{
		Equipe eq=em.find(Equipe.class, idEquipe);
		Materiels mat=em.find(Materiels.class, idMateriels);
		eq.getMateriels().add(mat);
		mat.getEquipes().add(eq);
		
	}

	

	@Override
	public List<Materiels> materielsParFournisseur(Long idFournisseur) 
	{
		
		 Query req=em.createQuery("select mat from Materiels mat join mat.Fournisseur four where four.ID_FOURNISSEUR=:x");
		 req.setParameter("x", idFournisseur);	
		 return req.getResultList();
	}

	@Override
	public List<Materiels> materielsParEquipe(Long idEquipe)
	{
		 Query req=em.createQuery("select mat from Materiels mat join mat.Equipe eq where eq.ID_EQUIPE=:x");
		 req.setParameter("x", idEquipe);	
		 return req.getResultList();
		
	}

	@Override
	public List<EquipeSanitaire> materielsParEquipeSanitaire(Long idEquipeSanitaire)
	{
		
		Query req=em.createQuery("select mat from Materiels mat join mat.EquipeSanitaire eqSan where eqSan.ID_EQ_SAN=:x");
		 req.setParameter("x", idEquipeSanitaire);	
		 return req.getResultList();
	}

	@Override
	public List<EquipeEducatif> materielsParEquipeEducatif(Long idEquipeEducatif)
	{
		
		Query req=em.createQuery("select mat from Materiels mat join mat.EquipeEducatif eqEd where eqEd.ID_EQ_EDU=:x");
		 req.setParameter("x", idEquipeEducatif);	
		 return req.getResultList();
	}
	
	@Override
	public long getNombreMateriels() {
		
		Query req=em.createQuery("select count(mat) from Materiels mat ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<Materiels> listMateriels(int position, int nbrMateriels) {
		
		Query req=em.createQuery("select mat from Materiels mat order by mat.idMateriel desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrMateriels);
		return req.getResultList();
	}
	

	
	//Gestion des Types Materiels
	
	@Override
	public Long ajouterTypeMateriel(TypeMateriels typeMateriels) 
	{
		
		em.persist(typeMateriels);
		
		return typeMateriels.getIdTypeMateriel();

	}

	@Override
	public List<TypeMateriels> listTypeMateriels() 
	{
		
        Query req=em.createQuery("select typ from TypeMateriels typ");
		
		return req.getResultList();
	}

	@Override
	public List<TypeMateriels> typeMaterielsParLabelle(String labelle) 
	{
		
		Query req=em.createQuery("select typ from TypeMateriels typ where typ.labelle like :x");
		req.setParameter("x", "%"+labelle+"%"); 
		return req.getResultList();
	}

	@Override
	public TypeMateriels getTypeMateriels(Long idTypeMateriels) 
	{
		
		return em.find(TypeMateriels.class,idTypeMateriels);
	}

	@Override
	public void supprimerTypeMateriels(Long idTypeMateriels)
	{
		TypeMateriels ty=em.find(TypeMateriels.class, idTypeMateriels);
		em.remove(ty);
		
	}

	@Override
	public void modifierTypeMateriels(TypeMateriels typeMateriels)
	{
		em.merge(typeMateriels);
		
	}
	
	@Override
	public long getNombreTypesMateriels() {
		
		Query req=em.createQuery("select count(typM) from TypeMateriels typM ");
		return (Long)req.getResultList().get(0);
	}

	@Override
	public List<TypeMateriels> listTypeMateriels(int position,int nbrTypesMateriels) {
		
		Query req=em.createQuery("select typM from TypeMateriels typM order by typM.idTypeMateriel desc");
		req.setFirstResult(position);
		req.setMaxResults(nbrTypesMateriels);
		return req.getResultList();
	}
	
	

	

	//Gestion des Stocks
	
	@Override
	public Long ajouterStock(Stock stock) 
	{
	    em.persist(stock);
		
		return stock.getIdStock();
	}

	@Override
	public List<Stock> listStock() 
	{
		
       Query req=em.createQuery("select st from Stock st");
		
		return req.getResultList();
	}

	@Override
	public Stock getStock(Long idStock)
	{
		return em.find(Stock.class, idStock);
	}

	@Override
	public void supprimerStock(Long idStock) 
	{
		Stock sto=em.find(Stock.class, idStock);
		em.remove(sto);
		
	}

	@Override
	public void modifierStock(Stock stock)
	{
		em.merge(stock);
		
	}

	@Override
	public long getNombreStocks() {
		
		Query req=em.createQuery("select count(stoc) from Stock stoc ");
		return (Long)req.getResultList().get(0);
	}
	

	@Override
	public List<Stock> listStock(int position, int nbrStocks) {
		
		Query req=em.createQuery("select stoc from Stock stoc order by stoc.idStock desc ");
		req.setFirstResult(position);
		req.setMaxResults(nbrStocks);
		return req.getResultList();
	}

	
	
}
