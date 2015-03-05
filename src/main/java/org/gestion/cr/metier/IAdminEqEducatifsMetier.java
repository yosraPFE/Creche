package org.gestion.cr.metier;

import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.EquipeEducatif;

public interface IAdminEqEducatifsMetier extends InternauteMetier
{
	//gestion Equipes Educatif
	public Long ajouterEquipeEducatif(EquipeEducatif equipeEducatif,Long idFonction); 
	public void supprimerEquipeEducatif(Long idEquipeEducatif); 
	public void modifierEquipeEducatif(EquipeEducatif equipeEducatif); 
	public void ajouterClassesPourEquipeEducatifs(Long idClasse,Long idEquipeEducatif);
	
	
	//Gestion des Classes
	public Long ajouterClasse(Classe classe,Long idCreche,Long idNomClass);
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);

}
