package com.country.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="country")
	private String country;
	
	@Column(name="population")
	private BigInteger population;
	
	public long getId() {
		return id;
	}
	public void setId(long id2) {
		this.id = id2;
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
