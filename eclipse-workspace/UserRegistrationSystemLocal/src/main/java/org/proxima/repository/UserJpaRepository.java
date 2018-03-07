package org.proxima.repository;

import java.util.Optional;

import org.proxima.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
	
	// Qui dentro metto solo i metodi di select che non mi da in automatico il repository
	Optional<User> findByFirstname(String firstname);
}
