package org.proxima.survey.db;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.proxima.survey.entities.Survey;
import org.proxima.survey.entities.SurveyCategory;
import org.proxima.survey.entities.SurveyTag;

public class SurveyTagFullInsertTest {
	private Survey survey;
	private SurveyCategory surveyCategory;
	
	@Before
	public void deleteAll() {
		SurveyTagDBManager.deleteAll();
		SurveyDBManager.deleteAll();
		survey = new Survey();
		survey.setQuestion("OLA1234");
		survey.setAnsa("Test");
		survey.setAnsb("Test");
		survey.setAnsc("Test");
		survey.setAnse("Test");
		survey.setAnsd("Test");
		survey.setAnsf("Test");
		survey.setCansb((byte)1);
		survey.setCansd((byte)1);
		survey.setCansf((byte)1);
		survey = SurveyDBManager.insert(survey);
		surveyCategory = SurveyCategoryDBManager.getSurveyCategory(1);
	}
	
	@Test
	/**
	 * 
	 */
	public void executeTestInsert() {
		SurveyTag st = new SurveyTag () ;		
		st.setSurvey(survey);
		st.setSurveycategory(surveyCategory);
		SurveyTagDBManager.insert(st);
		List<SurveyTag> surveyTags = SurveyTagDBManager.selectAll();
		assertTrue(surveyTags.size()>0);
		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            survey = SurveyDBManager.selectSurvey(1);
//    		SurveyCategory sc = SurveyCategoryDBManager.getSurveyCategory(1);
//            //s.getSurveycategories().add( sc );
//            //sc.getgetSurveys().add(s);
//            Surveytag st = new Surveytag() ;
//            st.setSurveycategory(sc);
//            st.setSurvey(survey);
//            session.save( st );
//            transaction.commit();
//        } catch( Exception e ) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//		if (s.getSurveycategories()!=null) {
//			s.getSurveycategories().add(sc);	
//		} else {
//			List<SurveyCategory> surveycategories = new ArrayList<SurveyCategory>() ;
//			surveycategories.add(sc);
//			s.setSurveycategories(surveycategories);
//		}
		
//		SurveyCategory sc = new SurveyCategory () ;
//		sc.setId(1);
//		sc.setLabel("mau");
//		sc.setDescription("bau");

//		s.getSurveycategories().add(sc);
//		SurveyDBManager.updateSurvey(survey);
//		SurveyCategoryDBManager.insertSurveyCategory(sc);
	}
	
//	public void executeSurveyInsert() {
//		survey = new Survey();
//		survey.setQuestion("OLA1234");
//		survey.setAnsa("Test");
//		survey.setAnsb("Test");
//		survey.setAnsc("Test");
//		survey.setAnse("Test");
//		survey.setAnsd("Test");
//		survey.setAnsf("Test");
//		survey.setCansb((byte)1);
//		survey.setCansd((byte)1);
//		survey.setCansf((byte)1);
//		
////		List<SurveyCategory> surveycategories = new ArrayList<SurveyCategory>();
//		SurveyCategory sc = new SurveyCategory () ;
////		sc.setId(1);
//		sc.setLabel("mau");
//		sc.setDescription("mau");
//		sc.setDescription("bau");
//		sc.setLabel("ciao");
//		surveycategories.add(sc);
//		s.setSurveycategories(surveycategories);
//		s.addSurveyCategory(sc);
//		s.getSurveycategories().add(sc);
//		SurveyDBManager.insertSurvey(survey);
//		SurveyCategoryDBManager.insertSurveyCategory(sc);
//	}
	
//	@After
//	public void deleteAllFromSurvey() {
//		SurveyDBManager.deleteAll();
//	}
	
//	@Test
//	public void testInsert() {
//		SurveyUtils.insertSurvey(s);
//		int id = s.getId();
//		Survey copy = copySurvey(s);
//		s = new Survey();
//		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		
//		session.beginTransaction();
//		s = session.get(Survey.class, id);
//		assertEquals(copy, s);
//		session.getTransaction().commit();
//		
//		session.beginTransaction();
//		session.delete(s);
//		session.getTransaction().commit();
//		
//		session.close();
//	}
	
//	private Survey copySurvey(Survey s) {
//		Survey survey = new Survey();
//		survey.setQuestion(s.getQuestion());
//		survey.setAnsa(s.getAnsa());
//		survey.setAnsc(s.getAnsc());
//		survey.setAnse(s.getAnse());
//		survey.setCansb(s.getCansb());
//		survey.setCansd(s.getCansd());
//		survey.setCansf(s.getCansf());
//		return survey;
//		
//	}
//	
//	@Test
//	public void testSelect() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(s);
//		session.getTransaction().commit();
//		
//		Survey result = SurveyUtils.selectSurvey(s.getId());
//		
//		session.beginTransaction();
//		session.delete(s);
//		session.getTransaction().commit();
//		session.close();
//		
//		assertEquals(s, result);
//	}
//	
//	@Test
//	public void testSelectAll() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(s);
//		session.getTransaction().commit();
//		
//		int size = SurveyUtils.selectAllSurveys().size();
//		
//		session.beginTransaction();
//		session.delete(s);
//		session.getTransaction().commit();
//		session.close();
//		
//		assertTrue(size > 0);
//	}
//	
//	@Test
//	public void testDelete() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		
//		session.beginTransaction();
//		session.save(s);
//		session.getTransaction().commit();
//		
//		session.beginTransaction();
//		int size1 = session.createQuery("FROM Survey").list().size();
//		session.getTransaction().commit();
//		
//		SurveyUtils.delete(s.getId());
//		
//		session.beginTransaction();
//		int size2 = session.createQuery("FROM Survey").list().size();
//		session.getTransaction().commit();
//		
//		assertTrue(size2 < size1);
//	}
//	
//	@Test
//	public void testUpdate() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		
//		session.beginTransaction();
//		session.save(s);
//		session.getTransaction().commit();
//		
//		Survey updated = copySurvey(s);
//		s.setQuestion("This is just a test for update");
//		
//		SurveyUtils.updateSurvey(s);
//		int id = s.getId();
//		s = new Survey();
//		
//		session.beginTransaction();
//		Survey s = session.get(Survey.class, id);
//		session.getTransaction().commit();
//		assertNotEquals(updated, s);
//		
//		session.beginTransaction();
//		session.delete(s);
//		session.getTransaction().commit();
//		session.close();
//		
//	}

}
