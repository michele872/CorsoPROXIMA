package org.proxima.chat.rest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.proxima.chat.entities.ChatMessages;
import org.proxima.chat.repository.ChatMessagesJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 

@RequestMapping("/api/chatMessages")
public class ChatMessagesRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(ChatMessagesRestController.class);

	@Autowired
    private ChatMessagesJpaRepository chatMessagesJpaRepository;
	
	// Method to get list of all chatMessages
	
	@GetMapping("/") 
	public ResponseEntity<List<ChatMessages>> listAllMessages() {        
		List<ChatMessages> chatMessages = chatMessagesJpaRepository.findAll();
		if (chatMessages.isEmpty()) {
			return new ResponseEntity<List<ChatMessages>>(HttpStatus.NO_CONTENT);		
		}
		return new ResponseEntity<List<ChatMessages>>(chatMessages, HttpStatus.OK); 
	}
	
	
	// Method to get list of all chatMessages by user
	
	@GetMapping("/{username}") 
	public ResponseEntity<List<ChatMessages>> getMessagesByUser(@PathVariable("username") final String username) {        
		List<ChatMessages> messages = chatMessagesJpaRepository.findByUsername(username);
		if (messages.isEmpty()) {
			
			return new ResponseEntity<List<ChatMessages>>(HttpStatus.NO_CONTENT);	
		}	
		return new ResponseEntity<List<ChatMessages>>(messages, HttpStatus.OK); 
	}
	
	// Method to get list of all chatMessages by sendtime
	
	@GetMapping("/bySendtime/{sendtime}") 
	public ResponseEntity<List<ChatMessages>> getMessagesBySendtime(@PathVariable("sendtime") final Timestamp sendtime) {
		List<ChatMessages> messages = chatMessagesJpaRepository.findBySendtimeGreaterThan(sendtime);
		if (messages.isEmpty()) {
			
			return new ResponseEntity<List<ChatMessages>>(HttpStatus.NO_CONTENT);	
		}	
		return new ResponseEntity<List<ChatMessages>>(messages, HttpStatus.OK); 
	}
	
	
	//Method to insert a message 

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<ChatMessages> insertMessage(@Valid @RequestBody final ChatMessages chatMessages) {
		logger.info("Creating ChatMessages : {}", chatMessages);
		
		chatMessagesJpaRepository.save(chatMessages);        
		return new ResponseEntity<ChatMessages>(chatMessages, HttpStatus.CREATED); 
	}
		
			
}
