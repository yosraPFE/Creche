package org.gestion.cr.controllers;

import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.metier.IAdminMetier;

import org.junit.experimental.runners.Enclosed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

@RequestMapping(value="/adminEnfant")
public class AdminEnfantController implements HandlerExceptionResolver
{
	@Autowired
	private IAdminMetier metier;
	
	
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		model.addAttribute("enfant", new Enfant());//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("enfants",metier.listEnfants());//les donneés seront recuperées dans la liste des Enfants
		
		return "enfants";
		
	}
	
	
	@RequestMapping(value="/ajouterEnfant")
	public String ajouterEnfant(@Valid Enfant enf,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		//Tester si il  ya des erreurs
		if(bindingResult.hasErrors())
		{
			model.addAttribute("enfants",metier.listEnfants());
			return("enfants");
		}
		//verifier si le fichier de parcours des photo n'est pas vide
		if(!file.isEmpty())
		{
			//veirifier si la varix pfoto ou non,,ImageIO=image input/output
			BufferedImage bi=ImageIO.read(file.getInputStream());
			enf.setPhoto(file.getBytes());
			//ou on va recuperer la photo
			enf.setNomPhoto(file.getOriginalFilename());
			
		}
		
		Long ref=enf.getIdPerson();
		String referrerAffiliateId = null;
		if(ref!=null)
		{
			referrerAffiliateId = Long.toString(ref);
			//si le idAccompagnateur est different de null il faut faire le mise a jours
			
				if(file.isEmpty())
				{
				Enfant enfen=metier.getEnfant(enf.getIdPerson()); 
				enf.setPhoto(enfen.getPhoto());
				}
			
			metier.modifierEnfant(enf);
		}
		else
		metier.ajouterEnfant(enf);
		model.addAttribute("enfant", new Enfant());//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("enfants",metier.listEnfants());//les donneés seront recuperées dans la liste des Enfants
		
		return "enfants";
		
	}
	//produces c'est une proprieté car on va pas retourner du texte mais une image JPEG
	
	@RequestMapping(value="photoEnf",produces=MediaType.IMAGE_JPEG_VALUE)
	
	//@ResponseBody c'est une annotation du SpringMvc signifie que le resultat doit etre retourné dans le coeur de la reponse et non dans une autre vue
	
	@ResponseBody
	public byte[]photoEnf(Long idEnfant) throws IOException
	{
		Enfant enf=metier.getEnfant(idEnfant);
		return IOUtils.toByteArray(new ByteArrayInputStream(enf.getPhoto()));
	}

    //Methode de l'interface " HandlerExceptionResolver" pour la gestion des Exceptions
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		//creation d'un objet de type "ModelAndView" de Spring
		ModelAndView mv=new ModelAndView();
		mv.addObject("enfant", new Enfant());
		mv.addObject("enfants",metier.listEnfants());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("enfants");
		
		return mv;
	}
	@RequestMapping(value="/supprimerEnfant")
	public String supprimerEnfant(Long idEnfant,Model model)
	{
		metier.supprimerEnfant(idEnfant);
		model.addAttribute("enfant", new Enfant());//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("enfants",metier.listEnfants());//les donneés seront recuperées dans la liste des Enfants
		
		return "enfants";
		
	}
	
	
	@RequestMapping(value="/modifierEnfant")
	public String modifierEnfant(Long idEnfant,Model model)
	{
		
		Enfant enf=metier.getEnfant(idEnfant);
		//placer l'element edité ("modifieAccom") dans une session ,c a d indiquer a SpringMVC de placer cet attribut dans un session
		
		model.addAttribute("enfant",enf );//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("enfants",metier.listEnfants());//les donneés seront recuperées dans la liste des Enfants
		
		return "enfants";
		
	}
	
}
