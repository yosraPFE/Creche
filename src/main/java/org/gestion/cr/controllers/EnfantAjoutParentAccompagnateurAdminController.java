package org.gestion.cr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
@RequestMapping(value="/adminEPA")
public class EnfantAjoutParentAccompagnateurAdminController implements HandlerExceptionResolver
{
	
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@Autowired
	private IAdminMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model)
	{
		model.addAttribute("enfant", new Enfant());
		model.addAttribute("parent", new Parent());
		model.addAttribute("accompagnateur", new Accompagnateur());
		
		
		
		return "enfantsAvecParentAccompagnateurAjout";
		
	}
	
	@RequestMapping(value="/ajouterEnfantParentAccompagnateur")
	public String ajouterEnfantParentAccompagnateur(@Valid Enfant enf,@Valid Parent par, @Valid Accompagnateur accomp ,BindingResult bindingResult,
			Model model,MultipartFile file,MultipartFile filePar,MultipartFile fileAcom) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("enfant", new Enfant());
			model.addAttribute("parent", new Parent());
			model.addAttribute("accompagnateur", new Accompagnateur());
			return("enfantsAvecParentAccompagnateurAjout");
		}
		
		
		
		if((!file.isEmpty())&&(!filePar.isEmpty())&&(!fileAcom.isEmpty()))
		{
			


			//ServletContext servletContext = request.getSession().getServletContext();
			//String relativeWebPath = "/resources/img";
			//String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
			//String path = absoluteDiskPath ;
			//System.out.println(absoluteDiskPath);
			
			
			String path ="C:/Users/YOSRA/Desktop/PFE/ImageEnfants";
			String pathPa ="C:/Users/YOSRA/Desktop/PFE/ImagesParents";
			String pathAcc ="C:/Users/YOSRA/Desktop/PFE/ImageAccompagnateurs";
			
			
			Long idEnfant  = metier.ajouterEnfant(enf);
			file.transferTo(new File(path +"/"+ "ENFANT_" + idEnfant + "_" + file.getOriginalFilename()));
			enf.setNomPhoto(path +"/"+ "ENFANT_" +idEnfant + "_" + file.getOriginalFilename());
			metier.modifierEnfant(enf);
			
			
			
			Long idParent = metier.ajouterParent(par);
			filePar.transferTo(new File(pathPa + "/" + "PARENT_" + idParent + "_"+ filePar.getOriginalFilename()));
			par.setNomPhoto(pathPa + "/" + "PARENT_" + idParent + "_"+ filePar.getOriginalFilename());
			metier.modifierParent(par);
			
			
			Long idAccompagnateur  = metier.ajouterAccompagnateur(accomp);
			fileAcom.transferTo(new File(pathAcc+"/"+"ACCOMPAGNATEUR_" + idAccompagnateur + "_" + fileAcom.getOriginalFilename()));//il peut construire le nouveau nom
			accomp.setNomPhoto(pathAcc+"/"+"ACCOMPAGNATEUR_" +idAccompagnateur + "_" + fileAcom.getOriginalFilename());//affecter le nom de la photo a l'acc precedement cree
			metier.modifierAccompagnateurs(accomp);
			
		}
		
	
		if(enf.getSexe().equals("Homme"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		else if(enf.getSexe().equals("Femme"))
		{
			model.addAttribute("enfants",metier.listEnfants(0,4));
		}
		
		
		if (enf.getLangue().equals("Arabe")){
			model.addAttribute("enfants", metier.listEnfants(0, 4));
		} else if (enf.getLangue().equals("Français")) {
			model.addAttribute("enfants", metier.listEnfants(0, 4));
		}else if (enf.getLangue().equals("Anglais")) {
			model.addAttribute("enfants", metier.listEnfants(0, 4));
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
		
		
		
		
		if (par.getGenre().equals("Papa")) {
			model.addAttribute("parents", metier.getParent(par.getIdPerson()));
		} else if (par.getGenre().equals("Maman")) {
			model.addAttribute("parents", metier.getParent(par.getIdPerson()));
		}
		
		
		
	
		
		//model.addAttribute("enfantAjout",metier.getEnfant(enf.getIdPerson()));
		//model.addAttribute("accompagnateurAjoute",metier.getEnfant(enf.getIdPerson()));
		//model.addAttribute("accompagnateurAjoute",metier.getEnfant(enf.getIdPerson()));
		
		model.addAttribute("enfant", new Enfant());
		model.addAttribute("parent", new Parent());
		model.addAttribute("accompagnateur", new Accompagnateur());
		
		
		
	
	return "enfantsAvecParentAccompagnateurAjout";
	}
	
	@RequestMapping(value="photoEnf",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoEnf(Long idEnfant) throws IOException
	{
		
		Enfant enf=metier.getEnfant(idEnfant);
		File f=new File(enf.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	
	
	@RequestMapping(value = "photoParent", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoParent(Long idParent) throws IOException {

		Parent par = metier.getParent(idParent);
		File fp = new File(par.getNomPhoto());
		return IOUtils.toByteArray(new FileInputStream(fp));
	}
	
	
	
	
	@RequestMapping(value="photoAccomp",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	
	public byte[]photoAccomp(Long idAccompagnateur) throws IOException
	{
		
		Accompagnateur accomp=metier.getAccompagnateur(idAccompagnateur);
		File fc=new File(accomp.getNomPhoto()); 
		return IOUtils.toByteArray(new FileInputStream(fc));
	}
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("enfant", new Enfant());
		mv.addObject("parent", new Parent());
		mv.addObject("accompagnateur", new Accompagnateur());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("enfantsAvecParentAccompagnateurAjout");
		
		return mv;
	}
	
	@RequestMapping(value="/ajouterAccompagnateurEP")
	public void ajouterAccompagnateurEP(@Valid Accompagnateur accomp,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("accompagnateur", new Accompagnateur());
			
		}
		
		
		
		if(!file.isEmpty())
		{
			
			
			String path = "C:/Users/YOSRA/Desktop/PFE/ImageAccompagnateurs";
			
			Long idAccompagnateur  = metier.ajouterAccompagnateur(accomp);
			file.transferTo(new File(path+"/"+"ACCOMPAGNATEUR_" + idAccompagnateur + "_" + file.getOriginalFilename()));//il peut construire le nouveau nom
			accomp.setNomPhoto(path+"/"+"ACCOMPAGNATEUR_" +idAccompagnateur + "_" + file.getOriginalFilename());//affecter le nom de la photo a l'acc precedement cree
			metier.modifierAccompagnateurs(accomp);
			
		}
		
	
		
		model.addAttribute("accompagnateurAjoute",metier.getAccompagnateur(accomp.getIdPerson()));
		
		model.addAttribute("accompagnateur", new Accompagnateur());
	
	}
	
	@RequestMapping(value="/ajouterParentEA")
	public void ajouterParentEA(@Valid Parent par, BindingResult bindingResult,
			Model model, MultipartFile file) throws IOException {

		if (bindingResult.hasErrors()) {

			model.addAttribute("parent", new Parent());
			
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
	}
	@RequestMapping(value="/ajouterEnfantPA")
	public String ajouterEnfantPA(@Valid Enfant enf,BindingResult bindingResult,
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
		model.addAttribute("parent", new Parent());
		model.addAttribute("accompagnateur", new Accompagnateur());
		
		
		
		return "enfantsAvecParentAccompagnateurAjout";
		
		
		
	
	}
	
	
	


}
