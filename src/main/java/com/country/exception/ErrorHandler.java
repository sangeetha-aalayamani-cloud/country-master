package com.country.exception;

import java.util.Date;
/**
 * 
 * @author sangeetha
 *
 */
public class ErrorHandler {
	
	private Date timestamp;
	private String errorMessage;
	private String details;

	public ErrorHandler(Date timestamp, String errorMessage, String details) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getDetails() {
		return details;
	}
}