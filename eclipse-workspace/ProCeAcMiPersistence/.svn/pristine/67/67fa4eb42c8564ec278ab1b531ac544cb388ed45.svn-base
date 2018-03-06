package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the surveytag database table.
 * 
 */
@Entity
@Table(name="surveytag")
@NamedQuery(name="SurveyTag.findAll", query="SELECT s FROM SurveyTag s")
public class SurveyTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="survey_tag_map_id")
	private int surveyTagMapId;

	//bi-directional many-to-one association to Survey
	@ManyToOne
	private Survey survey;

	//bi-directional many-to-one association to SurveyCategory
	@ManyToOne
	private SurveyCategory surveycategory;

	public SurveyTag() {
	}

	public int getSurveyTagMapId() {
		return this.surveyTagMapId;
	}

	public void setSurveyTagMapId(int surveyTagMapId) {
		this.surveyTagMapId = surveyTagMapId;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public SurveyCategory getSurveycategory() {
		return this.surveycategory;
	}

	public void setSurveycategory(SurveyCategory surveycategory) {
		this.surveycategory = surveycategory;
	}

}