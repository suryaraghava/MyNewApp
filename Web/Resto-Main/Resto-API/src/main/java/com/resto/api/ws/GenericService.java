package com.resto.api.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.resto.model.message.Message;

/**
 * 
 * @author Munisekhar
 *
 */
@RestController
@PropertySource("classpath:message.properties")
public abstract class GenericService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	
	private static final String INTERNAL_ERROR = "Internal Server Error";
	private static final String UNAUTHORIZED = "Unauthorized access";
	private static final String UNPROCESSABLE = "Couldn't process the request. Please try again later.";
	
	@Autowired
	protected Environment environment;
	
	protected ResponseEntity<Message> toSucess(int identifier, String msg) {
		
		Message message = new Message.MessageBuilder()
				.identifier(identifier)
				.detailMessage(msg)
				.build();
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(message);
	}
	
	protected ResponseEntity<Message> to500() {
		
		Message message = new Message.MessageBuilder()
				.error(INTERNAL_ERROR)
				.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
	}
	
	protected ResponseEntity<Message> toFailedDependency() {
		
		Message message = new Message.MessageBuilder()
				.error(UNPROCESSABLE)
				.build();
		return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(message);
	}
	
	protected ResponseEntity<Message> to401(String msg) {
		Message message = new Message.MessageBuilder()
				.error(msg)
				.build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
	}
	
	protected ResponseEntity<Message> to401() {
		Message message = new Message.MessageBuilder()
				.error(UNAUTHORIZED)
				.build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
	}
	
	protected ResponseEntity<Message> to404(String msg) {
		Message message = new Message.MessageBuilder()
				.error(msg)
				.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	protected ResponseEntity<Message> toSucess(boolean status) {
		Message message = new Message.MessageBuilder()
				.status(status)
				.build();
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(message);
	}
	
	protected ResponseEntity<Message> toSucess(Object object) {
		Message message = new Message.MessageBuilder()
				.data(object)
				.build();
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(message);
	}
	
	/*protected ResponseEntity<Message> toSucess(Object object, int userId) {
		Message message = new Message.MessageBuilder()
				.data(object)
				.userId(userId)
				.build();
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(message);
	}*/
	
	
	/**
	 * Gets the message for identifier.
	 *
	 * @param clazz the clazz
	 * @return the message for identifier
	 */
	protected String getMessageForIdentifier(Class<?> clazz) {
		return environment.getProperty("identifier").replace("*", clazz.getSimpleName());
	}
	
	/*protected int getCustomerIdFromToken(String authorization) {
		int customerId = 0;
		if(authorization != null){
			String auth[] = authorization.split(" ");
			Jwt jwtToken = JwtHelper.decode(auth[1]);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = null;
			try {
				node = mapper.readValue(jwtToken.getClaims(), JsonNode.class);
			} catch (IOException ex) {
				logger.error("Exe while parsing token:", ex);
			}
			if(node != null) {
				customerId = node.get("customerId").asInt();
			}
		}
		return customerId;
	}*/
}
