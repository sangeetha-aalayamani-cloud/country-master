package com.country.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.model.Country;
import com.country.repository.CountryRepository;

/**
 * 
 * @author sangeetha
 *
 */
@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	/**
	 * Get all country details
	 * 
	 * @return
	 */
	public List<Country> retrieveDetails() {
		List<Country> country = new ArrayList<>();
		countryRepository.findAll().forEach(country::add);
		return country;
	}

	/**
	 * fetch country details by id
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Country> findById(Long id) {
		return countryRepository.findById(id);
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean addCountry(Country c) {
		Optional<Country> list = countryRepository.findById(c.getId());
		if (list.isPresent()) {
			return false;
		} else {
			countryRepository.save(c);
		}
		return true;
	}

	/**
	 * delete By Id
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		countryRepository.deleteById(id);
	}

	/**
	 * update country
	 * 
	 * @param country
	 */
	public void updateCountry(Country country) {
		countryRepository.save(country);
	}
}