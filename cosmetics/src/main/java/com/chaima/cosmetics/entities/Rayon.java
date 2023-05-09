package com.chaima.cosmetics.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rayon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Ref;
	@NotNull
	@Size (min = 4,max = 15)
	private String nameRan;
	@NotNull
	@Size (min = 4,max = 100)
	private String descriptionRan;
	@JsonIgnore
	@OneToMany(mappedBy = "rayon")
	private List<Cosmetic> cosmetics;
	

	

}
