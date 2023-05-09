package com.chaima.cosmetics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.entities.Rayon;
import com.chaima.cosmetics.repos.CosmeticRepository;
import com.chaima.cosmetics.repos.RayonRepository;

@Service
public class CosmeticServiceImpl implements CosmeticService {

	@Autowired
	CosmeticRepository cosmeticRepository;
	@Autowired
	RayonRepository rayonRepository;
	@Override
	public Cosmetic saveCosmetic(Cosmetic c) {
		return cosmeticRepository.save(c);
	}

	@Override
	public Cosmetic updateCosmetic(Cosmetic c) {
		return cosmeticRepository.save(c);
	}

	@Override
	public void deleteCosmetic(Cosmetic c) {
		cosmeticRepository.delete(c);		
	}

	@Override
	public void deleteCosmeticById(Long id) {
		cosmeticRepository.deleteById(id);
		
	}

	@Override
	public Cosmetic getCosmetic(Long id) {
		return cosmeticRepository.findById(id).get();
	}

	@Override
	public List<Cosmetic> getAllCosmetics() {
		return cosmeticRepository.findAll();
	}
	@Override
	public Page<Cosmetic> getAllCosmeticsParPage(int page, int size) {
	return cosmeticRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Cosmetic> findByCosmeticName(String nom) {
		return cosmeticRepository.findByCosmeticName(nom);
	}

	@Override
	public List<Cosmetic> findByCosmeticNameContains(String nom) {
		return cosmeticRepository.findByCosmeticNameContains(nom);

	}

	@Override
	public List<Cosmetic> findByCosmeticNameItemPrice(String nom, Double prix) {
		return cosmeticRepository.findByItemPrice(nom, prix);
	}

	//@Override
	//public List<Cosmetic> findByRayon(Long rayon) {
		//return cosmeticRepository.findByRayonRef(rayon);
	//}

	@Override
	public List<Cosmetic> findByRayonRef(Long id) {
		return cosmeticRepository.findByRayonRef(id);
	}

	@Override
	public List<Cosmetic> findByRayon(Rayon rayon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cosmetic> findByOrderByCosmeticNameAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rayon> getAllRayons() {
		return rayonRepository.findAll();
	}

	//@Override
	//public List<Cosmetic> findByOrderByCosmeticNameAsc() {
	//	return cosmeticRepository.findByOrderByCosmeticNametAsc();
	//}

}
