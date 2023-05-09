package com.chaima.cosmetics.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
@Entity
public class Cosmetic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cosmeticReference;
	@NotNull
	@Size (min = 4,max = 15)
	private String cosmeticName;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Min(value = 10)
	 @Max(value = 10000)
	private Double itemPrice;
	private Date expirationDate;
	@ManyToOne
public Rayon rayon;
	public Cosmetic() {
		super();
	}

	public Cosmetic(String cosmeticName, Double itemPrice, Date expirationDate) {
		super();
		this.cosmeticName = cosmeticName;
		this.itemPrice = itemPrice;
		this.expirationDate = expirationDate;
	}

	public Long getCosmeticReference() {
		return cosmeticReference;
	}

	public void setCosmeticReference(Long cosmeticReference) {
		this.cosmeticReference = cosmeticReference;
	}

	public String getCosmeticName() {
		return cosmeticName;
	}

	public void setCosmeticName(String cosmeticName) {
		this.cosmeticName = cosmeticName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Cosmetic [cosmeticReference=" + cosmeticReference + ", cosmeticName=" + cosmeticName + ", itemPrice="
				+ itemPrice + ", expirationDate=" + expirationDate + "]";
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}


	
	

	
	
	

	
	

}
