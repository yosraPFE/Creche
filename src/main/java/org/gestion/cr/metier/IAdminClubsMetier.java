package org.gestion.cr.metier;

import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.entities.Clubs;

public interface IAdminClubsMetier extends InternauteMetier
{
	//Gestion des Clubs
	public Long ajouterClubs(Clubs clubs,Long idTarif); 
	public void supprimerClubs(Long idClubs); 
	public void modifierClubs(Clubs clubs); 
	
	
	//Gestion des Categories Clubs
	public Long ajouterCategorieClub(CategorieClub categorieClub,Long idClub);
	public void supprimerCategorieClub(Long idCategorieClub); 
	public void modifierCategorieClub(CategorieClub categorieClub);

}
