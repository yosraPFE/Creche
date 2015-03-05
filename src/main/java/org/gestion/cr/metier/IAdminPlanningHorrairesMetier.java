package org.gestion.cr.metier;

import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.entities.Tarif;

public interface IAdminPlanningHorrairesMetier extends InternauteMetier
{
	//Gestion des Planning Horraires
	public Long ajouterPlanningHorraires(PlanningHorraires planningHorraires); 
	public void supprimerPlanningHorraires(Long idPlanningHorraires); 
	public void modifierPlanningHorraires(PlanningHorraires planningHorraires); 
	
	
	//Gestion des Tarifs
	public Long ajouterTarif(Tarif tarif,Long idPlanningHorraires,Long idEnfant); 
	public void supprimerTarif(Long idTarif); 
	public void modifierTarif(Tarif tarif); 

}
