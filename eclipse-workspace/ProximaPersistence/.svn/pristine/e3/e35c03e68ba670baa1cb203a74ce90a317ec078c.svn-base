package org.proxima.chat.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;


/**
 * The persistent class for the chatmessages database table.
 * 
 */
@Entity
@Table(name="chatmessages")
@NamedQuery(name="ChatMessages.findAll", query="SELECT c FROM ChatMessages c")
public class ChatMessages implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp sendtime;

	@NotEmpty(message = "error.textMessage.empty")        
    @Length(max = 500, message = "error.textMessage.length")
	private String textmessage;

	@NotEmpty(message = "error.username.empty")        
    @Length(max = 50, message = "error.username.length")
	@Column(name = "username")
	private String username;

	public ChatMessages() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * @return the sendtime
	 */
	public Timestamp getSendtime() {
		return sendtime;
	}

	/**
	 * @param sendtime the sendtime to set
	 */
	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

	/**
	 * @return the textmessage
	 */
	public String getTextmessage() {
		return textmessage;
	}

	/**
	 * @param textmessage the textmessage to set
	 */
	public void setTextmessage(String textmessage) {
		this.textmessage = textmessage;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}