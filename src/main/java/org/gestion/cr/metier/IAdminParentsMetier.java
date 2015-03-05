package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.Parent;

public interface IAdminParentsMetier extends InternauteMetier
{
	//Gestion des Parents
	public Long ajouterParent(Parent parent,Long idGenre); 
	public List<Parent> listParents(); 
	public List<Parent> parentParNom(String nomParent); 
	public List<Parent> parentParGenre(Long idGenre); 
	public void supprimerParent(Long idParent); 
	public void modifierParent(Parent parent); 
	public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);
	
	
	
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
