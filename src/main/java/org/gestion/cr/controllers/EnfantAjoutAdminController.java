package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Enfant;
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
@RequestMapping(value="/adminE")
public class EnfantAjoutAdminController implements HandlerExceptionResolver
{

	/**
	 * 
	 * @author YOSRA
	 *
	 */
	@Autowired
	private IAdminMetier metier;
	
	/*@Autowired 
	 private HttpServletRequest request;*/
	
	
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		model.addAttribute("enfant", new Enfant());
		//model.addAttribute("parent", new Parent());
		//model.addAttribute("accompagnateur", new Accompagnateur());
		
		
		
		return "enfantsAjout";
		
	}
	
	@RequestMapping(value="/ajouterEnfant")
	public String ajouterEnfant(@Valid Enfant enf,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("enfant", new Enfant());
			return("enfantsAjout");
		}
		
		
		
		if(!file.isEmpty())
		{
			


			//ServletContext servletContext = request.getSession().getServletContext();
			//String relativeWebPath = "/resources/img";
			//String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
			//String path = absoluteDiskPath ;
			//System.out.println(absoluteDiskPath);
			String path ="C:/Users/YOSRA/Desktop/PFE/ImageEnfants";
			
			
			Long idEnfant  = metier.ajouterEnfant(enf);
			file.transferTo(new File(path +"/"+ "ENFANT_" + idEnfant + "_" + file.getOriginalFilename()));
			enf.setNomPhoto(path +"/"+ "ENFANT_" +idEnfant + "_" + file.getOriginalFilename());
			metier.modifierEnfant(enf);
			
		}
		
	
		if(enf.getSexe().equals("Homme"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		else if(enf.getSexe().equals("Femme"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		
		
		if(enf.getSituationParentale().equals("MARIE"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		else if(enf.getSituationParentale().equals("DIVORCE"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		
		else if(enf.getSituationParentale().equals("PERE VEUF"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		
		else if(enf.getSituationParentale().equals("MERE VEUVE"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		
	
		
		//model.addAttribute("enfantAjout",metier.getEnfant(enf.getIdPerson()));
		
		model.addAttribute("enfant", new Enfant());
		
		
		
	
	return "enfantsAjout";
	}
	
	@RequestMapping(value="photoEnf",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoEnf(Long idEnfant) throws IOException
	{
		
		Enfant enf=metier.getEnfant(idEnfant);
		File f=new File(enf.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("enfant", new Enfant());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("enfantsAjout");
		
		return mv;
	}

}
