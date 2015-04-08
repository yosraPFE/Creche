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
@RequestMapping(value = "/adminParent")
public class ParentAjoutAdminController implements HandlerExceptionResolver 
{
	
    /**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Autowired
	private IAdminMetier metier;

	// index

	@RequestMapping(value = "/index")
	public String index(Model model) {

		model.addAttribute("parent", new Parent());

		return "parentsAjout";

	}

	@RequestMapping(value = "/ajouterParent")
	public String ajouterParent(@Valid Parent par, BindingResult bindingResult,
			Model model, MultipartFile file) throws IOException {

		if (bindingResult.hasErrors()) {

			model.addAttribute("parent", new Parent());
			return ("parentsAjout");
		}

		if (!file.isEmpty()) {

			String path = "C:/Users/YOSRA/Desktop/PFE/ImagesParents";

			Long idParent = metier.ajouterParent(par);
			file.transferTo(new File(path + "/" + "PARENT_" + idParent + "_"
					+ file.getOriginalFilename()));
			par.setNomPhoto(path + "/" + "PARENT_" + idParent + "_"
					+ file.getOriginalFilename());
			metier.modifierParent(par);

		}
		if (par.getGenre().equals("Papa")) {
			model.addAttribute("parents", metier.getParent(par.getIdPerson()));
		} else if (par.getGenre().equals("Maman")) {
			model.addAttribute("parents", metier.getParent(par.getIdPerson()));
		}

		model.addAttribute("parentAjoute", metier.getParent(par.getIdPerson()));

		model.addAttribute("parent", new Parent());

		return "parentsAjout";
	}

	@RequestMapping(value = "photoParent", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoParent(Long idParent) throws IOException {

		Parent par = metier.getParent(idParent);
		File f = new File(par.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("parent", new Parent());
		mv.addObject("parents", metier.listParents());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("parentsAjout");

		return mv;
	}

}