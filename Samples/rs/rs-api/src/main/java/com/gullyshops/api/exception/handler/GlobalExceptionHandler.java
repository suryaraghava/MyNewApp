package com.gullyshops.api.exception.handler;


import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gullyshops.exception.AlreadyExistsException;
import com.gullyshops.exception.DataNotFoundException;
import com.gullyshops.exception.ElementNotFoundException;
import com.gullyshops.exception.InvalidDateException;
import com.gullyshops.exception.ServiceException;
import com.gullyshops.exception.UserTypeMisMatchException;
import com.gullyshops.model.message.Message;
import com.gullyshops.model.message.ValidationError;
import com.gullyshops.model.message.ValidationErrorBuilder;
import com.gullyshops.repository.exception.DuplicateEntryException;


/**
 * 
 * @author Munisekhar
 *
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Default error handler.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the string
	 * @throws Exception the exception
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Message> handleException(Exception ex) throws Exception {
		String msg;
		HttpStatus status;
		if(ex instanceof ElementNotFoundException ||  ex instanceof DataNotFoundException || ex instanceof ConstraintViolationException) {
			status = HttpStatus.NOT_FOUND;
			msg = ex.getMessage();
		} else if(ex instanceof AlreadyExistsException || ex instanceof DuplicateEntryException) {
			status = HttpStatus.CONFLICT;
			msg = ex.getMessage();
		} else if(ex instanceof BadCredentialsException) {
			status = HttpStatus.UNAUTHORIZED;
			msg = ex.getMessage();
		}else if(ex instanceof UserTypeMisMatchException) {
			status = HttpStatus.FAILED_DEPENDENCY;
			msg = ex.getMessage();
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			msg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		}
		Message message = new Message.MessageBuilder()
				.error(msg)
				.build();
		return new ResponseEntity<>(message, status);
	}

	/**
	 * Handles service exception.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<Message> handleServiceException(ServiceException ex) throws Exception {
		return handleException(ex);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ValidationError error = ValidationErrorBuilder.buildErrorList(ex.getBindingResult());
		return new ResponseEntity<>(error, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errorMsg;
		if(ex.getCause() instanceof JsonParseException){
			errorMsg = "Invalid JSON format";
		}else if(ex.getCause() instanceof InvalidFormatException){
			InvalidFormatException exe = (InvalidFormatException) ex.getCause();
			ValidationError error = buildErrorList(exe.getPath());
			return new ResponseEntity<>(error, status);
		}else if(ex.getCause() instanceof JsonMappingException) {
			JsonMappingException exe = (JsonMappingException) ex.getCause();
			errorMsg = exe.getCause().getMessage();
		}else if(ex.getCause() instanceof InvalidDateException) {
			InvalidDateException exe = (InvalidDateException) ex.getCause();
			errorMsg = exe.getMessage();
		}else{
			errorMsg = "Request body is empty. Excepted JSON as an input";
		}
		
		Message message = new Message.MessageBuilder()
				.error(errorMsg)
				.build();
		
		return new ResponseEntity<>(message, status);
	}
	
	/**
	 * Builds the error list.
	 *
	 * @param errors the errors
	 * @return the validation error
	 */
	private static ValidationError buildErrorList(List<Reference> list) {
        ValidationError error = new ValidationError("Invalid Request");
        for (Reference fieldError : list) {
            error.addError(new com.gullyshops.model.message.Error(fieldError.getFieldName(), "Expected integer"));
        }
        return error;
    }
}