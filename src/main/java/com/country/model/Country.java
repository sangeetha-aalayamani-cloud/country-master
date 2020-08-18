package com.country.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="country")
	private String country;

	@Column(name="population")
	private BigInteger population;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public BigInteger getPopulation() {
		return population;
	}
	public void setPopulation(BigInteger population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + ", population=" + population + "]";
	}	
}
