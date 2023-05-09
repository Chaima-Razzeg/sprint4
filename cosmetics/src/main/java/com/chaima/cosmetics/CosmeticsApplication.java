package com.chaima.cosmetics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chaima.cosmetics.service.CosmeticService;

@SpringBootApplication
public class CosmeticsApplication implements CommandLineRunner {
	@Autowired
	CosmeticService cosmeticService;

	public static void main(String[] args) {
		SpringApplication.run(CosmeticsApplication.class, args);
		}
		@Override
		public void run(String... args) throws Exception {
		//cosmeticService.saveCosmetic(new Cosmetic("PC Dell", 2600.0, new Date()));
		//cosmeticService.saveCosmetic(new Cosmetic("PC Asus", 2800.0, new Date()));
		//cosmeticService.saveCosmetic(new Cosmetic("Imprimante Epson", 900.0, new Date()));

}}
