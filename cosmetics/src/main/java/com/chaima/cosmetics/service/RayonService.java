package com.chaima.cosmetics.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.chaima.cosmetics.entities.Rayon;

public interface RayonService {
	Rayon saveRayon(Rayon r);
	Rayon updateRayon(Rayon r);
	void deleteRayon(Rayon r);
	 void deleteRayonByRef(Long id);
	Rayon getRayon(Long id);
	List<Rayon> getAllRayons();
	Page<Rayon> getAllRayonsParPage(int page, int size);


}
