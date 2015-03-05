package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.FicheAnnexeEnfant;

public interface IAdminFicheAnnexesMetier extends InternauteMetier
{
	//Gestion des Fiches Annexes
	public Long ajouterFicheAnnexeEnfant(FicheAnnexeEnfant ficheAnnexeEnfant); 
	public List<FicheAnnexeEnfant> listFicheAnnexeEnfant();
	public void supprimerFicheAnnexeEnfant(Long idFicheAnnexeEnfant); 
	public void modifierFicheAnnexeEnfant(FicheAnnexeEnfant ficheAnnexeEnfant); 
	
	
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
