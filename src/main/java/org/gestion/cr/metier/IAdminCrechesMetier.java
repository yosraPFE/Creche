package org.gestion.cr.metier;

import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.entities.EquipeTechnique;

public interface IAdminCrechesMetier extends InternauteMetier
{
	//Gestion des Creches
	public Long ajouterCreche(Creche creche); 
	public void supprimerCreche(Long idCreche); 
	public void modifierCreche(Creche creche); 
	
	//Gestion des Classes
	public Long ajouterClasse(Classe classe,Long idCreche,Long idNomClass);
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
	
	
	//Gestion des Equipes Techniques
	public Long ajouterEquipeTechnique( EquipeTechnique equipeTechnique,Long idCreche,Long idFonction);
	public void supprimerEquipeTechnique(Long idEquipeTechnique);
	public void modifierEquipeTechnique(EquipeTechnique equipeTechnique);

}
