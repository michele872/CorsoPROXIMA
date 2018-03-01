package org.proxima.survey.db;

import java.util.List;

import org.hibernate.Session;
import org.proxima.survey.entities.Questionnaire;
import org.proxima.survey.entities.Reply;

public class QuestionnairePersistence {

	public static void main(String args[]) {
		System.out.println(getIDQuestionnaireFromUser(72));
	}
	
	/**
	 * Utility method to retrieve the Hibernate session object 
	 * @return
	 */
	private static Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	/**
	 * Utility method to close the Hibernate session
	 * @param session
	 */
	private static void closeSession(Session session) {
		session.close();
	}
	
	/**
	 * Public method to insert a reply on Database
	 * @param reply
	 */
	public static int insertReply(Reply reply) {
		Session session = getSession();
		session.beginTransaction();
		session.save(reply);
		session.getTransaction().commit();
		closeSession(session);
		return reply.getId();
	}
	
	/**
	 * Public method to insert a questionnaire on Database
	 * @param questionnaire
	 */
	public static int insertQuestionnaire(Questionnaire questionnaire) {
		Session session = getSession();
		session.beginTransaction();
		session.save(questionnaire);
		session.getTransaction().commit();
		closeSession(session);
		return questionnaire.getIdQuestionnaire();
	}
	
	/**
	 * Public method to select a reply, given a particular id
	 * @param id
	 * @return
	 */
	public static Reply selectReply(int id) {
		Session session = getSession();
		session.beginTransaction();
		Reply selection = session.get(Reply.class, id);
		closeSession(session);
		return selection;
	}
	
	/**
	 * Public method to select a questionnaire, given a particular id
	 * @param id
	 * @return
	 */
	public static Questionnaire selectQuestionnaire(int id) {
		Session session = getSession();
		session.beginTransaction();
		Questionnaire selection = session.get(Questionnaire.class, id);
		closeSession(session);
		return selection;
	}
	
	public static int getIDQuestionnaireFromUser(int userID) {
		Session session = getSession();
		session.beginTransaction();
		int result = 0;
		System.out.println("ciao");
		List<Questionnaire> questionnaires = (List<Questionnaire>) session.createQuery("FROM Questionnaire WHERE ID_USER=" + userID + " AND STARTTIME = NULL").list();
		for (Questionnaire q : questionnaires) {
			result = q.getIdQuestionnaire();
		}
		return result;
	}
	
	/**
	 * Public method to update a questionnaire already present in DB
	 * @param questionnaire
	 */
	public static void updateQuestionnaire(Questionnaire questionnaire) {
		
		Session session = getSession();
		session.beginTransaction();
		session.merge(questionnaire);
		session.getTransaction().commit();
		closeSession(session);
	}
	
}
