package com.chaima.cosmetics.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.entities.Rayon;
import com.chaima.cosmetics.service.RayonService;

import jakarta.validation.Valid;

@Controller

public class RayonController {
	@Autowired
	RayonService rayonService;
	
	@RequestMapping("/Create")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("rayon", new Rayon());
	modelMap.addAttribute("mode", "new");
	return "formRayon";
	}


	
	
	
	
	@RequestMapping("/saveRayon")
	public String saveRayon(@Valid Rayon rayon,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formRayon";

	rayonService.saveRayon(rayon);
	return "formRayon";
	}


	
	
	
	
	
	
	
	@RequestMapping("/ListRayons")
	public String listRayons(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Rayon> rays = rayonService.getAllRayonsParPage(page, size);
	modelMap.addAttribute("rayons", rays);
	 modelMap.addAttribute("pages", new int[rays.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listRayons";
	}
	@RequestMapping("/supprimerRayon")
	public String supprimerRayon(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	rayonService.deleteRayonByRef(id);
	Page<Rayon> rays = rayonService.getAllRayonsParPage(page, 
	size);
	modelMap.addAttribute("rayons", rays);
	modelMap.addAttribute("pages", new int[rays.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listRayons";
	}
	
	
	@RequestMapping("/modifierRayon")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Rayon p= rayonService.getRayon(id);
	modelMap.addAttribute("rayon", p);
	modelMap.addAttribute("mode", "edit");
	return "formRayon";
	}

	
	


	

}
