package org.proxima.rest;

import java.util.List;

import org.proxima.entities.User;
import org.proxima.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {
	
	public static final Logger logger =
			LoggerFactory.getLogger(UserRegistrationRestController.class);
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userJpaRepository.findAll();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
}
