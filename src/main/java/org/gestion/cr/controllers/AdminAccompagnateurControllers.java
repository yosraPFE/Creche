package org.gestion.cr.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.gestion.cr.entities.Accompagnateur;
import org.gestion.cr.entities.Enfant;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping(value="/adminAccomp")



public class AdminAccompagnateurControllers implements HandlerExceptionResolver
{
	/*
	 * on realise l'injection de dependance via cette annotation ,c a d demander a spring 
	 * au moment de demarrage de chercher un objet qui implemente l'interface si dessous
	 */
	
	@Autowired
	//il faut faire appel à la couche metier via l'interface metier
	
	private IAdminMetier metier;
	
	
	
	
	//creation d'une methode "index"
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		model.addAttribute("accompagnateur", new Accompagnateur());//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("accompagnateurs",metier.listAccompagnateurs());//les donneés seront recuperées dans la liste des Enfants
		
		return "accompagnateurs";
		
	}
	
	
	 /*
	 * @Valid : pour verifier que tous les validation indiqué dans la classe Accompagnateur sont faites
	 * pour gerer les erreurs de validation on utilise "BindingResult",et "MultipartFile" pour le upload des photo
	 */
	
	@RequestMapping(value="/ajouterAccompagnateur")
	public String ajouterAccompagnateur(@Valid Accompagnateur accomp,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		//Tester si il  ya des erreurs
		if(bindingResult.hasErrors())
		{
			model.addAttribute("accompagnateurs",metier.listAccompagnateurs());
			return("accompagnateurs");
		}
		//verifier si le fichier de parcours des photo n'est pas vide
		if(!file.isEmpty())
		{
			//veirifier si la varix pfoto ou non,,ImageIO=image input/output
			BufferedImage bi=ImageIO.read(file.getInputStream());
			accomp.setPhoto(file.getBytes());
			//ou on va recuperer la photo
			accomp.setNomPhoto(file.getOriginalFilename());
			
		}
		
		Long ref=accomp.getIdPerson();
		String referrerAffiliateId = null;
		if(ref!=null)
		{
			referrerAffiliateId = Long.toString(ref);
			//si le idAccompagnateur est different de null il faut faire le mise a jours
			
				if(file.isEmpty())
				{
				Accompagnateur accompa=metier.getAccompagnateur(accomp.getIdPerson()); 
				accomp.setPhoto(accompa.getPhoto());
				}
			
			metier.modifierAccompagnateurs(accomp);
		}
		else
		metier.ajouterAccompagnateur(accomp);
		model.addAttribute("accompagnateur", new Accompagnateur());//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("accompagnateurs",metier.listAccompagnateurs());//les donneés seront recuperées dans la liste des Enfants
		
		return "accompagnateurs";
		
	}
	//produces c'est une proprieté car on va pas retourner du texte mais une image JPEG
	
	@RequestMapping(value="photoAccomp",produces=MediaType.IMAGE_JPEG_VALUE)
	
	//@ResponseBody c'est une annotation du SpringMvc signifie que le resultat doit etre retourné dans le coeur de la reponse et non dans une autre vue
	
	@ResponseBody
	public byte[]photoAccomp(Long idAccompagnateur) throws IOException
	{
		Accompagnateur accomp=metier.getAccompagnateur(idAccompagnateur);
		return IOUtils.toByteArray(new ByteArrayInputStream(accomp.getPhoto()));
	}

    //Methode de l'interface " HandlerExceptionResolver" pour la gestion des Exceptions
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		//creation d'un objet de type "ModelAndView" de Spring
		ModelAndView mv=new ModelAndView();
		mv.addObject("accompagnateur", new Accompagnateur());
		mv.addObject("accompagnateurs",metier.listAccompagnateurs());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("accompagnateurs");
		
		return mv;
	}
	@RequestMapping(value="/supprimerAccompagnateur")
	public String supprimerAccompagnateur(Long idAccompagnateur,Model model)
	{
		metier.supprimerAccompagnateurs(idAccompagnateur);
		model.addAttribute("accompagnateur", new Accompagnateur());//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("accompagnateurs",metier.listAccompagnateurs());//les donneés seront recuperées dans la liste des Enfants
		
		return "accompagnateurs";
		
	}
	
	
	@RequestMapping(value="/modifierAccompagnateur")
	public String modifierAccompagnateur(Long idAccompagnateur,Model model)
	{
		
		Accompagnateur accomp=metier.getAccompagnateur(idAccompagnateur);
		//placer l'element edité ("modifieAccom") dans une session ,c a d indiquer a SpringMVC de placer cet attribut dans un session
		
		model.addAttribute("accompagnateur",accomp );//"enfant" c'est le nom du model utilisé dans la page "enfants.jsp"
		model.addAttribute("accompagnateurs",metier.listAccompagnateurs());//les donneés seront recuperées dans la liste des Enfants
		
		return "accompagnateurs";
		
	}
	




 @RequestMapping(value="/SupprimerAccompagnateur")
  	public String SupprimerAccompagnateur(Long idAccompagnateur,Model model)
  	{
  		metier.supprimerAccompagnateurs(idAccompagnateur);
  		model.addAttribute("accompagnateur", new Accompagnateur());
  		model.addAttribute("accompagnateurs",metier.listAccompagnateurs());
  		
  		return "accompagnateurs";
  		
  	}
 	 
 	@RequestMapping(value="/modifierAjoutAccompagnateur")
 	public String modifierAjoutAccompagnateur(Long idAccompagnateur,Model model)
 	{
 		
 		Accompagnateur accomp=metier.getAccompagnateur(idAccompagnateur);
 		
 		
 		model.addAttribute("accompagnateur",accomp );
 		model.addAttribute("accompagnateurs",metier.listAccompagnateurs());
 		
 		return "accompagnateurs";
 		
 	}
}