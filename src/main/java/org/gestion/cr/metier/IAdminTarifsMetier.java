package org.gestion.cr.metier;

import javax.swing.event.InternalFrameListener;

import org.gestion.cr.entities.Clubs;
import org.gestion.cr.entities.Menus;
import org.gestion.cr.entities.Tarif;

public interface IAdminTarifsMetier extends InternauteMetier
{
	//Gestion des Tarifs
	public Long ajouterTarif(Tarif tarif,Long idPlanningHorraires,Long idEnfant); 
	public void supprimerTarif(Long idTarif); 
	public void modifierTarif(Tarif tarif); 
	
	//Gestion des Menus
	public Long ajouterMenus(Menus menus,Long idTarif); 
	public void supprimerMenus(Long idMenus); 
	public void modifierMenus(Menus menus); 
	
	//Gestion des Clubs
	public Long ajouterClubs(Clubs clubs,Long idTarif); 
	public void supprimerClubs(Long idClubs); 
	public void modifierClubs(Clubs clubs); 


}
