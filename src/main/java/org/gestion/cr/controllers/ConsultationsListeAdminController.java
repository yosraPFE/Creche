package org.gestion.cr.controllers;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminConsu")
public class ConsultationsListeAdminController  implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesConsultations = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNbrLignesConsultations() {
		return nbrLignesConsultations;
	}

	public void setNbrLignesConsultations(int nbrLignesConsultations) {
		this.nbrLignesConsultations = nbrLignesConsultations;
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
		model.addAttribute("consultation", new Consultation());
		chargerModel(model);
		return "consultationsListe";

	}

	@RequestMapping(value = "/validerModificationCons")
	public String validerModificationCons(@Valid Consultation cons,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("consultationsListe");
		}
		Long ref = cons.getIdConsultation();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierConsultations(cons);
			model.addAttribute("consultation", new Consultation());
			chargerModel(model);
		}
		return "consultationsListe";
	}

	@RequestMapping(value = "/modifierListeConsultation")
	public String modifierListeConsultation(Long idConsultation, Model model) {
		
		Consultation cons = metier.getConsultation(idConsultation);
		model.addAttribute("consultation", cons);

		chargerModel(model);

		return "consultationsListe";
	}

	

	@RequestMapping(value = "/supprimerListeConsultation")
	public String supprimerListeConsultation(Long idConsultation,
			Model model) {

		setPage(page);
		metier.supprimerConsultations(idConsultation);
		model.addAttribute("consultation", new Consultation());
		chargerModel(model);

		return "consultationsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesConsultations() * getPage();
		long nbAc = metier.getNombreConsultations();
		setNbrPages((int) (nbAc / getNbrLignesConsultations()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("consultations",
				metier.listConsultations(pos, getNbrLignesConsultations()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("consultation", new Consultation());
		chargerModel(model);
		return "consultationsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("consultation", new Consultation());
		mv.addObject("consultations", metier.listConsultations(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("consultationsListe");
		return mv;
	}

}
