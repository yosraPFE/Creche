package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Clubs;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminClubLi")
public class ClubsListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesClubs = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	public int getNbrLignesClubs() {
		return nbrLignesClubs;
	}

	public void setNbrLignesClubs(int nbrLignesClubs) {
		this.nbrLignesClubs = nbrLignesClubs;
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
		
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
		model.addAttribute("inscriptions",metier.listInscriptions());
		
		model.addAttribute("club", new Clubs());
		chargerModel(model);
		return "clubsListe";

	}

	@RequestMapping(value = "/validerModificationClub")
	public String validerModificationClub(@Valid Clubs club,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("clubsListe");
		}
		Long ref = club.getIdClub();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			model.addAttribute("CategorieClubs",metier.listCategorieClubs());
			model.addAttribute("inscriptions",metier.listInscriptions());
			metier.modifierClubs(club);
			model.addAttribute("club", new Clubs());
			chargerModel(model);
		}
		return "clubsListe";
	}

	@RequestMapping(value = "/modifierListeClubs")
	public String modifierListeClubs(Long idClubs, Model model) {
		
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
		model.addAttribute("inscriptions",metier.listInscriptions());
		
		Clubs club = metier.getClubs(idClubs);
		model.addAttribute("club", club);

		chargerModel(model);

		return "clubsListe";
	}

	

	@RequestMapping(value = "/supprimerListeClubs")
	public String supprimerListeClubs(Long idClubs,
			Model model) {

		setPage(page);
		model.addAttribute("CategorieClubs",metier.listCategorieClubs());
		model.addAttribute("inscriptions",metier.listInscriptions());
		
		metier.supprimerClubs(idClubs);
		model.addAttribute("club", new Clubs());
		chargerModel(model);

		return "clubsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesClubs() * getPage();
		long nbAc = metier.getNombreClubs();
		setNbrPages((int) (nbAc / getNbrLignesClubs()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("clubs",
				metier.listClubs(pos, getNbrLignesClubs()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("club", new Clubs());
		chargerModel(model);
		return "clubsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("club", new Clubs());
		mv.addObject("clubs", metier.listClubs(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("clubsListe");
		return mv;
	}


}
