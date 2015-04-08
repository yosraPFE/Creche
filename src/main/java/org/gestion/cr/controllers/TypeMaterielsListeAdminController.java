package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.gestion.cr.entities.TypeMateriels;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminTypM")
public class TypeMaterielsListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesTypesMateriels = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	

	public int getNbrLignesTypesMateriels() {
		return nbrLignesTypesMateriels;
	}

	public void setNbrLignesTypesMateriels(int nbrLignesTypesMateriels) {
		this.nbrLignesTypesMateriels = nbrLignesTypesMateriels;
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
		model.addAttribute("typeMateriel", new TypeMateriels());
		chargerModel(model);
		return "typeMaterielsListe";

	}

	@RequestMapping(value = "/validerModificationtypeMat")
	public String validerModificationtypeMat(@Valid TypeMateriels tpMat,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("typeMaterielsListe");
		}
		Long ref = tpMat.getIdTypeMateriel();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierTypeMateriels(tpMat);
			model.addAttribute("typeMateriel", new TypeMateriels());
			chargerModel(model);
		}
		return "typeMaterielsListe";
	}

	@RequestMapping(value = "/modifierListeTypeMateriels")
	public String modifierListeTypeMateriels(Long idTypeMateriels, Model model) {
		
		TypeMateriels tpMat = metier.getTypeMateriels(idTypeMateriels);
		model.addAttribute("typeMateriel", tpMat);

		chargerModel(model);

		return "typeMaterielsListe";
	}

	

	@RequestMapping(value = "/supprimerListeTypeMateriels")
	public String supprimerListeTypeMateriels(Long idTypeMateriels,
			Model model) {

		setPage(page);
		metier.supprimerTypeMateriels(idTypeMateriels);
		model.addAttribute("typeMateriel", new TypeMateriels());
		chargerModel(model);

		return "typeMaterielsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesTypesMateriels() * getPage();
		long nbAc = metier.getNombreTypesMateriels();
		setNbrPages((int) (nbAc / getNbrLignesTypesMateriels()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("typeMateriels",
				metier.listTypeMateriels(pos, getNbrLignesTypesMateriels()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("typeMateriel", new TypeMateriels());
		chargerModel(model);
		return "typeMaterielsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("typeMateriel", new TypeMateriels());
		mv.addObject("typeMateriels", metier.listTypeMateriels(0,4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("typeMaterielsListe");
		return mv;
	}

}
