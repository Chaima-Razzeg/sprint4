package com.chaima.cosmetics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.entities.Rayon;
import com.chaima.cosmetics.repos.RayonRepository;
@Service
public class RayonServiceImpl implements RayonService{
	@Autowired
	RayonRepository rayonRepository;

	@Override
	public Rayon saveRayon(Rayon r) {
		return rayonRepository.save(r) ;
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		return rayonRepository.save(r);
	}

	@Override
	public void deleteRayon(Rayon r) {
		rayonRepository.delete(r);		
	}

	@Override
	public void deleteRayonByRef(Long id) {
		rayonRepository.deleteById(id);		
	}

	@Override
	public Rayon getRayon(Long id) {
		return rayonRepository.findById(id).get();
	}

	@Override
	public List<Rayon> getAllRayons() {
		return rayonRepository.findAll();
	}
	@Override
	public Page<Rayon> getAllRayonsParPage(int page, int size) {
	return rayonRepository.findAll(PageRequest.of(page, size));
	}

}
