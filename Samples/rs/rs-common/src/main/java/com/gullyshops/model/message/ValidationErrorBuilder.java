package com.gullyshops.model.message;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

/**
 * 
 * @author Munisekhar
 *
 */
public class ValidationErrorBuilder {
	
	/**
	 * Instantiates a new validation error builder.
	 */
	private ValidationErrorBuilder() {

	}
	
	/**
	 * Builds the error list.
	 *
	 * @param errors the errors
	 * @return the validation error
	 */
	public static ValidationError buildErrorList(Errors errors) {
        ValidationError error = new ValidationError();
        for (FieldError fieldError : errors.getFieldErrors()) {
            error.addError(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return error;
    }
	
}
