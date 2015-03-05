package org.gestion.cr.metier;

import org.gestion.cr.entities.CategorieClub;

public interface IAdminCategorieClubsMetier extends InternauteMetier
{
	
	//Gestion des Categories Clubs
	public Long ajouterCategorieClub(CategorieClub categorieClub,Long idClub);
	public void supprimerCategorieClub(Long idCategorieClub); 
	public void modifierCategorieClub(CategorieClub categorieClub);

}
