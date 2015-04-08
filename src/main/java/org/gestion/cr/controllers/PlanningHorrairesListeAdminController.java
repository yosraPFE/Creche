package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.PlanningHorraires;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminPlanLi")
public class PlanningHorrairesListeAdminController implements HandlerExceptionResolver
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesPlanningsHorraires = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNbrLignesPlanningsHorraires() {
		return nbrLignesPlanningsHorraires;
	}

	public void setNbrLignesPlanningsHorraires(int nbrLignesPlanningsHorraires) {
		this.nbrLignesPlanningsHorraires = nbrLignesPlanningsHorraires;
	}

	public int getNbrPages() {
		return nbrPages;
	}

	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}

	// index
	@RequestMapping(value = "/index")
	public String index(Model model) {
		
		model.addAttribute("genrePlannings",metier.listGenrePlanning());
		model.addAttribute("planningHorraire", new PlanningHorraires());
		chargerModel(model);
		return "planningHorrairesListe";

	}

	@RequestMapping(value = "/validerModificationPlanHor")
	public String validerModificationPlanHor(@Valid PlanningHorraires plHor,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("planningHorrairesListe");
		}
		Long ref = plHor.getIdPlanning();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			model.addAttribute("genrePlannings",metier.listGenrePlanning());
			metier.modifierPlanningHorraires(plHor);
			model.addAttribute("planningHorraire", new PlanningHorraires());
			chargerModel(model);
		}
		return "planningHorrairesListe";
	}

	@RequestMapping(value = "/modifierListePlanningHorraires")
	public String modifierListePlanningHorraires(Long idPlanningHo, Model model) {
		
		model.addAttribute("genrePlannings",metier.listGenrePlanning());
		PlanningHorraires plHor = metier.getPlanningHorraires(idPlanningHo);
		model.addAttribute("planningHorraire", plHor);

		chargerModel(model);

		return "planningHorrairesListe";
	}

	

	@RequestMapping(value = "/supprimerListePlanningHorraires")
	public String supprimerListePlanningHorraires(Long idPlanningHo,
			Model model) {

		setPage(page);
		model.addAttribute("genrePlannings",metier.listGenrePlanning());
		metier.supprimerPlanningHorraires(idPlanningHo);
		model.addAttribute("planningHorraire", new PlanningHorraires());
		chargerModel(model);

		return "planningHorrairesListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesPlanningsHorraires() * getPage();
		long nbAc = metier.getNombrePlanningHorraires();
		setNbrPages((int) (nbAc / getNbrLignesPlanningsHorraires()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("planningHorraires",
				metier.listPlanningHorraires(pos, getNbrLignesPlanningsHorraires()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("planningHorraire", new PlanningHorraires());
		chargerModel(model);
		return "planningHorrairesListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("planningHorraire", new PlanningHorraires());
		mv.addObject("planningHorraires", metier.listPlanningHorraires(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("planningHorrairesListe");
		return mv;
	}


}
