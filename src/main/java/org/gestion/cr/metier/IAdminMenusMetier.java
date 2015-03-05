package org.gestion.cr.metier;

import org.gestion.cr.entities.Menus;

public interface IAdminMenusMetier extends InternauteMetier
{
	//Gestion des Menus
	public Long ajouterMenus(Menus menus,Long idTarif); 
	public void supprimerMenus(Long idMenus); 
	public void modifierMenus(Menus menus); 

}
