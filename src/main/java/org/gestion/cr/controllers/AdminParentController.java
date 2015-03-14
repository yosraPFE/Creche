package org.gestion.cr.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
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
@RequestMapping(value="/adminParent")
public class AdminParentController implements HandlerExceptionResolver
{
	@Autowired
	private IAdminMetier metier;
	
	
	
	//creation d'une methode "index"
	
		@RequestMapping(value="/index")
		public String index(Model model)
		{
			model.addAttribute("genres",metier.listGenre());
			model.addAttribute("parent", new Parent());
			model.addAttribute("parents",metier.listParents());
			
			return "parents";
			
		}
		
		
		
		
		@RequestMapping(value="/ajouterParent")
		public String ajouterParent(@Valid Parent par,BindingResult bindingResult,
				Model model,MultipartFile file) throws IOException
		{
			//model.addAttribute("genres",metier.listGenre());
			
			if(bindingResult.hasErrors())
			{
				model.addAttribute("genres",metier.listGenre());
				model.addAttribute("parents",metier.listParents());
				return("parents");
			}
			
			
			
			if(!file.isEmpty())//si il ya un upload
			{
				//enregistrer dans le fichier contenant le nom du parents dans un fichier
				//prendre le shema
				
				String path=System.getProperty("");
				//par.setNomPhoto(path);
				Long idParent=metier.ajouterParent(par, par.getGenre().getIdGenre());
				par.setNomPhoto(file.getOriginalFilename());
				file.transferTo(new File(path+"/"+"PARENT_" +idParent+"_"+file.getOriginalFilename()));
				
			}
			
			Long ref=par.getIdPerson();
			String referrerAffiliateId = null;
			if(ref!=null)
			{
				referrerAffiliateId = Long.toString(ref);
				
				
					if(file.isEmpty())
					{
					Parent paren=metier.getParent(par.getIdPerson()); 
					par.setPhoto(paren.getPhoto());
					}
				
				metier.modifierParent(par);
			}
			
			else
			{
				metier.ajouterParent(par, par.getGenre().getIdGenre());
			}
			model.addAttribute("parent", new Parent());
			model.addAttribute("parents",metier.listParents());
			model.addAttribute("genres",metier.listGenre());
			
			
		
		return "parents";
		}
		//traitement de la photo qu'on a deja recuperée
		@RequestMapping(value="photoParent",produces=MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[]photoParent(Long idParent) throws IOException
		{
			//je la recupere a partir de la base de donnée
			Parent par=metier.getParent(idParent);
			File f=new File(System.getProperty(""+"/"+"PARENT_" +idParent+"_"+par.getNomPhoto())); //changement du path du fichier
			return IOUtils.toByteArray(new FileInputStream(f));
		}

	    //Methode de l'interface " HandlerExceptionResolver" pour la gestion des Exceptions
		@Override
		public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
		{
			//creation d'un objet de type "ModelAndView" de Spring
			ModelAndView mv=new ModelAndView();
			mv.addObject("parent", new Parent());
			mv.addObject("parents",metier.listParents());
			mv.addObject("exception", ex.getMessage());
			mv.setViewName("parents");
			
			return mv;
		}
		@RequestMapping(value="/supprimerParent")
		public String supprimerParent(Long idParent,Model model)
		{
			metier.supprimerParent(idParent);
			model.addAttribute("parent", new Parent());
			model.addAttribute("parents",metier.listParents());
			
			return "parents";
			
		}
		
		
		@RequestMapping(value="/modifierParent")
		public String modifierParent(Long idParent,Model model)
		{
			model.addAttribute("genres",metier.listGenre());
			Parent par=metier.getParent(idParent);
			
			
			model.addAttribute("parent",par );
			model.addAttribute("parents",metier.listParents());
			
			return "parents";
			
		}
		

	
}