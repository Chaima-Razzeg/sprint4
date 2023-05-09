package com.chaima.cosmetics.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.entities.Rayon;

public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {

		List<Cosmetic> findByCosmeticName(String nom);
		 List<Cosmetic> findByCosmeticNameContains(String nom);
		 @Query("select p from Cosmetic p where p.cosmeticName like %?1 and p.itemPrice > ?2")
		 List<Cosmetic> findByItemPrice (@Param("nom") String nom,@Param("prix") Double prix);
		 //@Query("select p from Cosmetic p where p.rayon = ?1")
		 //List<Cosmetic> findByRayon (Rayon rayon);
		 @Query("SELECT c FROM Cosmetic c WHERE c.rayon.Ref= :ref")
		 List<Cosmetic> findByRayonRef(Long ref);
		// List<Cosmetic> findByOrderByCosmeticNametAsc();



		}

