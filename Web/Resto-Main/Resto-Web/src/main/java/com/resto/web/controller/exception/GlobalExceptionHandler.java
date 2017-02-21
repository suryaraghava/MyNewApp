package com.resto.web.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.resto.exception.ElementNotFoundException;
import com.resto.exception.ServiceException;
import com.resto.model.message.Message;
import com.resto.model.message.ValidationError;
import com.resto.model.message.ValidationErrorBuilder;

/**
 * 
 * @author Munisekhar
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Message> handleException(Exception ex) throws Exception {
		String msg;
		HttpStatus status;
		if(ex instanceof ElementNotFoundException) {
			status = HttpStatus.NOT_FOUND;
			msg = ex.getMessage();
		} if(ex instanceof BadCredentialsException) {
			status = HttpStatus.UNAUTHORIZED;
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
}
