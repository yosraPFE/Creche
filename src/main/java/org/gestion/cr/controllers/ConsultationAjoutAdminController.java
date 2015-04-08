package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.Consultation;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminConsA")
public class ConsultationAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("consultation", new Consultation());
		
		
		return "consultationsAjout";
		
	}
	
	@RequestMapping(value="/ajouterConsultation")
	public String ajouterConsultation(@Valid Consultation cons,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("consultation", new Consultation());
			return("consultationsAjout");
		}
		
		
		Long idConsultationAjoutee = metier.ajouterConsultation(cons);
		
		model.addAttribute("consultationAjoute",metier.getConsultation(idConsultationAjoutee));
		
		model.addAttribute("consultation", new Consultation());
		
		
		
	
	return "consultationsAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("consultation", new Consultation());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("consultationsAjout");
		
		return mv;
	}


}
