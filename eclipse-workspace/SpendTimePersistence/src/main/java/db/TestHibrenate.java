package db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.helpers.QuietWriter;
import org.entities.Spendtime;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import javax.persistence.criteria.*;
import org.hibernate.query.Query;

public class TestHibrenate {
	
	static Session session;
	static Transaction transaction;
	static Spendtime spend = new Spendtime();
	
	
	//*********************** INSERT ********************
	public static void insert(int userID, String data, int ora) {
		session = DbManagerHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		spend.setUserID(userID);
		spend.setData(data);
		spend.setOra(ora);
		session.save(spend);
		session.getTransaction().commit();
		session.close();
		System.out.println("sessione chiusa");
	}
	
	//******************SELECT * FROM Spendtime;******************
	public static List<Spendtime> select() {
		session = DbManagerHibernate.getSessionFactory().openSession();
		transaction  = session.beginTransaction();
		List<Spendtime> sp = null;
		try {
			sp = session.createQuery("FROM Spendtime").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			session.disconnect();
//			session.close();
		}
		return sp;
		
	}
	
	
//****************** SELECT id FROM Spendtime; ******************
	public static SpendTime selectById(int id) {
		session = DbManagerHibernate.getSessionFactory().openSession();
//	    transaction = session.beginTransaction();
	    
		SpendTime spend = null;
	    
//	    try {
//	         CriteriaBuilder builder = session.getCriteriaBuilder();
//	         CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
//	         Root<Spendtime> root = query.from(Spendtime.class);
//	         //query.select(SpendTime.class, root.get("id"));
//	         query.select(SpendTime.class, id);
//	         Query<Integer> q=session.createQuery(query);
//	         spend = q.getResultList();
	         
	         spend = session.get(SpendTime.class, id);
	         
//	         for (Integer i : spend) {
//	            System.out.println(i);
//	         }
//	         transaction.commit();
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	         if (transaction != null) {
//	            transaction.rollback();
//	         }
//	      }
		return spend;
	}
	
	public static Spendtime selectByUserIdAndDate(int userId, String date) {
		Spendtime stToReturn = null ;
		try {			 
			 Session session = DbManagerHibernate.getSessionFactory().openSession();
			 CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			 CriteriaQuery<Spendtime> criteriaQuery = criteriaBuilder.createQuery(Spendtime.class);
			 Root<Spendtime> root = criteriaQuery.from(Spendtime.class);
//			 criteriaQuery.select(root);			 
			 List criteriaList = new ArrayList();

//			 Predicate userIdEqualPredicate = criteriaBuilder.equal(root.get("userID"), userId) ;
//			 criteriaList.add(userIdEqualPredicate);
//			 Predicate dateEqualPredicate = criteriaBuilder.equal(root.get("data"), date) ;
//			 criteriaList.add(dateEqualPredicate);
			 //criteriaQuery.where(criteriaBuilder.and((Predicate[])criteriaList.toArray()));
//			 criteriaQuery.where(criteriaBuilder.and(userIdEqualPredicate));
//			 criteriaQuery.where(criteriaBuilder.and(criteriaList.toArray(new Predicate[0])));
			 
			 Predicate userIdAndDateFilter = criteriaBuilder.and(
					 criteriaBuilder.equal( root.get("userID"), userId ),
					 criteriaBuilder.equal( root.get("data"), date )
					);
			 
			 criteriaQuery.where( criteriaBuilder.and( userIdAndDateFilter) );
			 
			 Query<Spendtime> query = session.createQuery(criteriaQuery);
			 stToReturn = query.getSingleResult();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	//logger.error(e.getStackTrace());
	    }
		return stToReturn;
	}
	
	
	//****************** SELECT * FROM Spendtime WHERE ID = 1; ******************
	public static List<Spendtime> selectByUserID(int userID) {
		session = DbManagerHibernate.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	    
	    List<Spendtime> byId = null;
	    
	    try {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Spendtime> query = builder.createQuery(Spendtime.class);
	         Root<Spendtime> root = query.from(Spendtime.class);
	         query.select(root).where(builder.equal(root.get("userID"), userID));
	         Query<Spendtime> q=session.createQuery(query);
	         byId = q.getResultList();
	         System.out.println("**** SIZE:   " + byId.size());
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
		return byId;
	}
	
	
	//******************* SELECT ORA WHERE UserId = .. , data = .... ********************
	public static int selectOra(int userID, String data) {
		session = DbManagerHibernate.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	    
	    List<Spendtime> all = null;
	    int ora = 0;
	    try {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Spendtime> query = builder.createQuery(Spendtime.class);
	         Root<Spendtime> root = query.from(Spendtime.class);
	         query.select(root).where(builder.equal(root.get("userID"), userID)); //, builder.equal(root.get("data"), data));	         
	         Query<Spendtime> q=session.createQuery(query);	         
	         all = q.getResultList();
	         System.out.println("**** SIZE:   " + all.size());
	         transaction.commit();
	         for (Spendtime sp : all) {
				ora = sp.getOra();
			}
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
		return ora;
	}
	
	
	//****************** UpdateOra ***********************
	public static void updateOra(String data, int ora) {
			session = DbManagerHibernate.getSessionFactory().openSession();
			session.beginTransaction();
			select();
			spend.setOra(ora);
			session.update(spend);
			session.getTransaction().commit();
			session.close();
			System.out.println("sessione chiusa");
	}
	
	public static void deletAll() {
		session = DbManagerHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		System.out.println(		select().get(0));
		session.delete(select().get(0));
		
//		Query q1 = session.createQuery ("DELETE FROM Spendtime");
//        q1.executeUpdate();
		session.getTransaction().commit();
		session.disconnect();
		session.close();
		System.out.println("TABELLA ELIMINATA");
	}
	
	
	public static void main(String[] args) throws Exception {
		Spendtime test = selectByUserIdAndDate(1, "20-02-2018");
		System.out.println("test: " + test);
//		logger.debug();
//		insert(1, "01-02-2018", 6);
//		insert(1, "02-02-2018", 4);
//		insert(1, "03-02-2018", 8);
//		
//		insert(2, "01-02-2018", 3);
//		insert(2, "02-02-2018", 2);
//		insert(2, "03-02-2018", 4);
//		
//		insert(3, "01-02-2018", 3);
//		insert(3, "02-02-2018", 2);
//		insert(3, "03-02-2018", 4);
		
//		List <Spendtime> a = select();
//		System.out.println("************** SELECT");
//		for (Spendtime o : a) {
//			System.out.println("ID: "+ o.getId() + " DATA: "+ o.getData()+ " ORA: " + o.getOra());
//		}
//		
//		List<Integer> id = selectId();
//		System.out.println("***************** SELECT ID");
//		for (Integer sp : id) {
//			System.out.println(sp.toString());
//		}
//		
//		List<Spendtime>id2 = selectByUserID(1);
//		System.out.println("******************* selectByUserID");
//		for (Spendtime sp : id2) {
//			System.out.println(sp.getData() + " " + sp.getOra());
//		}
//		
//		
//		//List<Spendtime>id3 = selectOra(1, "1-02-2018");
//		int b = selectOra(1, "1-02-2018");
//		System.out.println("**********************selectByUserIDbyData");
//		System.out.println(b);
//		
//		deletAll();
	}
	
	
}
