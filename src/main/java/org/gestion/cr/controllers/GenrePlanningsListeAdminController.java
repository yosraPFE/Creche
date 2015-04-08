package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.GenrePlanning;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminGen")
public class GenrePlanningsListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesGenrePlanning = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	public int getNbrLignesGenrePlanning() {
		return nbrLignesGenrePlanning;
	}

	public void setNbrLignesGenrePlanning(int nbrLignesGenrePlanning) {
		this.nbrLignesGenrePlanning = nbrLignesGenrePlanning;
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
		model.addAttribute("genrePlanning", new GenrePlanning());
		chargerModel(model);
		return "genresPlanningsListe";

	}

	@RequestMapping(value = "/validerModificationGenrePla")
	public String validerModificationGenrePla(@Valid GenrePlanning grPl,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("genresPlanningsListe");
		}
		Long ref = grPl.getIdGenrePlanning();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierGenrePlanning(grPl);
			model.addAttribute("genrePlanning", new GenrePlanning());
			chargerModel(model);
		}
		return "genresPlanningsListe";
	}

	@RequestMapping(value = "/modifierListeGenrePlanning")
	public String modifierListeGenrePlanning(Long idGenrePlann, Model model) {
		
		GenrePlanning grPl = metier.getGenrePlanning(idGenrePlann);
		model.addAttribute("genrePlanning", grPl);

		chargerModel(model);

		return "genresPlanningsListe";
	}

	

	@RequestMapping(value = "/supprimerListeGenrePlanning")
	public String supprimerListeGenrePlanning(Long idGenrePlann,
			Model model) {

		setPage(page);
		metier.supprimerGenrePlanning(idGenrePlann);
		model.addAttribute("genrePlanning", new GenrePlanning());
		chargerModel(model);

		return "genresPlanningsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesGenrePlanning() * getPage();
		long nbAc = metier.getNombreGenrePlanning();
		setNbrPages((int) (nbAc / getNbrLignesGenrePlanning()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("genrePlannings",
				metier.listGenrePlanning(pos, getNbrLignesGenrePlanning()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("genrePlanning", new GenrePlanning());
		chargerModel(model);
		return "genresPlanningsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("genrePlanning", new GenrePlanning());
		mv.addObject("genrePlannings", metier.listGenrePlanning(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("genresPlanningsListe");
		return mv;
	}


}
