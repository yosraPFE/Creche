package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Evennement;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminEv")
public class EvennementsListeAdminController implements HandlerExceptionResolver
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesEvennement = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public int getNbrLignesEvennement() {
		return nbrLignesEvennement;
	}

	public void setNbrLignesEvennement(int nbrLignesEvennement) {
		this.nbrLignesEvennement = nbrLignesEvennement;
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
		model.addAttribute("evennement", new Evennement());
		chargerModel(model);
		return "evennementsListe";

	}

	@RequestMapping(value = "/validerModificationEven")
	public String validerModificationEven(@Valid Evennement even,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("evennementsListe");
		}
		Long ref = even.getIdEvenement();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierEvennements(even);
			model.addAttribute("evennement", new Evennement());
			chargerModel(model);
		}
		return "evennementsListe";
	}

	@RequestMapping(value = "/modifierListeEvennement")
	public String modifierListeEvennement(Long idEvennement, Model model) {
		
		Evennement even = metier.getEvennement(idEvennement);
		model.addAttribute("evennement", even);

		chargerModel(model);

		return "evennementsListe";
	}

	

	@RequestMapping(value = "/supprimerListeEvennement")
	public String supprimerListeEvennement(Long idEvennement,
			Model model) {

		setPage(page);
		metier.supprimerEvennements(idEvennement);
		model.addAttribute("evennement", new Evennement());
		chargerModel(model);

		return "evennementsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesEvennement() * getPage();
		long nbAc = metier.getNombreEvennements();
		setNbrPages((int) (nbAc / getNbrLignesEvennement()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("evennements",
				metier.listEvennements(pos, getNbrLignesEvennement()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("evennement", new Evennement());
		chargerModel(model);
		return "evennementsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("evennement", new Evennement());
		mv.addObject("evennements", metier.listEvennements(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("evennementsListe");
		return mv;
	}


}
