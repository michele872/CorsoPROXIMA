package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the surveyreplies database table.
 * 
 */
@Entity
@Table(name="surveyreplies")
@NamedQuery(name="SurveyReply.findAll", query="SELECT s FROM SurveyReply s")
public class SurveyReply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String answers;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endtime;

	private String pdffilename;

	@Temporal(TemporalType.TIMESTAMP)
	private Date starttime;

	@Column(name="survey_id")
	private java.math.BigInteger surveyId;

	@Column(name="user_id")
	private java.math.BigInteger userId;

	public SurveyReply() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswers() {
		return this.answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getPdffilename() {
		return this.pdffilename;
	}

	public void setPdffilename(String pdffilename) {
		this.pdffilename = pdffilename;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public java.math.BigInteger getSurveyId() {
		return this.surveyId;
	}

	public void setSurveyId(java.math.BigInteger surveyId) {
		this.surveyId = surveyId;
	}

	public java.math.BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigInteger userId) {
		this.userId = userId;
	}

}