package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reply database table.
 * 
 */
@Entity
@NamedQuery(name="Reply.findAll", query="SELECT r FROM Reply r")
public class Reply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean ansa;

	private boolean ansb;

	private boolean ansc;

	private boolean ansd;

	private boolean anse;

	private boolean ansf;

	private boolean guessed;

	@Column(name="ID_QUESTION")
	private int idQuestion;

	@Column(name="ID_USER")
	private Long idUser;

	public Reply() {
		ansa = false;
		ansb = false;
		ansc = false;
		ansd = false;
		anse = false;
		ansf = false;
		guessed = false;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAnsa() {
		return this.ansa;
	}

	public void setAnsa(boolean ansa) {
		this.ansa = ansa;
	}

	public boolean getAnsb() {
		return this.ansb;
	}

	public void setAnsb(boolean ansb) {
		this.ansb = ansb;
	}

	public boolean getAnsc() {
		return this.ansc;
	}

	public void setAnsc(boolean ansc) {
		this.ansc = ansc;
	}

	public boolean getAnsd() {
		return this.ansd;
	}

	public void setAnsd(boolean ansd) {
		this.ansd = ansd;
	}

	public boolean getAnse() {
		return this.anse;
	}

	public void setAnse(boolean anse) {
		this.anse = anse;
	}

	public boolean getAnsf() {
		return this.ansf;
	}

	public void setAnsf(boolean ansf) {
		this.ansf = ansf;
	}

	public boolean getGuessed() {
		return this.guessed;
	}

	public void setGuessed(boolean guessed) {
		this.guessed = guessed;
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

}