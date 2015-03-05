package org.gestion.cr.metier;

import org.gestion.cr.entities.EquipeEducatif;
import org.gestion.cr.entities.EquipeSanitaire;
import org.gestion.cr.entities.EquipeTechnique;
import org.gestion.cr.entities.Fonction;

public interface IAdminFonctionsMetier extends InternauteMetier
{
	//Gestion des Fonctions
	public Long ajouterFonction(Fonction fonction); 
	public void supprimerFonction(Long idFonction); 
	public void modifierFonction(Fonction fonction); 
	
	
	//Gestion des Equipes Techniques
	public Long ajouterEquipeTechnique( EquipeTechnique equipeTechnique,Long idCreche,Long idFonction);
	public void supprimerEquipeTechnique(Long idEquipeTechnique);
	public void modifierEquipeTechnique(EquipeTechnique equipeTechnique);
	
	//Gestion des Equipes Sanitaires
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction);
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
	public void ajouterEnfantsPourEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire);
	
	
	//gestion Equipes Educatif
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction); 
	public void supprimerEquipeEducatif(Long idEquipeEducatif); 
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);

}
