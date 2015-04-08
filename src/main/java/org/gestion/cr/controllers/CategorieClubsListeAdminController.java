package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.CategorieClub;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/adminCategC")
public class CategorieClubsListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesCategorieClub = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public int getNbrLignesCategorieClub() {
		return nbrLignesCategorieClub;
	}

	public void setNbrLignesCategorieClub(int nbrLignesCategorieClub) {
		this.nbrLignesCategorieClub = nbrLignesCategorieClub;
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
		model.addAttribute("categorieClub", new CategorieClub());
		chargerModel(model);
		return "categoriesClubsListe";

	}

	@RequestMapping(value = "/validerModificationCateg")
	public String validerModificationCateg(@Valid CategorieClub categ,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("categoriesClubsListe");
		}
		Long ref = categ.getIdCateg();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierCategorieClub(categ);
			model.addAttribute("categorieClub", new CategorieClub());
			chargerModel(model);
		}
		return "categoriesClubsListe";
	}

	@RequestMapping(value = "/modifierListeCategorieClub")
	public String modifierListeCategorieClub(Long idCategorieClub, Model model) {
		
		CategorieClub categ = metier.getCategorieClub(idCategorieClub);
		model.addAttribute("categorieClub", categ);

		chargerModel(model);

		return "categoriesClubsListe";
	}

	

	@RequestMapping(value = "/supprimerListeCategorieClub")
	public String supprimerListeCategorieClub(Long idCategorieClub,
			Model model) {

		setPage(page);
		metier.supprimerCategorieClub(idCategorieClub);
		model.addAttribute("categorieClub", new CategorieClub());
		chargerModel(model);

		return "categoriesClubsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesCategorieClub() * getPage();
		long nbAc = metier.getNombreCategorieClubs();
		setNbrPages((int) (nbAc / getNbrLignesCategorieClub()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("CategorieClubs",
				metier.listCategorieClubs(pos, getNbrLignesCategorieClub()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("categorieClub", new CategorieClub());
		chargerModel(model);
		return "categoriesClubsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorieClub", new CategorieClub());
		mv.addObject("categorieClubs", metier.listCategorieClubs(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categoriesClubsListe");
		return mv;
	}

}
