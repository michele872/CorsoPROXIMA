package org.proxima.survey.db;

import java.util.List;

import org.apache.log4j.Logger;
import org.db.DBManager;
import org.hibernate.Session;
import org.proxima.survey.entities.Survey;

public class SurveyDBManager extends DBManager {
	
	final static Logger logger = Logger.getLogger(SurveyDBManager.class);
	
	public static void main(String args[]) {
		Survey s = new Survey();
		s.setQuestion("ciao a tutti!");
		s.setAnsa("e a te");
		s.setCansa((byte)0);
		/*insertSurvey(s);
		System.out.println("ciaone 2222 " + s.getId());
		
		s.setQuestion("ciaone a te!");
		updateSurvey(s);*/
		List<Survey> results = selectAll();
		for (Survey survey : results) {
			System.out.println(survey.getId());
		}
	}
	
	

	
	/**
	 * Public method to insert a survey on Database
	 * 
	 * @param s
	 * @return survey just inserted(with valid id) 
	 */
	public static Survey insert(Survey survey) {
		logger.debug("SurveyDBManager.insert - START");
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(survey);
//		session.persist(s);
		session.getTransaction().commit();
		session.close();
		logger.debug("SurveyDBManager.insert - DEBUG - survey: " + survey.getId());
		return survey ;
//		return s.getId();
	}
	
	/**
	 * Public method to update a survey on database
	 * @param s
	 */
	public static Survey update(Survey s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
//		session.update(s);
		session.save(s);
		session.getTransaction().commit();
		session.close();
		return s;
	}
	
	/**
	 * Public method to select a survey, given a particular id
	 * @param id
	 * @return
	 */
	public static Survey selectSurvey(int id) {
		Session session = getSessionFactory().openSession();
//		session.beginTransaction();
		Survey selection = session.get(Survey.class, ""+id);
//		closeSession(session);
		session.close();
		return selection;
	}
	
	/**
	 * Public method to select all the surveys present in the Database
	 * @return
	 */
	public static List<Survey> selectAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Survey> surveysRes = session.createQuery("FROM Survey").list();
		/*List<?> surveys = session.createQuery("FROM Survey").list();
		for (Iterator<?> iterator = surveys.iterator(); iterator.hasNext();) {
			surveysRes.add((Survey) iterator.next());
		}*/
		session.getTransaction().commit();
		return surveysRes;
	}
	
	/**
	 * Public method to delete a particular survey, given a particular id
	 * @param id
	 */
	public static void delete(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Survey survey = session.get(Survey.class, id);
		session.delete(survey);
		session.getTransaction().commit();
	}
	
    public static void deleteAll() {
		
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.createQuery("delete from org.proxima.survey.entities.Survey").executeUpdate();
		session.getTransaction().commit();
		
		session.close();

	}

}
