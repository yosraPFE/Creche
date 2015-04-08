package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Parent;
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
@RequestMapping(value = "/adminPa")
public class ParentListeAdminController implements HandlerExceptionResolver 
{

	   /**
	    * 
	    * @author YOSRA
	    *
	    */
 
		private int page = 0;
		private int nbrLignesParents = 4;
		private int nbrPages;

		@Autowired
		private IAdminMetier metier;

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		

		public int getNbrLignesParents() {
			return nbrLignesParents;
		}

		public void setNbrLignesParents(int nbrLignesParents) {
			this.nbrLignesParents = nbrLignesParents;
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
			model.addAttribute("parent", new Parent());
			chargerModel(model);
			return "parentsListe";

		}

		@RequestMapping(value = "/validerModificationParent")
		public String validerModificationPar(@Valid Parent par,
				BindingResult bindingResult, Model model, MultipartFile file)
				throws IOException 
		  {
			if (bindingResult.hasErrors()) {
				chargerModel(model);
				return ("parentsListe");
			}
			Long ref = par.getIdPerson();
			String referrerAffiliateId = null;
			if (ref != null) 
			{
				referrerAffiliateId = Long.toString(ref);
				if (file.isEmpty()) 
				{
					Parent paren = metier.getParent(par
							.getIdPerson());
					par.setNomPhoto(paren.getNomPhoto());
				} 
				else 
				{
					String path = "C:/Users/YOSRA/Desktop/PFE/ImagesParents";
					file.transferTo(new File(path + "/" + "PARENT_"
							+ par.getIdPerson() + "_"
							+ file.getOriginalFilename()));
					par.setNomPhoto(path + "/" + "PARENT_"
							+ par.getIdPerson() + "_"
							+ file.getOriginalFilename());
				}
				
				metier.modifierParent(par);
				model.addAttribute("parent", new Parent());
				chargerModel(model);
			}
			return "parentsListe";
		}

		@RequestMapping(value = "/modifierListeParent")
		public String modifierListeParent(Long idParent, Model model) {
			Parent par = metier.getParent(idParent);
			model.addAttribute("parent", par);

			chargerModel(model);

			return "parentsListe";
		}

		// photo
		@RequestMapping(value = "photoPar", produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoPar(Long idParent) throws IOException {
			Parent par = metier.getParent(idParent);
			File f = new File(par.getNomPhoto());
			return IOUtils.toByteArray(new FileInputStream(f));
		}

		@RequestMapping(value = "/supprimerListeParent")
		public String supprimerListeParent(Long idParent,
				Model model) {

			setPage(page);
			metier.supprimerParent(idParent);
			model.addAttribute("parent", new Parent());
			chargerModel(model);

			return "parentsListe";
		}

		@RequestMapping(value = "chargerModel")
		public void chargerModel(Model model) {

			int pos = getNbrLignesParents() * getPage();
			long nbAc = metier.getNombreParents();
			setNbrPages((int) (nbAc / getNbrLignesParents()) + 1);

			model.addAttribute("nbrPages", getNbrPages());
			model.addAttribute("page", getPage());
			model.addAttribute("parents",
					metier.listParents(pos, getNbrLignesParents()));

		}

		@RequestMapping(value = "/indexPage")
		public String changerPage(Model model, int page) {
			setPage(page);
			model.addAttribute("parent", new Parent());
			chargerModel(model);
			return "parentsListe";
		}

		@RequestMapping
		@Override
		public ModelAndView resolveException(HttpServletRequest request,
				HttpServletResponse response, Object arg2, Exception ex) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("parent", new Parent());
			mv.addObject("parents", metier.listParents(0, 4));
			mv.addObject("exception", ex.getMessage());
			mv.setViewName("parentsListe");
			return mv;
		}

	

}