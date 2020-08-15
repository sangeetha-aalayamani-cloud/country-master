package com.country.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.country.model.Country;
/**
 * 
 * @author sangeetha
 *
 */
@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
