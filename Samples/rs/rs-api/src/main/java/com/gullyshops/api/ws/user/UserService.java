package com.gullyshops.api.ws.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gullyshops.api.ws.GenericService;
import com.gullyshops.exception.ServiceException;
import com.gullyshops.model.User;
import com.gullyshops.model.message.Message;
import com.gullyshops.service.user.UserManager;

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
