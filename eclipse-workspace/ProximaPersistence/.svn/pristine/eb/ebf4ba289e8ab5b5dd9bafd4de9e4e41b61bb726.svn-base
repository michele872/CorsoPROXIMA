package org.proxima.chat.repository;

import java.sql.Timestamp;
import java.util.List;

import org.proxima.chat.entities.ChatMessages;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ChatMessagesJpaRepository extends JpaRepository<ChatMessages, Integer> {

	List<ChatMessages> findByUsername(String username);

	List<ChatMessages> findBySendtime(Timestamp sendtime);
	
	List<ChatMessages> findBySendtimeGreaterThan(Timestamp sendtime);

}
