package com.resto.web.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resto.model.message.Message;

/**
 * 
 * @author Munisekhar
 *
 */

@RestController
public class TestController {
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Message hello() {
		return new Message.MessageBuilder().message("Hello").build();
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/secure", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Message secure() {
		return new Message.MessageBuilder().message("Security passed").build();
	}
}
