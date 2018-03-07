/**
 * 
 */
package org.proxima.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.proxima.entities.User;
import org.proxima.repository.UserRepository;
import org.proxima.rest.exception.CustomErrorType;
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

/**
 * @author maurizio
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers () {
		logger.debug("UserRegistrationRestController.getAllUsers - START");
		List<User> users = (List<User>)userRepository.findAll();
		if (users.isEmpty()) {
	        return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<List<User>> (users, HttpStatus.OK) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser (@PathVariable("id") final Long id) {
		logger.debug("UserRegistrationRestController.getUser - START");
		Optional<User> optionalObj = userRepository.findById(id);
		if (!optionalObj.isPresent()) {
            return new ResponseEntity<User>(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User> (optionalObj.get(), HttpStatus.OK) ;	
		}
		
	}
	
	@PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser 
	(@Valid @RequestBody final User u) {
		Optional<User> optionalUser = userRepository.findByEmail(u.getEmail());
		if (optionalUser.isPresent()) {
            return new ResponseEntity<User>(new CustomErrorType(
                    "Unable to create new user. A User with email "
                    + u.getEmail() + " already exist."),HttpStatus.CONFLICT);
		} else {
		    userRepository.save(u);
		    return new ResponseEntity<User> (u, HttpStatus.CREATED) ;
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") final Long id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
            return new ResponseEntity<User>(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
		} else {		
			userRepository.deleteById(id);
		    return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
//	@PutMapping(value="/updateEmail/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<User> updateUserEmail (
//			@PathVariable("id") final long id,
//			@RequestBody final String email) {
//		
//		Optional<User> optionalUser = userRepository.findById(id);
//		if (!optionalUser.isPresent()) {
//            return new ResponseEntity<User>(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
//		} else {
////			return new ResponseEntity<User> (user.get(), HttpStatus.OK) ;
//			User user = optionalUser.get();
//			user.setEmail(email);
//			userRepository.save(user);
//			return new ResponseEntity<User>(user, HttpStatus.OK);
//		}
//	}
	
//	@PutMapping(value="/updateRole/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<User> updateUserEmail (
//			@PathVariable("id") final long id,
//			@RequestBody final int role) {
//		
//		Optional<User> optionalUser = userRepository.findById(id);
//		if (!optionalUser.isPresent()) {
//            return new ResponseEntity<User>(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
//		} else {
//			User user = optionalUser.get();
//			user.setRole(role);
//			userRepository.save(user);
//			return new ResponseEntity<User>(user, HttpStatus.OK);
//		}
//	}
	
	/**
	 * Update user method.
	 * Doesn't update password(call updateUserPassword method)
	 * Doesn't update role(call updateUserRole method)
	 * @param id
	 * @param u
	 * @return
	 */
	@PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser (
			@PathVariable("id") final long id,
			@RequestBody final User u) {
		
		Optional<User> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
            return new ResponseEntity<User>(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
		} else {
			User user = optionalUser.get();
			user.setEmail(u.getEmail());
			user.setFirstname(u.getFirstname());
			user.setLastname(u.getLastname());
			user.setImgpath(u.getImgpath());
			user.setRegdate(u.getRegdate());			
			userRepository.save(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
}
