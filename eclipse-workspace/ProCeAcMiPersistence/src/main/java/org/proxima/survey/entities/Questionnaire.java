package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;


/**
 * The persistent class for the questionnaire database table.
 * 
 */
@Entity
@NamedQuery(name="Questionnaire.findAll", query="SELECT q FROM Questionnaire q")
public class Questionnaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_QUESTIONNAIRE")
	private int idQuestionnaire;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endtime;

	@Column(name="ID_USER")
	private Long idUser;

	private String questions;

	private String replies;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar starttime;

	public Questionnaire() {
		questions = new String("[]");
		replies = new String("[]");
	}

	public int getIdQuestionnaire() {
		return this.idQuestionnaire;
	}

	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public Calendar getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Calendar endtime) {
		this.endtime = endtime;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getQuestions() {
		return this.questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getReplies() {
		return this.replies;
	}

	public void setReplies(String replies) {
		this.replies = replies;
	}

	public Calendar getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Calendar starttime) {
		this.starttime = starttime;
	}

}