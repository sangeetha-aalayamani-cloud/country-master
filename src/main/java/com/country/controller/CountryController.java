package com.country.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.country.exception.CountryNotFoundException;
import com.country.model.Country;
import com.country.service.CountryService;

/**
 * 
 * @author sangeetha
 *
 */

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	CountryService countryService;

	/**
	 * Get all country details
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCountryDetails", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<List<Country>> getCountryDetails() {
		List<Country> c = countryService.retrieveDetails();
		if (c.size() > 0) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * Get Country by ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCountryById/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Country> getCountryById(@PathVariable("id") long id) throws CountryNotFoundException {
		Country o = countryService.findById(id)
				.orElseThrow(() -> new CountryNotFoundException("Country not found for " + id));
		return new ResponseEntity<>(o, HttpStatus.OK);
	}

	/**
	 * update Country
	 * 
	 * @param country
	 * @return
	 */
	@RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Country> updateCountry(@RequestBody Country country, @PathVariable("id") long id) {
		Optional<Country> c = countryService.findById(id);

		if (!c.isPresent())
			return ResponseEntity.notFound().build();

		country.setId(id);

		countryService.updateCountry(country);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}

	/**
	 * Add Country
	 *  
	 * @param country
	 * @param builder
	 * @return
	 */
	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> addCountry(@RequestBody Country country, UriComponentsBuilder builder) {
		boolean flag = countryService.addCountry(country);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/getCountryById/{id}").buildAndExpand(country.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * delete Country By Id
	 * 
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCountryById/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteCountryById(@PathVariable String id) {

		Long countryId = Long.parseLong(id);

		countryService.deleteById(countryId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

}
