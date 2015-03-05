package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeSanitaire;

public interface IAdminEqSanitairesMetier extends InternauteMetier
{
	//Gestion des Equipes Sanitaires
	public Long ajouterEquipeSanitaire(EquipeSanitaire equipeSanitaire,Long idFonction);
	public void supprimerEquipeSanitaire(Long idEquipeSanitaire); 
	public void modifierEquipeSanitaire(EquipeSanitaire equipeSanitaire); 
	public void ajouterEnfantsPourEquipeSanitaire(Long idEnfant,Long idEquipeSanitaire); 
	
	
	
	//Gestion des Enfants
	public Long ajouterEnfant(Enfant enfant,Long idFicheAnnexeEnfant); 
	public List<Enfant> enfantCertife(); 
	public List<Enfant> enfantPhotoAutorise(); 
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant);
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
	public void ajouterEquipesSanitairesPourEnfant(Long idEquipeSanitaire,Long idEnfant);

}
