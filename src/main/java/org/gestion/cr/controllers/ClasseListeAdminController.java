package org.gestion.cr.controllers;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Classe;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminClasLi")
public class ClasseListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesClasses = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	public int getNbrLignesClasses() {
		return nbrLignesClasses;
	}

	public void setNbrLignesClasses(int nbrLignesClasses) {
		this.nbrLignesClasses = nbrLignesClasses;
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
		
		model.addAttribute("creches",metier.listCreches());
		model.addAttribute("classe", new Classe());
		chargerModel(model);
		return "classesListe";

	}

	@RequestMapping(value = "/validerModificationClas")
	public String validerModificationClas(@Valid Classe cla,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("classesListe");
		}
		Long ref = cla.getIdClass();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			model.addAttribute("creches",metier.listCreches());
			metier.modifierClasse(cla);
			model.addAttribute("classe", new Classe());
			chargerModel(model);
		}
		return "classesListe";
	}

	@RequestMapping(value = "/modifierListeClasse")
	public String modifierListeClasse(Long idClasse, Model model) {
		
		model.addAttribute("creches",metier.listCreches());
		Classe cla = metier.getClasse(idClasse);
		model.addAttribute("classe", cla);

		chargerModel(model);

		return "classesListe";
	}

	

	@RequestMapping(value = "/supprimerListeClasse")
	public String supprimerListeClasse(Long idClasse,
			Model model) {

		setPage(page);
		model.addAttribute("creches",metier.listCreches());
		metier.supprimerClasse(idClasse);
		model.addAttribute("classe", new Classe());
		chargerModel(model);

		return "classesListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesClasses() * getPage();
		long nbAc = metier.getNombreClasses();
		setNbrPages((int) (nbAc / getNbrLignesClasses()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("classes",
				metier.listClasse(pos, getNbrLignesClasses()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("classe", new Classe());
		chargerModel(model);
		return "classesListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("classe", new Classe());
		mv.addObject("classes", metier.listClasse(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("classesListe");
		return mv;
	}


}
