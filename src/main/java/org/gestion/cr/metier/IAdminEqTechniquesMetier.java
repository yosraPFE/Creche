package org.gestion.cr.metier;

import org.gestion.cr.entities.EquipeTechnique;

public interface IAdminEqTechniquesMetier extends InternauteMetier
{
	//Gestion des Equipes Techniques
	public Long ajouterEquipeTechnique( EquipeTechnique equipeTechnique,Long idCreche,Long idFonction);
	public void supprimerEquipeTechnique(Long idEquipeTechnique);
	public void modifierEquipeTechnique(EquipeTechnique equipeTechnique); 
}
