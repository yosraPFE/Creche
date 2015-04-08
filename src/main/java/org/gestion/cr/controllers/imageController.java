package org.gestion.cr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/img")
public class imageController 
{
	// index
			@RequestMapping(value = "/index")
			public String test() {
				
				return "image";

			}

}
