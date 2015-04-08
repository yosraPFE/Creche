package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.EquipeSanitaire;
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
@RequestMapping(value = "/adminListSan")
public class EquipeSanListeAdminController implements HandlerExceptionResolver 
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	private int page = 0;
	private int nbrLignesEquipesSan = 4;
	private int nbrPages;

	@Autowired
	private IAdminMetier metier;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	

	public int getNbrLignesEquipesSan() {
		return nbrLignesEquipesSan;
	}

	public void setNbrLignesEquipesSan(int nbrLignesEquipesSan) {
		this.nbrLignesEquipesSan = nbrLignesEquipesSan;
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
		model.addAttribute("equipeSanitaire", new EquipeSanitaire());
		chargerModel(model);
		return "equipesSanListe";

	}

	@RequestMapping(value = "/validerModificationEqSan")
	public String validerModificationEqSan(@Valid EquipeSanitaire eqSa,
			BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException 
	  {
		if (bindingResult.hasErrors()) {
			chargerModel(model);
			return ("equipesSanListe");
		}
		Long ref = eqSa.getIdPerson();
		String referrerAffiliateId = null;
		if (ref != null) 
		{
			referrerAffiliateId = Long.toString(ref);
			if (file.isEmpty()) 
			{
				EquipeSanitaire eqSau = metier.getEquipeSanitaire(eqSa
						.getIdPerson());
				eqSa.setNomPhoto(eqSau.getNomPhoto());
			} 
			else 
			{
				String path = "C:/Users/YOSRA/Desktop/PFE/ImagesEqSanitaires";
				file.transferTo(new File(path + "/" + "EqSANITAIR_"
						+ eqSa.getIdPerson() + "_"
						+ file.getOriginalFilename()));
				eqSa.setNomPhoto(path + "/" + "EqSANITAIR_"
						+ eqSa.getIdPerson() + "_"
						+ file.getOriginalFilename());
			}
			metier.modifierEquipeSanitaire(eqSa);
			
			
			if(eqSa.getSexe().equals("Homme"))
			{
				model.addAttribute("equipes",metier.listEquipeSanitaires(0,4));
			}
			else if(eqSa.getSexe().equals("Femme"))
			{
				model.addAttribute("equipes",metier.listEquipeSanitaires(0,4));
			}
			
			
			model.addAttribute("fonctions",metier.listFonctions());
			model.addAttribute("equipeSanitaire", new EquipeSanitaire());
			chargerModel(model);
		}
		return "equipesSanListe";
	}

	@RequestMapping(value = "/modifierListeEquipeSanitaire")
	public String modifierListeEquipeSanitaire(Long idEquipeSanitaire, Model model) {
		model.addAttribute("fonctions",metier.listFonctions());
		EquipeSanitaire eqSa = metier.getEquipeSanitaire(idEquipeSanitaire);
		model.addAttribute("equipeSanitaire", eqSa);

		chargerModel(model);

		return "equipesSanListe";
	}

	// photo
	@RequestMapping(value = "photoEqSan", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoEqSan(Long idEquipeSanitaire) throws IOException {
		EquipeSanitaire eqSa = metier.getEquipeSanitaire(idEquipeSanitaire);
		File f = new File(eqSa.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/supprimerListeEquipeSanitaire")
	public String supprimerListeEquipeSanitaire(Long idEquipeSanitaire,
			Model model) {

		setPage(page);
		metier.supprimerEquipeSanitaire(idEquipeSanitaire);
		model.addAttribute("fonctions",metier.listFonctions());
		model.addAttribute("equipeSanitaire", new EquipeSanitaire());
		chargerModel(model);

		return "equipesSanListe";
	}

	@RequestMapping(value = "chargerModel")
	public void chargerModel(Model model) {

		int pos = getNbrLignesEquipesSan() * getPage();
		long nbAc = metier.getNombreEquipesSan();
		setNbrPages((int) (nbAc / getNbrLignesEquipesSan()) + 1);

		model.addAttribute("nbrPages", getNbrPages());
		model.addAttribute("page", getPage());
		model.addAttribute("equipeSanitaires",
				metier.listEquipeSanitaires(pos, getNbrLignesEquipesSan()));

	}

	@RequestMapping(value = "/indexPage")
	public String changerPage(Model model, int page) {
		setPage(page);
		model.addAttribute("equipeSanitaire", new EquipeSanitaire());
		chargerModel(model);
		return "equipesSanListe";
	}

	@RequestMapping
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("equipeSanitaire", new EquipeSanitaire());
		mv.addObject("equipeSanitaires", metier.listEquipeSanitaires(0, 4));
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("equipesSanListe");
		return mv;
	}


}
