package org.gestion.cr;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
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
import org.gestion.cr.metier.IAdminMetier;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
	
	
	@Test
	public void test3() 
	{
		//Test pour la configuration de la base des données
		try
		     {
			
		        ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		        
		       
		       IAdminMetier metier=(IAdminMetier) context.getBean("metier");
		         
		        
		       //Tester Fonctions
		        
		       //Tester l'ajout    
			   List<Fonction> listFonction1=metier.listFonctions();
			   metier.ajouterFonction(new Fonction("Assistante Maternelle"));
			   metier.ajouterFonction(new Fonction("Educatrice"));
			   metier.ajouterFonction(new Fonction("Pediatre"));
			   metier.ajouterFonction(new Fonction("Infermier(e)"));
			   metier.ajouterFonction(new Fonction("Femme de Ménage"));
			   metier.ajouterFonction(new Fonction("Gardien"));
			   List<Fonction> listFonction12=metier.listFonctions();
			    
			   assertTrue(listFonction1.size()+6==listFonction12.size());
			   
			  
               //Tester les Accompagnateurs
			   
			   //Tester l'ajout     
			   List<Accompagnateur> listAccompagnateur1=metier.listAccompagnateurs();
			   metier.ajouterAccompagnateur(new Accompagnateur("Ali", "Ben Salem", null, "", "06925113", "Oncle", "54144604"));
			   metier.ajouterAccompagnateur(new Accompagnateur("Wassim", "Arfeui", null, "", "05678987", "Grand Père", "98676987"));
			   metier.ajouterAccompagnateur(new Accompagnateur("Wiem", "Hamrouni", null, "", "07678952", "Grand Mère", "52768954"));
			   metier.ajouterAccompagnateur(new Accompagnateur("Imen", "Sakly", null, "", "06789543", "baby-sitter", "96755678"));
			   metier.ajouterAccompagnateur(new Accompagnateur("Imen", "Sakly", null, "", "06789543", "baby-sitter", "96755678"));
			   List<Accompagnateur> listAccompagnateur2=metier.listAccompagnateurs();
			        
			   assertTrue(listAccompagnateur1.size()+5==listAccompagnateur2.size());
			   
			   
			   //Tester les planning Horraires
			   
			   //Tester l'ajout 
		       List<PlanningHorraires> listPlanning1=metier.listPlanningHorraires();
		       metier.ajouterPlanningHorraires(new PlanningHorraires("matin:8h-->1h30",40.50 ));
		       metier.ajouterPlanningHorraires(new PlanningHorraires("1h30-->2h30",10.50 ));
		       metier.ajouterPlanningHorraires(new PlanningHorraires("Apres-midi:2h30-->5h",40.50 ));
		       List<PlanningHorraires> listPlanning2=metier.listPlanningHorraires();
		        
		       assertTrue(listPlanning1.size()+3==listPlanning2.size());
		       
		       
		       //Tester les Genres
		       
		       //Tester l'ajout
		       List<Genre> listGenres1=metier.listGenre();
		       metier.ajouterGenre(new Genre("Maman"));
		       metier.ajouterGenre(new Genre("Papa"));
		       List<Genre> listGenres2=metier.listGenre();
		        
		       assertTrue(listGenres1.size()+2==listGenres2.size());
		       
		       
		      //Tester les Annees
		       
		       //Tester l'ajout
		       List<Annee> listAnnee1=metier.listAnnees();
		       metier.ajouterAnnee(new Annee("2011/2012"));
		       metier.ajouterAnnee(new Annee("2012/2013"));
		       metier.ajouterAnnee(new Annee("2013/2014"));
		       metier.ajouterAnnee(new Annee("2014/2015"));
		       List<Annee> listAnnee2=metier.listAnnees();
		        
		       assertTrue(listAnnee1.size()+4==listAnnee2.size());
		       
		       //Tester les Parents
		       
		       //Tester l'ajout
		       List<Parent> listParent1=metier.listParents();
		       metier.ajouterParent(new Parent("Fatma", "Ben Hamadi", null, "", "05643567", "Maitre", "Monastir 5000", "73535466", "54367890", "BenHamadi_Fatma@yahoo.fr", "Ecole Execellence Monastir", "73122456", "", ""), 1L);
		       metier.ajouterParent(new Parent("Yosra", "Sakly", null, "", "05643323", "Ingenieur", "Khniss 5011", "73535321", "54321880", "Sakly.Yosra@gmail.com", "Softplus", "73122341", "", ""), 1L);
		       metier.ajouterParent(new Parent("Ahmed", "Hamadi", null, "", "07654882", "Chef Service", "Sousse  4027", "73543122", "98766541", "Hamadi_Ahmed@hotmail.fr", "SFR", "7310344", "", ""), 2L);
		       metier.ajouterParent(new Parent("wajdi", "Fkih", null, "", "05112455", "Commerçant", "Tunis 1023", "73534600", "97344567", "Fkih_Wajdi@gmail.com", "", "73900123", "", ""), 2L);
		       metier.ajouterParent(new Parent("Jamila", "Hadri", null, "", "05200800", "Professeur", "Moknin 5012", "73532900", "97200302", "Hadri_Jamila@hotmail.fr", "Collège Tahar Sfar Moknin", "73344201", "", ""), 1L);
		       metier.ajouterParent(new Parent("Ferdaws", "Jammali", null, "", "06700102", "Medecin", "Monastir 5000", "73534299", "98300111", "Jammali_Ferdaws@gmail.com", "Hopital Fattouma Bourguiba Monastir", "73122456", "", ""), 1L);
		       List<Parent> listParent2=metier.listParents();
		       
		       assertTrue(listParent1.size()+6==listParent2.size());
		       
		       
		       //tester les Nom Classes
		       
		       //Tester l'ajout
		       List<NomClass> listNomClasse1=metier.listNomClass();
		       metier.ajouterNomClass(new NomClass("Barem"));
		       metier.ajouterNomClass(new NomClass("Sanefer"));
		       metier.ajouterNomClass(new NomClass("Sighar"));
		       metier.ajouterNomClass(new NomClass("Kibar"));
		       metier.ajouterNomClass(new NomClass("Coccinelle"));
		       metier.ajouterNomClass(new NomClass("Mon Bébé"));
		       List<NomClass> listNomClasse2=metier.listNomClass();
		       
		       assertTrue(listNomClasse1.size()+6==listNomClasse2.size());
		       
		       
		       //Tester les Creches
		       
		       //Tester l'ajout
		       List<Creche> listCreche1=metier.listCreches();
		       metier.ajouterCreche(new Creche("La Belle Enfance", "Monastir 5000", "La Belle Enfance", "Khniss", "73534400"));
		       metier.ajouterCreche(new Creche("Excellence", "Sousse 4027", "Excellence", "Hammam Sousse", "73654899"));
		       metier.ajouterCreche(new Creche("Mon Petit Enfant", "Tunis 1023", "Mon Petit Enfant", "Ariena", "71234778"));
		       metier.ajouterCreche(new Creche("Mon Meilleur Enfant", "Kairouan 3100 ", "Mon Meilleur Enfant", "Sbikha", "72399111"));
		       List<Creche> listCreche2=metier.listCreches();
		       
		       assertTrue(listCreche1.size()+4==listCreche2.size());
		       
		      
              //tester les Equipes Sanitaires
		       
		      //Tester l'ajout
		      List<EquipeSanitaire> listEqSanitaire1=metier.listEquipeSanitaires();
		      metier.ajouterEquipeSanitaire(new EquipeSanitaire("Mohamed", "Herchena", null, "", "1980-06-20", "Monastir", "Homme", "Monastir 5011", "", "") , 3L);
		      metier.ajouterEquipeSanitaire(new EquipeSanitaire("Dalila", "Chouchen", null, "", "1977-01-12", "Sousse", "Femme", "Sousse 4001", "", "") , 4L);
		      List<EquipeSanitaire> listEqSanitaire2=metier.listEquipeSanitaires();
		      
		      assertTrue(listEqSanitaire1.size()+2==listEqSanitaire2.size());
		     
		      
		      //tester les Equipes Techniques
		       
		      //Tester l'ajout
		      List<EquipeTechnique> listEqTechnique1=metier.listEquipeTechniques();
		      metier.ajouterEquipeTechnique(new EquipeTechnique("Atef", "Rokbeni", null, "", "1982-10-04", "Monastir", "Homme", "Monastir 5011", "", ""), 1L, 6L);
		      metier.ajouterEquipeTechnique(new EquipeTechnique("Fatiha", "Mseekni", null, "", "1979-04-24", "Sousse", "Femme", "Monastir 5011", "", ""), 1L, 5L);
              List<EquipeTechnique> listEqTechnique2=metier.listEquipeTechniques();
		      
		      assertTrue(listEqTechnique1.size()+2==listEqTechnique2.size());  
		      

			  //Tester les Equipes Educatifs
			       
			  //Tester l'ajout
		      List<EquipeEducatif> listEqEducatif1=metier.listEquipeEducatif();
		      metier.ajouterEquipeEducatif(new EquipeEducatif("Zohra", "Jerbi", null, "", "1979-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 1L);
		      metier.ajouterEquipeEducatif(new EquipeEducatif("Nadia", "Seddik", null, "", "1980-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 1L);
		      metier.ajouterEquipeEducatif(new EquipeEducatif("Afifa", "Touzi", null, "", "1983-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 2L);
		      metier.ajouterEquipeEducatif(new EquipeEducatif("Noura", "Arfeui", null, "", "1986-10-04", "Monastir", "Femme", "Monastir 5011", "", ""), 2L);
		      List<EquipeEducatif> listEqEducatif2=metier.listEquipeEducatif();
		      
		      assertTrue(listEqEducatif1.size()+4==listEqEducatif2.size());
		      
		     
		      //Tester les Consultations
		      
		      //Tester l'ajout
		      List<Consultation> listConsultation1=metier.listConsultations();
		      metier.ajouterConsultation(new Consultation(new Date(), (float)1.44, (float) 44.4, "maigre"));
		      metier.ajouterConsultation(new Consultation(new Date(), (float)1.50, (float) 30.4, ""));
		      List<Consultation> listConsultation2=metier.listConsultations();
		      
		      assertTrue(listConsultation1.size()+2==listConsultation2.size());
		      
		      
		      //Tester les Classes
		      
			  //Tester l'ajout
			  List<Classe> listClass1=metier.listClasse();
			  metier.ajouterClasse(new Classe("Classe1", 30) ,1L, 1L);
			  List<Classe> listClass2=metier.listClasse();
			      
			  assertTrue(listClass1.size()+1==listClass2.size());
			  
			  
			  //Tester les Evennements
			  
			  //Tester l'ajout
			  List<Evennement> listEvennement1=metier.listEvennements();
			  metier.ajouterEvennement(new Evennement("Evenement1", "fete du maman", "", 15.0,new Date() ));
			  List<Evennement> listEvennement2=metier.listEvennements();
			  
			  assertTrue(listEvennement1.size()+1==listEvennement2.size());
			  
			  
			   //Tester les Enfants
		       
		       //Tester l'ajout
		      
		       List<Enfant> listEnfant1=metier.listEnfants();
		       metier.ajouterEnfant(new Enfant("Fedi", "Sakly", null, "", "Homme", "03-07-2013", "Monastir", "Arabe", "Allergie aux Proteines ", true, new Date(), true, true, true, "Mohamed Farhet", "98765432", 3, 1));
		       List<Enfant> listEnfant2=metier.listEnfants();
		       
		       assertTrue(listEnfant1.size()+1==listEnfant2.size());
		      
			      
			  //Tester les Tarifs
		      
		      //Tester l'ajout
		      List<Tarif> listTarif1=metier.listTarifs();
		      metier.ajouterTarif(new Tarif("150 DT"), 1L,20L);
		      List<Tarif> listTarif2=metier.listTarifs();
		     
		     
		      assertTrue(listTarif1.size()+1==listTarif2.size());
		      
		      
		      //Tester les Menus
		      
		      //Tester l'ajout
		      List<Menus> listMenus1=metier.listMenus();
		      metier.ajouterMenus(new Menus("menus integré", 40.2, "12-->2pm"), 1L);
		      List<Menus> listMenus2=metier.listMenus();
		      
		      assertTrue(listMenus1.size()+1==listMenus2.size());
		      
		      
		      //Tester les Clubs 
		      
		      //Tester l'ajout
		      List<Clubs> listClubs1=metier.listClubs();
		      metier.ajouterClubs(new Clubs("Clubs 1"), 1L);
		      List<Clubs> listClubs2=metier.listClubs();
		      
		      assertTrue(listClubs1.size()+1==listClubs2.size());
		      
		      
		      //Tester les  Categories Clubs
		      
		      //Tester l'ajout
		      List<CategorieClub> listCategorieClubs1=metier.listCategorieClubs();
		      metier.ajouterCategorieClub(new CategorieClub("Club Musique", 30.50, "2014-03-05"), 1L);
		      List<CategorieClub> listCategorieClubs2=metier.listCategorieClubs();
		      
		      assertTrue(listClubs1.size()+1==listClubs2.size());
		  
		          
		     }    
		catch(Exception e)
		     {
		      assertTrue(e.getMessage(),false);
	         }

    }
}