package uk.co.meridenspares.domain.validators.exception;

import java.util.HashMap;

/**
 * An exception class used to report errors when validating domain model objects.
 * @author user
 *
 */
public class ObjectValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/** List of errors found during validation */
	private HashMap<String, String> validationErrors = new HashMap<String, String>();
	
	/**
	 * Returns the list of validation errors in the format "Entry <field, error description>" 
	 * @return
	 */
	public HashMap<String, String> getValidationErrors() {
		return validationErrors;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (String error : validationErrors.values()) {
			sb.append(error).append("; ");
		}
		
		return sb.toString();
	}
}
