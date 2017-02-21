package com.resto.api.ws.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resto.api.ws.GenericService;
import com.resto.exception.ServiceException;
import com.resto.model.User;
import com.resto.model.message.Message;
import com.resto.service.user.UserManager;

/**
 * 
 * @author Munisekhar
 *
 */
@RestController
@RequestMapping("/user")
public class UserService extends GenericService {
	
	@Autowired
	UserManager userManager;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> getAllUsers() throws ServiceException {
		List<User> list = userManager.findAll();
		if(list != null) {
			return toSucess(list);
		}
		return to500();
	}

}
