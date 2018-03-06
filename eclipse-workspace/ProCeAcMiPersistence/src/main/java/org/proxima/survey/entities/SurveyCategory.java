package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the surveycategory database table.
 * 
 */
@Entity
@Table(name="surveycategory")
@NamedQuery(name="SurveyCategory.findAll", query="SELECT s FROM SurveyCategory s")
public class SurveyCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String label;

	//bi-directional many-to-one association to Surveytag
	@OneToMany(mappedBy="surveycategory")
	private List<SurveyTag> surveytags;

	public SurveyCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<SurveyTag> getSurveytags() {
		return this.surveytags;
	}

	public void setSurveytags(List<SurveyTag> surveytags) {
		this.surveytags = surveytags;
	}

	public SurveyTag addSurveytag(SurveyTag surveytag) {
		getSurveytags().add(surveytag);
		surveytag.setSurveycategory(this);

		return surveytag;
	}

	public SurveyTag removeSurveytag(SurveyTag surveytag) {
		getSurveytags().remove(surveytag);
		surveytag.setSurveycategory(null);

		return surveytag;
	}

}