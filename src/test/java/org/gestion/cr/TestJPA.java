package org.gestion.cr;

import static org.junit.Assert.assertTrue;


import java.util.Date;
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
import org.gestion.cr.metier.IAdminMetier;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Test
	public void test15() 
	{
		//Test pour la configuration de la base des données
		try
		     {
			
		        ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		      
		      
		        IAdminMetier metier=(IAdminMetier) context.getBean("metier");
		         
		        
			       //Tester Fonctions
			        
			       //Tester l'ajout    
			       
				   List<Fonction> listFonction1=metier.listFonctions(0,5);
				   metier.ajouterFonction(new Fonction("Assistante Maternelle"));
				   metier.ajouterFonction(new Fonction("Educatrice"));
				   metier.ajouterFonction(new Fonction("Pediatre"));
				   metier.ajouterFonction(new Fonction("Infermier(e)"));
				   metier.ajouterFonction(new Fonction("Animatrice"));
				   List<Fonction> listFonction12=metier.listFonctions(0, 5);
				    
				   assertTrue(listFonction1.size()+5==listFonction12.size());
				   
				  
	               //Tester les Accompagnateurs
				   
				   //Tester l'ajout  
				   
				   List<Accompagnateur> listAccompagnateur1=metier.listAccompagnateurs(0,5);
				   metier.ajouterAccompagnateur(new Accompagnateur("Ali", "Ben Salem", null, "", "06925113", "Oncle", "54144604"));
				   metier.ajouterAccompagnateur(new Accompagnateur("Wassim", "Arfeui", null, "", "05678987", "Grand Père", "98676987"));
				   metier.ajouterAccompagnateur(new Accompagnateur("Wiem", "Hamrouni", null, "", "07678952", "Grand Mère", "52768954"));
				   metier.ajouterAccompagnateur(new Accompagnateur("Imen", "Sakly", null, "", "06789543", "baby-sitter", "96755678"));
				   metier.ajouterAccompagnateur(new Accompagnateur("Imen", "Sakly", null, "", "06789543", "baby-sitter", "96755678"));
				   List<Accompagnateur> listAccompagnateur2=metier.listAccompagnateurs(0,5);
				        
				   assertTrue(listAccompagnateur1.size()+5==listAccompagnateur2.size());			   
				   

				   
	               //Tester les Fournisseurs
				   
				   //Tester l'ajout     
				   List<Fournisseur> listFournisseur1=metier.listFournisseurs();
				   
				   metier.ajouterFournisseur(new Fournisseur("Hedi", "FatHalla", null, "", "05678900", "rue republique Monastir", "73567899", "98006788", "Hadi@gmail.com"));
				   metier.ajouterFournisseur(new Fournisseur("Najib", "Mehrzi", null, "", "07700801", "rue janoub Sousse", "73543399", "98400900", "Najib@yahoo.fr"));
				   metier.ajouterFournisseur(new Fournisseur("Mehdi", "Jobran", null, "", "06678900", "rue Jahfa kourouan", "71300405", "98006788", "Mehdi@gmail.com"));
	               List<Fournisseur> listFournisseurr2=metier.listFournisseurs();
				        
				   assertTrue(listFournisseur1.size()+3==listFournisseurr2.size());
				   
				   
				   
				   
				   //Tester les Types des Materiels
				   
				   //tester l'ajout
				   
				   List<TypeMateriels> listTypeMateriels1=metier.listTypeMateriels();
				   metier.ajouterTypeMateriel(new TypeMateriels("Tableau"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Stylo"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Ordinateur"));
				   metier.ajouterTypeMateriel(new TypeMateriels("stethoscope"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Balance impédancemètre"));
				   metier.ajouterTypeMateriel(new TypeMateriels("Thermomètre "));
				   List<TypeMateriels> listTypeMateriels2=metier.listTypeMateriels();
				   
				   assertTrue(listTypeMateriels1.size()+6==listTypeMateriels2.size());
				   
				   
				   
				   //Teste le stock materiel
				   
				   //Tester l'ajout
				   
				   List<Stock> listStock1=metier.listStock();
				   metier.ajouterStock(new Stock((float) 30.4));
				   metier.ajouterStock(new Stock( (float) 50));
				   metier.ajouterStock(new Stock( (float) 40));
				   List<Stock> listStock2=metier.listStock();
				   
				   assertTrue(listStock1.size()+3==listStock2.size());
				   
				   
				   
				   //Tester les Materiels
				   
				   //Tester l'ajout
				   
				   List<Materiels> listMateriels1=metier.listMateriels();
				   metier.ajouterMateriels(new Materiels("tableau", "", 54.30), 1L, 1L);
				   metier.ajouterMateriels(new Materiels("ordinateur", "", 54.30),2L, 1L);
				   List<Materiels> listMateriels2=metier.listMateriels();
				   
				   assertTrue(listMateriels1.size()+2==listMateriels2.size());
				   
				   
				   
				    //Tester les Equipes Educatifs
			       
				    //Tester l'ajout
				    List<EquipeEducatif> listEqEducatif1=metier.listEquipeEducatif(0,5);
				    metier.ajouterEquipeEducatif(new EquipeEducatif("Zohra", "Jerbi", null, "", "1979-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 1L);
				    metier.ajouterEquipeEducatif(new EquipeEducatif("Nadia", "Seddik", null, "", "1980-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 1L);
				    metier.ajouterEquipeEducatif(new EquipeEducatif("Afifa", "Touzi", null, "", "1983-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 2L);
				    metier.ajouterEquipeEducatif(new EquipeEducatif("Noura", "Arfeui", null, "", "1986-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 2L);
				    List<EquipeEducatif> listEqEducatif2=metier.listEquipeEducatif(0,5);
				      
				    assertTrue(listEqEducatif1.size()+4==listEqEducatif2.size());
				    
				    
				    
				    //Tester les Equipes 
				       
				    //Tester l'ajout
				    List<Equipe> listEquip1=metier.listEquipes(0,5);
				    metier.ajouterEquipe(new  Equipe("****", "**", null, "*****", "*****", "****", "****", "********", "****", "***"));
				    
				    List<Equipe> listEquip2=metier.listEquipes(0,5);
				      
				    assertTrue(listEquip1.size()+1==listEquip2.size());
				    
				    
				    //Tester les Personnages 
				       
				    //Tester l'ajout
				    List<Personnage> listPersonnage1=metier.listPersonnage(0,5);
				    
				    metier.ajouterPersonnage(new  Personnage("*****", "*****", null, "*****"));
				    
				    List<Personnage> list2=metier.listPersonnage(0,5);
				      
				  
				   
				    
				    
		            //tester les Equipes Sanitaires
				       
				    //Tester l'ajout
				    List<EquipeSanitaire> listEqSanitaire1=metier.listEquipeSanitaires(0, 5);
				    metier.ajouterEquipeSanitaire(new EquipeSanitaire("Mohamed", "Herchena", null, "", "1980-06-20", "Monastir", "Homme", "Monastir 5011", "", "") , 3L);
				    metier.ajouterEquipeSanitaire(new EquipeSanitaire("Dalila", "Chouchen", null, "", "1977-01-12", "Sousse", "Femme", "Sousse 4001", "", "") , 4L);
				    List<EquipeSanitaire> listEqSanitaire2=metier.listEquipeSanitaires(0, 5);
				      
				    assertTrue(listEqSanitaire1.size()+2==listEqSanitaire2.size());
				     
				     
				     
				    //Tester les Enfants
				       
				    //Tester l'ajout
				      
				    List<Enfant> listEnfant1=metier.listEnfants();
				    metier.ajouterEnfant(new Enfant("Sakly", "Yosra", null, "", "cc", "2012-05-20", "Monastir", "Arabe", "Allergie aux Proteins", "**", true, true, "Mohamed Ferjeni", "98700600", 3, 0));
				    metier.ajouterEnfant(new Enfant("Hammemi", "Hichem", null, "", "cc", "2009-12-03", "Monastir", "Arabe", "Allergie aux chats", "**", true, true, "Sami Zili", "99800600", 4, 1));
				    metier.ajouterEnfant(new Enfant("Nouri", "Hamed", null, "", "cc", "2011-09-30", "Nabeul", "Arabe", "Allergie aux garins", "**", false, true, "Afef Toumi", "9230000600", 0, 2));
	                List<Enfant> listEnfant2=metier.listEnfants();
				       
				    assertTrue(listEnfant1.size()+3==listEnfant2.size());
				    
				    

				   //Tester les Evennements
					  
				   //Tester l'ajout
				    
				   List<Evennement> listEvennement1=metier.listEvennements();
				   metier.ajouterEvennement(new Evennement("Evennement 1", "Fete des Mamans", 15.50, ""));
				   metier.ajouterEvennement(new Evennement("Evennement 2", "Fete de L'independance", 10.0, ""));
				   metier.ajouterEvennement(new Evennement("Evennement 3", "Fete de Fin d'années", 20.50, ""));
				   List<Evennement> listEvennement2=metier.listEvennements();
					  
				   assertTrue(listEvennement1.size()+3==listEvennement2.size());
				      
				   
				  
				   //Tester les parents
				   
				   //Tester l'ajout
				   
				   List<Parent> listParent1=metier.listParents(0,5);
				   metier.ajouterParent(new Parent("Sakly", "Fadhel", null, "", "05600899", "Maitre", "Monastir 5011", "73400900", "98789677", "SaklyFadhel@gmail.com", "Monastir", "73450899", "**", "**", "**"));
				   metier.ajouterParent(new Parent("Hechmi", "Mohamed", null, "", "07600899", "Ingenieur", "Monastir 5011", "73400900", "98789677", "SaklyFadhel@gmail.com", "Monastir", "73450899", "**", "**", "**"));
				   metier.ajouterParent(new Parent("Smida", "Nour", null, "", "06700400", "Medecin", "Monastir 5011", "73400900", "98789677", "SaklyFadhel@gmail.com", "Monastir", "73450899", "**", "**", "**"));
	               List<Parent> listParent2=metier.listParents(0,4);
				   
				   assertTrue(listParent1.size()+3==listParent2.size());
				   
				   
				   
				   //Tester les  Consultations
				   
				   //Tester l'ajout
				   
				   List<Consultation> listConsultation1=metier.listConsultations();
				   metier.ajouterConsultation(new Consultation(new Date(), (float)1.44,  (float)44.8, ""));
				   metier.ajouterConsultation(new Consultation(new Date(), (float)1.50,  (float)39.66, ""));
				   metier.ajouterConsultation(new Consultation(new Date(), (float)1.30,  (float)40.5, ""));
				   List<Consultation> listConsultation2=metier.listConsultations();
				   
				   assertTrue(listConsultation1.size()+3==listConsultation2.size());
				   
				   
				   //Tester les Inscription
				   
				   //Tester l'Ajout
				   
				   List<Inscription> listInscription1=metier.listInscriptions();
				   metier.ajouterInscription(new Inscription("2015/2016", new Date(), 150.50, 10.5));
				   
				   List<Inscription> listInscription2=metier.listInscriptions();
				   
				   assertTrue(listInscription1.size()+1==listInscription2.size());
				   
				   
				   //Tester les Creches
				   
				   //tester l'ajout
				   
				   List<Creche> listCreche1=metier.listCreches(0, 5);
				   metier.ajouterCreche(new Creche("Excellence", "Monastir 5011", "Excellence", "Monastir", "73400908","",null));
				   metier.ajouterCreche(new Creche("Mon Petit Enfant", "Sousse 4300", "Mon Petit Enfant", "Sousse", "734509800","",null));
				   metier.ajouterCreche(new Creche("Coccinelle", "Khniss 5011", "Coccinelle", "Khniss", "73201400","",null));
				   List<Creche> listCreche2=metier.listCreches(0, 5);
				   
				   assertTrue(listCreche1.size()+3==listCreche2.size());
				   
				   
				   //Tester Les Genres de plannings Horraires
				   
				   //Tester l'ajout
				   
				   List<GenrePlanning> listGenrePlanning1=metier.listGenrePlanning();
				   metier.ajouterGenrePlanning(new GenrePlanning("*****"));
				   metier.ajouterGenrePlanning(new GenrePlanning("*****"));
				   List<GenrePlanning> listGenrePlanning2=metier.listGenrePlanning();
				   
				   assertTrue(listGenrePlanning1.size()+2==listGenrePlanning2.size());
				   
				   
				   //Tester les Planning Horraires
				   
				   //Tester l'ajout
				   List<PlanningHorraires> listPlanningHorraires1=metier.listPlanningHorraires();
				   metier.ajouterPlanningHorraires(new PlanningHorraires(50.4), 1L);
				   metier.ajouterPlanningHorraires(new PlanningHorraires(60.4), 2L);
				   metier.ajouterPlanningHorraires(new PlanningHorraires(40.4), 1L);
				   List<PlanningHorraires> listPlanningHorraires2=metier.listPlanningHorraires();
				   
				   assertTrue(listPlanningHorraires1.size()+3==listPlanningHorraires2.size());
				   
				   
				   
				   //Tester les Classes
				   
				   //Tester l'ajout
				   List<Classe> listClasses1=metier.listClasse();
				   metier.ajouterClasse(new Classe("Baraem", 30), 1L);
				   metier.ajouterClasse(new Classe("les petits", 30), 1L);
				   metier.ajouterClasse(new Classe("Les grands", 30), 1L);
				   metier.ajouterClasse(new Classe("les moyens", 30), 1L);
				   List<Classe> listClasses2=metier.listClasse();
				   
				   
				   assertTrue(listClasses1.size()+4==listClasses2.size());
				   
				   
				   //Tester les Categories Clubs
				   
				   //tester l'ajout
				   
				   List<CategorieClub> listCategorieClub1=metier.listCategorieClubs();
				   metier.ajouterCategorieClub(new CategorieClub("Musique", 15.40, "nnn"));
				   metier.ajouterCategorieClub(new CategorieClub("Theatre", 15.40, "nnn"));
				   metier.ajouterCategorieClub(new CategorieClub("Dance", 15.40, "nnnn"));
				   List<CategorieClub> listCategorieClub2=metier.listCategorieClubs();
				   
				   assertTrue(listCategorieClub1.size()+3==listCategorieClub2.size());
				   
				 
				   
				   //Tester les Clubs
				   
				   //Tester l'ajout
				   
				   List<Clubs> listClubs1=metier.listClubs();
				   metier.ajouterClubs(new Clubs("Club 1"), 1L, 1L);
				   metier.ajouterClubs(new Clubs("Club 2"), 2L, 1L);
				   metier.ajouterClubs(new Clubs("Club 3"), 1L, 2L);
				   List<Clubs> listClubs2=metier.listClubs();
				   
				   assertTrue(listClubs1.size()+3==listClubs2.size());
				
		
			   
		     }    
		catch(Exception e)
		     {
		      assertTrue(e.getMessage(),false);
	         }

    }
}