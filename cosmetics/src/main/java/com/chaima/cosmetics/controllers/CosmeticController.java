package com.chaima.cosmetics.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.entities.Rayon;
import com.chaima.cosmetics.service.CosmeticService;
import com.chaima.cosmetics.service.RayonService;

import jakarta.validation.Valid;

@Controller
public class CosmeticController {
	@Autowired
	CosmeticService cosmeticService;
	@Autowired
	RayonService rayonService;
	
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Rayon> cats = cosmeticService.getAllRayons();
		Cosmetic prod = new Cosmetic();
		Rayon cat = new Rayon();
		cat = cats.get(0); // prendre la première catégorie de la liste
		prod.setRayon(cat); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
		modelMap.addAttribute("cosmetic",prod);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("rayons", cats);
        modelMap.addAttribute("page",0);

		return "formCosmetic";
	}


	
	
	
	
	@RequestMapping("/saveCosmetic")
	public String saveCosmetic(@Valid Cosmetic cosmetic,
	BindingResult bindingResult,    @ModelAttribute("page") int pageFromPrevious,
	@RequestParam (name="size", defaultValue = "2") int size,
	RedirectAttributes redirectAttributes,							  ModelMap modelMap
)
	  {
	    int page;
	    if (bindingResult.hasErrors())
		    	{
	    	List<Rayon> cats = cosmeticService.getAllRayons();
		
		    	modelMap.addAttribute("rayons", cats);
		    	//même on est en mode ajout (mode="new"), en passe le mode edit pour garder la catégorie 
		    	//selectionnée dans la liste, pour mieux le comprendre essayer de passer le mode "new"
		    	 modelMap.addAttribute("mode", "edit");
		    	 return "formCosmetic";
		    	}
	    if (cosmetic.getCosmeticReference()==null) //adding
	        page = cosmeticService.getAllCosmetics().size()/size; // calculer le nbr de pages
	    else //updating
	        page = pageFromPrevious;
	   
	    cosmeticService.saveCosmetic(cosmetic);
	   
	    redirectAttributes.addAttribute("page", page);
	    return "redirect:/ListCosmetics";
	    }


	
	
	
	
	
	
	
	@RequestMapping("/ListCosmetics")
	public String listCosmetics(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Cosmetic> cosms = cosmeticService.getAllCosmeticsParPage(page, size);
	modelMap.addAttribute("cosmetics", cosms);
	 modelMap.addAttribute("pages", new int[cosms.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listCosmetics";
	}
	@RequestMapping("/supprimerCosmetic")
	public String supprimerCosmetic(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	cosmeticService.deleteCosmeticById(id);
	Page<Cosmetic> cosms = cosmeticService.getAllCosmeticsParPage(page, 
	size);
	modelMap.addAttribute("cosmetics", cosms);
	modelMap.addAttribute("pages", new int[cosms.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listCosmetics";
	}
	
	@RequestMapping("/modifierCosmetic")
    public String editerCosmetic(@RequestParam("id") Long id, 
    		@RequestParam("page") int page,
    		ModelMap modelMap
    		) {
        Cosmetic cosmetic = cosmeticService.getCosmetic(id);
        List<Rayon> rayons = rayonService.getAllRayons();
        modelMap.addAttribute("cosmetic", cosmetic);
        modelMap.addAttribute("rayons", rayons);
        modelMap.addAttribute("selectedRayon", cosmetic.getRayon());
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("page",page);
        return "formCosmetic";
    }

	@RequestMapping("/updateCosmetic")
	public String updateCosmetic(@ModelAttribute("cosmetic") Cosmetic cosmetic,
			@ModelAttribute("page") int page, 
			ModelMap modelMap,
    		RedirectAttributes redirectAttributes) 
	{
		  cosmeticService.updateCosmetic(cosmetic);
		  List<Cosmetic> prods = cosmeticService.getAllCosmetics();
		  modelMap.addAttribute("cosmetics", prods);
		  modelMap.addAttribute("page", page);	

	   // redirectAttributes.addAttribute("page", page);
	   // redirectAttributes.addAttribute("currentPage", page);
		    redirectAttributes.addAttribute("id", cosmetic.getCosmeticReference());
		    redirectAttributes.addAttribute("page", page);
		    return "redirect:/ListCosmetics";
	}

}
