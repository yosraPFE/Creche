package org.gestion.cr.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.gestion.cr.entities.GenrePlanning;
import org.gestion.cr.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/adminGenAj")
public class GenrePlanningsAjoutAdminController implements HandlerExceptionResolver
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
		model.addAttribute("genrePlanning", new GenrePlanning());
		
		
		return "genrePlanningsAjout";
		
	}
	
	@RequestMapping(value="/ajouterGenrePlann")
	public String ajouterGenrePlann(@Valid GenrePlanning grPl,BindingResult bindingResult,
			Model model) throws IOException
	{
		
		
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("genrePlanning", new GenrePlanning());
			return("genrePlanningsAjout");
		}
		
		
		
		Long idGenrePlanningAjoute = metier.ajouterGenrePlanning(grPl);
		
		
		model.addAttribute("genrePlanningAjoute",metier.getGenrePlanning(idGenrePlanningAjoute));
		
		model.addAttribute("genrePlanning", new GenrePlanning());
	
	return "genrePlanningsAjout";
	}
	
	

    
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("genrePlanning", new GenrePlanning());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("genrePlanningsAjout");
		
		return mv;
	}



}
