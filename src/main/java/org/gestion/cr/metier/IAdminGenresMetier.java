package org.gestion.cr.metier;

import java.util.List;

import org.gestion.cr.entities.Genre;
import org.gestion.cr.entities.Parent;

public interface IAdminGenresMetier extends InternauteMetier
{
	//Gestion des Genres 
	public Long ajouterGenre(Genre genre); 
	public void supprimerGenre(Long idGenre); 
	public void modifierGenre(Genre genre); 
	
	
	//Gestion des Parents
	public Long ajouterParent(Parent parent,Long idGenre); 
	public List<Parent> listParents(); 
	public List<Parent> parentParNom(String nomParent); 
	public List<Parent> parentParGenre(Long idGenre); 
	public void supprimerParent(Long idParent); 
	public void modifierParent(Parent parent); 
	public void ajouterEnfantsPourParent(Long idEnfant,Long idParent);

}
