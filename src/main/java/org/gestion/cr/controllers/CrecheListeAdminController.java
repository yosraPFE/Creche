package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Creche;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminCr")
public class CrecheListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesCreches = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	

	public int getNbrLignesCreches() {
		return nbrLignesCreches;
	}

	public void setNbrLignesCreches(int nbrLignesCreches) {
		this.nbrLignesCreches = nbrLignesCreches;
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
		model.addAttribute("creche", new Creche());
		chargerModel(model);
		return "crechesListe";

	}

	@RequestMapping(value = "/validerModificationCrech")
	public String validerModificationCrech(@Valid Creche crech,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("crechesListe");
		}
		Long ref = crech.getIdCreche();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				Creche creche = metier.getCreche(crech.getIdCreche());
				crech.setNomPhoto(creche.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImagesCreches";
				file.transferTo(new File(path + "/" + "CRECH_"
						+ crech.getIdCreche() + "_"
						+ file.getOriginalFilename()));
				crech.setNomPhoto(path + "/" + "CRECH_"
						+ crech.getIdCreche() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierCreche(crech);
			model.addAttribute("creche", new Creche());
			chargerModel(model);
		}
		return "crechesListe";
	}

	@RequestMapping(value = "/modifierListeCreche")
	public String modifierListeCreche(Long idCreche, Model model) {
		Creche crech = metier.getCreche(idCreche);
		model.addAttribute("creche", crech);

		chargerModel(model);

		return "crechesListe";
	}

	// photo
	@RequestMapping(value = "photoCrech", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCrech(Long idCreche) throws IOException {
		Creche crech = metier.getCreche(idCreche);
		File f = new File(crech.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeCreche")
	public String supprimerListeCreche(Long idCreche,
			Model model) {

		setPage(page);
		metier.supprimerCreche(idCreche);
		model.addAttribute("creche", new Creche());
		chargerModel(model);

		return "crechesListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesCreches() * getPage();
		long nbAc = metier.getNombreCreches();
		setNbrPages((int) (nbAc / getNbrLignesCreches()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("creches",
				metier.listCreches(pos, getNbrLignesCreches()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("creche", new Creche());
		chargerModel(model);
		return "crechesListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("creche", new Creche());
		mv.addObject("creches", metier.listCreches(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("crechesListe");
		return mv;
	}


}
