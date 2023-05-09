package com.chaima.cosmetics.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.entities.Rayon;

public interface CosmeticService {
	Cosmetic saveCosmetic(Cosmetic c);
	Cosmetic updateCosmetic(Cosmetic c);
	void deleteCosmetic(Cosmetic c);
	 void deleteCosmeticById(Long id);
	Cosmetic getCosmetic(Long id);
	List<Cosmetic> getAllCosmetics();
	Page<Cosmetic> getAllCosmeticsParPage(int page, int size);
	List<Cosmetic> findByCosmeticName(String nom);
	List<Cosmetic> findByCosmeticNameContains(String nom);
	List<Cosmetic> findByCosmeticNameItemPrice (String nom, Double prix);
	List<Cosmetic> findByRayon (Rayon rayon);
	List<Cosmetic> findByRayonRef(Long id);
	List<Cosmetic> findByOrderByCosmeticNameAsc();
	 List<Rayon> getAllRayons();



}
