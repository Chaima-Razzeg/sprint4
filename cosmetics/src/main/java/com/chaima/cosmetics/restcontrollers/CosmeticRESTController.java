package com.chaima.cosmetics.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.service.CosmeticService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CosmeticRESTController {
	@Autowired
	CosmeticService cosService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cosmetic> getAllCosmetics() {
	return cosService.getAllCosmetics();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Cosmetic getCosmeticById(@PathVariable("id") Long id) {
	return cosService.getCosmetic(id);
			
	 }
	@RequestMapping(method = RequestMethod.PUT)
	public Cosmetic updateCosmetic(@RequestBody Cosmetic cosmetic) {
	return cosService.updateCosmetic(cosmetic);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCosmetic(@PathVariable("id") Long id)
	{
	cosService.deleteCosmeticById(id);
	}
	
	@RequestMapping(value="/cosref/{Ref}",method = RequestMethod.GET)
	public List<Cosmetic> getByRefId(@PathVariable("Ref") Long Ref) {
	return cosService.findByRayonRef(Ref);
	}

	
	
	
}
