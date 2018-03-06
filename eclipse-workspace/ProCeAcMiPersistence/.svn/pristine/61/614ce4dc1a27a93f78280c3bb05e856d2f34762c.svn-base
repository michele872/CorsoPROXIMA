/**
 * 
 */
package org.proxima.survey.db;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.db.DBManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.proxima.survey.entities.Survey;
import org.proxima.survey.entities.SurveyCategory;

/**
 * @author maurizio
 *
 */
public class SurveyCategoryDBManager extends DBManager {

	final static Logger logger = Logger.getLogger(SurveyCategoryDBManager.class);	

    
    public static List<SurveyCategory>  getAllSurveyCategories() {
		List <SurveyCategory> items=null;
		 
		 try {
			 
			 Session session = getSessionFactory().openSession();
			 CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			 CriteriaQuery<SurveyCategory> criteriaQuery = criteriaBuilder.createQuery(SurveyCategory.class);
			 Root<SurveyCategory> root = criteriaQuery.from(SurveyCategory.class);
			 criteriaQuery.select(root);
			 Query<SurveyCategory> query = session.createQuery(criteriaQuery);
			 items = query.getResultList();
		
		}catch (Exception e) {
			    logger.error(e.getStackTrace());
		}
		return items;
	}
    
    /**
	 * Public method to insert a SurveyCategory on Database
	 * @param s
	 */
	public static void insertSurveyCategory(SurveyCategory s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
//		session.save(s);
		session.persist(s);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Public method to select a survey, given a particular id
	 * @param id
	 * @return
	 */
	public static SurveyCategory getSurveyCategory(int id) {
		Session session = getSessionFactory().openSession();
		SurveyCategory selection = session.get(SurveyCategory.class, id);
		session.close();
		return selection;
	}

}
