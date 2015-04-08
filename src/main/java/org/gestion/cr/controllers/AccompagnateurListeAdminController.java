package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Accompagnateur;
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
@RequestMapping(value = "/admin")
public class AccompagnateurListeAdminController implements HandlerExceptionResolver 
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesAccompagnateurs = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNbrLignesAccompagnateurs() {
		return nbrLignesAccompagnateurs;
	}

	public void setNbrLignesAccompagnateurs(int nbrLignesAccompagnateurs) {
		this.nbrLignesAccompagnateurs = nbrLignesAccompagnateurs;
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
		model.addAttribute("accompagnateur", new Accompagnateur());
		chargerModel(model);
		return "accompagnateursListe";

	}

	@RequestMapping(value = "/validerModificationAccomp")
	public String validerModificationAccomp(@Valid Accompagnateur accomp,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("accompagnateursListe");
		}
		Long ref = accomp.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				Accompagnateur accompa = metier.getAccompagnateur(accomp
						.getIdPerson());
				accomp.setNomPhoto(accompa.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImageAccompagnateurs";
				file.transferTo(new File(path + "/" + "ACCOMPAGNATEUR_"
						+ accomp.getIdPerson() + "_"
						+ file.getOriginalFilename()));
				accomp.setNomPhoto(path + "/" + "ACCOMPAGNATEUR_"
						+ accomp.getIdPerson() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierAccompagnateurs(accomp);
			model.addAttribute("accompagnateur", new Accompagnateur());
			chargerModel(model);
		}
		return "accompagnateursListe";
	}

	@RequestMapping(value = "/modifierListeAccompagnateur")
	public String modifierListeAccompagnateur(Long idAccompagnateur, Model model) {
		Accompagnateur accomp = metier.getAccompagnateur(idAccompagnateur);
		model.addAttribute("accompagnateur", accomp);

		chargerModel(model);

		return "accompagnateursListe";
	}

	// photo
	@RequestMapping(value = "photoAccomp", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoAccomp(Long idAccompagnateur) throws IOException {
		Accompagnateur accomp = metier.getAccompagnateur(idAccompagnateur);
		File f = new File(accomp.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeAccompagnateur")
	public String supprimerListeAccompagnateur(Long idAccompagnateur,
			Model model) {

		setPage(page);
		metier.supprimerAccompagnateurs(idAccompagnateur);
		model.addAttribute("accompagnateur", new Accompagnateur());
		chargerModel(model);

		return "accompagnateursListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesAccompagnateurs() * getPage();
		long nbAc = metier.getNombreAccompagnateurs();
		setNbrPages((int) (nbAc / getNbrLignesAccompagnateurs()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("accompagnateurs",
				metier.listAccompagnateurs(pos, getNbrLignesAccompagnateurs()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("accompagnateur", new Accompagnateur());
		chargerModel(model);
		return "accompagnateursListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("accompagnateur", new Accompagnateur());
		mv.addObject("accompagnateurs", metier.listAccompagnateurs(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("accompagnateursListe");
		return mv;
	}

}