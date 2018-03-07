package org.proxima.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.proxima.entities.User;
import org.proxima.error.CustomErrorType;
import org.proxima.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {
	
	public static final Logger logger =
			LoggerFactory.getLogger(UserRegistrationRestController.class);
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	
	//Mi fa fare la select di tutto da user
	@GetMapping("/")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userJpaRepository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//Faccio una INSERT 
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(
			@Valid @RequestBody final User user) {
		userJpaRepository.save(user);
		logger.info("Creating User : {}", user);
		if (userJpaRepository.findByFirstname(user.getFirstname()) != null) {
			return new ResponseEntity<User>(new CustomErrorType(
			"Unable to create new user. A User with name "
			+ user.getFirstname() + " already exist."),HttpStatus.CONFLICT);
		}
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	//Faccio una SELECT by ID
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") final Integer id) {
		Optional<User> user = userJpaRepository.findById(id);
		if(!user.isPresent()) {
			return new ResponseEntity<User>(
					new CustomErrorType("User with id "
					+ id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
	//UPDATE di uno USER
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> updateUser(
				@PathVariable("id") final Integer id, @RequestBody User user) {
		Optional<User> currentUser = userJpaRepository.findById(id);
		if (!currentUser.isPresent()) {
			return new ResponseEntity<User>(
			new CustomErrorType("Unable to upate. User with id "
			+ id + " not found."), HttpStatus.NOT_FOUND);
		} else {
			User u = currentUser.get();
			// update currentUser object data with user object data
			u.setFirstname(user.getFirstname());
			u.setLastname(user.getLastname());
			u.setEmail(user.getEmail());
			// save currentUser obejct
			userJpaRepository.save(u);
			//return ResponseEntity object
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	//DELETE di UNO USER
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") final Integer id) {
	Optional<User> user = userJpaRepository.findById(id);
	if (!user.isPresent()) {
		return new ResponseEntity<User>(
		new CustomErrorType("Unable to delete. User with id "
		+ id + " not found."), HttpStatus.NOT_FOUND);
	}
	userJpaRepository.deleteById(id);
	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
