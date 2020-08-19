package com.country.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.country.model.Country;
/**
 * 
 * @author sangeetha
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
