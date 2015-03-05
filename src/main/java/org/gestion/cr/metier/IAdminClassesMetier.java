package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Annee;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.entities.EquipeEducatif;

public interface IAdminClassesMetier extends InternauteMetier
{
	//Gestion des Classes
	public Long ajouterClasse(Classe classe,Long idCreche,Long idNomClass);
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);
	
	
	//Gestion des Equipes Educatifs
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction); 
	public void supprimerEquipeEducatif(Long idEquipeEducatif); 
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);
	
	
	
	//Gestion des Enfants
	public Long ajouterEnfant(Enfant enfant,Long idFicheAnnexeEnfant); 
	public List<Enfant> enfantCertife(); 
	public List<Enfant> enfantPhotoAutorise(); 
	public void supprimerEnfant(Long idEnfant);
	public void modifierEnfant(Enfant enfant);
	public void ajouterAccompagnateursPourEnfant(Long idAccompagnateur,Long idEnfant);
	public void ajouterParentsPourEnfant(Long idParent,Long idEnfant);
	public void ajouterEquipesSanitairesPourEnfant(Long idEquipeSanitaire,Long idEnfant);
	
	
	//Gestion des Annees
	public Long ajouterAnnee(Annee annee);
	public void supprimerAnnees(Long idAnnee); 
	public void modifierAnnees(Annee annee); 
	public void ajouterAnneesPourEnfantPourClasse(Long idAnnee,Long idEnfant,Long idclass);
	public void ajouterEnfantsPourAnneePourClasse(Long idEnfant,Long idAnnee,Long idclass);
	public void ajouterClassesPourAnneePourEnfant(Long idclass,Long idAnnee,Long idEnfant );

}
