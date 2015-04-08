package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Stock;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminStoc")
public class StocksListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesStocks = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	public int getNbrLignesStocks() {
		return nbrLignesStocks;
	}

	public void setNbrLignesStocks(int nbrLignesStocks) {
		this.nbrLignesStocks = nbrLignesStocks;
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
		model.addAttribute("stock", new Stock());
		chargerModel(model);
		return "stocksListe";

	}

	@RequestMapping(value = "/validerModificationStoc")
	public String validerModificationStoc(@Valid Stock stoc,
			BindingResult bindingResult, Model model)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("stocksListe");
		}
		Long ref = stoc.getIdStock();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			
			
			metier.modifierStock(stoc);
			model.addAttribute("stock", new Stock());
			chargerModel(model);
		}
		return "stocksListe";
	}

	@RequestMapping(value = "/modifierListeStock")
	public String modifierListeStock(Long idStock, Model model) {
		
		Stock stoc = metier.getStock(idStock);
		model.addAttribute("stock", stoc);

		chargerModel(model);

		return "stocksListe";
	}

	

	@RequestMapping(value = "/supprimerListeStock")
	public String supprimerListeStock(Long idStock,
			Model model) {

		setPage(page);
		metier.supprimerStock(idStock);
		model.addAttribute("stock", new Stock());
		chargerModel(model);

		return "stocksListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesStocks() * getPage();
		long nbAc = metier.getNombreStocks();
		setNbrPages((int) (nbAc / getNbrLignesStocks()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("stocks",
				metier.listStock(pos, getNbrLignesStocks()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("stock", new Stock());
		chargerModel(model);
		return "stocksListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("stock", new Stock());
		mv.addObject("stocks", metier.listStock(0,4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("stocksListe");
		return mv;
	}

}
