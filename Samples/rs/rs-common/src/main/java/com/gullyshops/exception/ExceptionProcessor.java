package com.gullyshops.exception;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ElementKind;
import javax.validation.Path.Node;

import com.gullyshops.model.message.ValidationError;

/**
 * 
 * @author Munisekhar
 *
 */
public final class ExceptionProcessor {
	
	private ExceptionProcessor() {
		
	}
	
	public static ValidationError processConstraintViolationException(ConstraintViolationException ex) {
		
		ValidationError error = new ValidationError();
		
		Set<ConstraintViolation<?>>  set = ex.getConstraintViolations();
		Iterator<ConstraintViolation<?>> it = set.iterator();
		ConstraintViolation<?> cv;
		Iterator<Node> nodeIt;
		Node pathNode;
		while(it.hasNext()){
			cv = it.next();
			nodeIt = cv.getPropertyPath().iterator();
			while(nodeIt.hasNext()){
				pathNode = nodeIt.next();
				 // path is probably useful only for properties (fields)
		        if (pathNode != null && pathNode.getKind() == ElementKind.PROPERTY) {
		        	//error.addError(pathNode.getName() +"("+cv.getMessage()+")");
		        }else if(pathNode != null && pathNode.getKind() == ElementKind.PARAMETER) {
		        	//error.addError(cv.getMessage());
		        }
			}
		}
		
		return error;
	}
}
