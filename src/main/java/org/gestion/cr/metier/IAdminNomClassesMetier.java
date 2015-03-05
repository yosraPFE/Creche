package org.gestion.cr.metier;

import org.gestion.cr.entities.Classe;
import org.gestion.cr.entities.NomClass;

public interface IAdminNomClassesMetier extends InternauteMetier
{
	//Gestion des Nom Classes
	public Long ajouterNomClass(NomClass nomClass); 
	public void supprimerNomClass(Long idNomClass);
	public void modifierNomClass(NomClass nomClass); 
	
	
	//Gestion des Classes
	public Long ajouterClasse(Classe classe,Long idCreche,Long idNomClass);
	public void supprimerClasse(Long idClasse); 
	public void modifierClasse(Classe classe); 
	public void ajouterEquipeEducatifPourClasse(Long idEquipeEducatif,Long idClasse);

}
