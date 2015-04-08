package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Materiels;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminMaterielLi")
public class MaterielsListeAdminController implements HandlerExceptionResolver 
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesMaterils = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	public int getNbrLignesMaterils() {
		return nbrLignesMaterils;
	}

	public void setNbrLignesMaterils(int nbrLignesMaterils) {
		this.nbrLignesMaterils = nbrLignesMaterils;
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
		
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		model.addAttribute("materiel", new Materiels());
		chargerModel(model);
		return "materielsListe";

	}

	@RequestMapping(value = "/validerModificationMateriel")
	public String validerModificationMateriel(@Valid Materiels mat,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("materielsListe");
		}
		Long ref = mat.getIdMateriel();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			model.addAttribute("stocks",metier.listStock());
			model.addAttribute("typeMateriels",metier.listTypeMateriels());
			metier.modifierMateriels(mat);
			model.addAttribute("materiel", new Materiels());
			chargerModel(model);
		}
		return "materielsListe";
	}

	@RequestMapping(value = "/modifierListeMateriels")
	public String modifierListeMateriels(Long idMat, Model model) {
		
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		Materiels mat = metier.getMateriels(idMat);
		model.addAttribute("materiel", mat);

		chargerModel(model);

		return "materielsListe";
	}

	

	@RequestMapping(value = "/supprimerListeMateriels")
	public String supprimerListeMateriels(Long idMat,
			Model model) {

		setPage(page);
		model.addAttribute("stocks",metier.listStock());
		model.addAttribute("typeMateriels",metier.listTypeMateriels());
		
		metier.supprimerMateriels(idMat);
		model.addAttribute("materiel", new Materiels());
		chargerModel(model);

		return "materielsListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesMaterils() * getPage();
		long nbAc = metier.getNombreMateriels();
		setNbrPages((int) (nbAc / getNbrLignesMaterils()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("materiels",
				metier.listMateriels(pos, getNbrLignesMaterils()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("materiel", new Materiels());
		chargerModel(model);
		return "materielsListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("materiel", new Materiels());
		mv.addObject("materiels", metier.listMateriels(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("materielsListe");
		return mv;
	}

}
