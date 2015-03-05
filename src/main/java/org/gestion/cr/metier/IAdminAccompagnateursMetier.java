package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Enfant;

public interface IAdminAccompagnateursMetier extends InternauteMetier
{
	//Gestion Accompagnateur
	public void supprimerAccompagnateurs(Long idAccompagnateur); 
	public void modifierAccompagnateurs(Accompagnateur accompagnateur); 
	public void ajouterEnfantsPourAccompagnateur(Long idEnfant,Long idAccompagnateur);
	
	
	//Gestion Enfant
	public Long ajouterEnfant(Enfant enfant,Long idFicheAnnexeEnfant); 
	public List<Enfant> enfantCertife(); 
	public List<Enfant> enfantPhotoAutorise(); 
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant);
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
	public void ajouterEquipesSanitairesPourEnfant(Long idEquipeSanitaire,Long idEnfant);

}
