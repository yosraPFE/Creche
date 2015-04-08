package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.EquipeEducatif;
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
@RequestMapping(value = "/adminListEdu")
public class EquipeEduListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesEquipesEdu = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	public int getNbrLignesEquipesEdu() {
		return nbrLignesEquipesEdu;
	}

	public void setNbrLignesEquipesEdu(int nbrLignesEquipesEdu) {
		this.nbrLignesEquipesEdu = nbrLignesEquipesEdu;
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
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeEducatif", new EquipeEducatif());
		chargerModel(model);
		return "equipesEduListe";

	}

	@RequestMapping(value = "/validerModificationEqEdu")
	public String validerModificationEqEdu(@Valid EquipeEducatif eqEd,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("equipesEduListe");
		}
		Long ref = eqEd.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				EquipeEducatif eqEdu = metier.getEquipeEducatif(eqEd
						.getIdPerson());
				eqEd.setNomPhoto(eqEdu.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImagesEqEducatifs";
				file.transferTo(new File(path + "/" + "EqEDUCATIF_"
						+ eqEd.getIdPerson() + "_"
						+ file.getOriginalFilename()));
				eqEd.setNomPhoto(path + "/" + "EqEDUCATIF_"
						+ eqEd.getIdPerson() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierEquipeEducatif(eqEd);
			
			
			if(eqEd.getSexe().equals("Homme"))
			{
				model.addAttribute("equipes",metier.listEquipeEducatif(0,4));
			}
			else if(eqEd.getSexe().equals("Femme"))
			{
				model.addAttribute("equipes",metier.listEquipeEducatif(0,4));
			}
			
			
			model.addAttribute("fonctions",metier.listFonctions());
			model.addAttribute("equipeEducatif", new EquipeEducatif());
			chargerModel(model);
		}
		return "equipesEduListe";
	}

	@RequestMapping(value = "/modifierListeEquipeEducatif")
	public String modifierListeEquipeEducatif(Long idEquipeEducatif, Model model) {
		model.addAttribute("fonctions",metier.listFonctions());
		EquipeEducatif eqEd = metier.getEquipeEducatif(idEquipeEducatif);
		model.addAttribute("equipeEducatif", eqEd);

		chargerModel(model);

		return "equipesEduListe";
	}

	// photo
	@RequestMapping(value = "photoEqEdu", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoEqEdu(Long idEquipeEducatif) throws IOException {
		EquipeEducatif eqEd = metier.getEquipeEducatif(idEquipeEducatif);
		File f = new File(eqEd.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeEquipeEducatifr")
	public String supprimerListeEquipeEducatifr(Long idEquipeEducatif,
			Model model) {

		setPage(page);
		metier.supprimerEquipeEducatif(idEquipeEducatif);
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeEducatif", new EquipeEducatif());
		chargerModel(model);

		return "equipesEduListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesEquipesEdu() * getPage();
		long nbAc = metier.getNombreEquipesEdu();
		setNbrPages((int) (nbAc / getNbrLignesEquipesEdu()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("equipeEducatifs",
				metier.listEquipeEducatif(pos, getNbrLignesEquipesEdu()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("equipeEducatif", new EquipeEducatif());
		chargerModel(model);
		return "equipesEduListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("equipeEducatif", new EquipeEducatif());
		mv.addObject("equipeEducatifs", metier.listEquipeEducatif(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("equipesEduListe");
		return mv;
	}

}
