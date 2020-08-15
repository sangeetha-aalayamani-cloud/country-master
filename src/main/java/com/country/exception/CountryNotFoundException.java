package com.country.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author sangeetha
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends Exception {

		private static final long serialVersionUID = 1L;

		public CountryNotFoundException(String errorMessage){
	    	super(errorMessage);
	    }
}
