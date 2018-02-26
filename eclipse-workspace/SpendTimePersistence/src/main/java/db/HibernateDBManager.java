package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.entities.Spendtime;
import org.entities.Spendtimetip;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import utility.CurrentDate;

public class HibernateDBManager {
	
	public static boolean check = false;
	final static Logger logger = Logger.getLogger(HibernateDBManager.class);
	
	//*********************** INSERT ********************
	public static void insertSt(int userID, String data, int ora) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		Spendtime spend = new Spendtime();
		spend.setUserID(userID);
		spend.setData(data);
		spend.setOra(ora);
		session.save(spend);
		session.getTransaction().commit();
		 //Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		session.close();
		System.out.println("sessione chiusa");
	}
	
	
	//************** Insert in SPENDTIMETIPS **********
	public static void insertStt(String label, String descrizione) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		Spendtimetip spt = new Spendtimetip();
		spt.setLabel(label);
		spt.setDescrizione(descrizione);
		session.save(spt);
		session.getTransaction().commit();
		 //Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		session.close();
		System.out.println("sessione chiusa");
	}
	
	
	//******************SELECT * FROM Spendtime;******************
	public static List<Spendtime> selectSp() {
		Session session = HibernateConnection.getSessionFactory().openSession();
		Transaction transaction  = session.beginTransaction();
		List<Spendtime> sp = null;
		try {
			sp = session.createQuery("FROM Spendtime").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return sp;		
	}
	
//********************** SELECT from SpendTimeTip ******************	
	public static List<Spendtime> selectStt() {
		Session session = HibernateConnection.getSessionFactory().openSession();
		Transaction transaction  = session.beginTransaction();
		List<Spendtime> sp = null;
		try {
			sp = session.createQuery("FROM Spendtimetip").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return sp;		
	}
	
	
//****************** SELECT id FROM Spendtime; ******************
	public static Spendtime selectById(int id) {
		Session session = HibernateConnection.getSessionFactory().openSession();
//	    transaction = session.beginTransaction();
	    
		Spendtime spend = null;
	    
//	    try {
//	         CriteriaBuilder builder = session.getCriteriaBuilder();
//	         CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
//	         Root<Spendtime> root = query.from(Spendtime.class);
//	         //query.select(SpendTime.class, root.get("id"));
//	         query.select(SpendTime.class, id);
//	         Query<Integer> q=session.createQuery(query);
//	         spend = q.getResultList();
	         
	         spend = session.get(Spendtime.class, id);
	         
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
			 Session session = HibernateConnection.getSessionFactory().openSession();
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
		Session session = HibernateConnection.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	    
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
		Session session = HibernateConnection.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	    
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
	public static void updateOra(int userID, String data, int ora) {
			Session session = HibernateConnection.getSessionFactory().openSession();
			session.beginTransaction();

			Spendtime sp = new Spendtime();
			List<Spendtime> spend = selectSp();
			for (Spendtime s : spend) {
				logger.debug("DATA "+s.getData().equals(data));
				logger.debug(s.getUserID() == userID);
				logger.debug(s.getUserID() == userID && s.getData().equals(data));
				if(s.getUserID() == userID && s.getData().equals(data)) {
					logger.debug("DENTRO IF");
					sp = s;
				}
			}
			logger.debug("FUORI FOR");

			sp.setOra(ora);
			session.update(sp);
			session.getTransaction().commit();
			session.close();
			System.out.println("sessione chiusa");
	}
	
	
	public static HashMap<String, Integer> getPrepopolatedValue () throws Exception {
		List<Spendtime> dip = selectSp();
		HashMap<String, Integer> valori = new HashMap<String, Integer>();

		int sizeDip = dip.size();
		int giorno = Integer.parseInt(CurrentDate.giornoCorrente());
		if( sizeDip < giorno ) {
			for(int i=sizeDip; i< giorno; i++ ) {
				if(!dip.isEmpty())
					insertSt(dip.get(0).getUserID(), (i+1)+"-"+CurrentDate.dataCorrente(), 0);
			}
		}
		dip = selectSp();
		sizeDip = dip.size();
		
		for(int i=0; i<sizeDip; i++) {
			valori.put(dip.get(i).getId()+"_"+dip.get(i).getData(), dip.get(i).getOra());
			logger.debug("chiave: " + dip.get(i).getId()+"_"+dip.get(i).getData() + " valore: " + valori.get(dip.get(i).getId()+dip.get(i).getData()));
		}
		logger.debug("Questa è la size dell'ArrayList: " + sizeDip);
		logger.debug("Size dell'HashMap: " + valori.size());
		return valori;
	} 
	
	
	public static int deletAll() {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		
		int rows = 0;
//		System.out.println(		select().get(0));
//		session.delete(select().get(0));
		
		Query q1 = session.createQuery ("DELETE FROM Spendtime");
        rows = q1.executeUpdate();
		session.getTransaction().commit();
		session.disconnect();
		session.close();
		System.out.println("TABELLA ELIMINATA");
		return rows;
	}
	
	
	public static void main(String[] args) throws Exception {
		Spendtime test = selectByUserIdAndDate(1, "20-02-2018");
		//System.out.println("test: " + test);
		logger.debug("test: " + test);
		insertSt(1, "01-02-2018", 6);
		insertSt(1, "02-02-2018", 4);
		insertSt(1, "03-02-2018", 8);
		
		insertSt(2, "01-02-2018", 3);
		insertSt(2, "02-02-2018", 2);
		insertSt(2, "03-02-2018", 4);
		
		insertSt(3, "01-02-2018", 3);
		insertSt(3, "02-02-2018", 2);
		insertSt(3, "03-02-2018", 4);
//		
		List <Spendtime> a = selectSp();
		System.out.println("************** SELECT");
		for (Spendtime o : a) {
			System.out.println("ID: "+ o.getId() + " DATA: "+ o.getData()+ " ORA: " + o.getOra());
		}
//		
////		List<Integer> id = selectId();
////		System.out.println("***************** SELECT ID");
////		for (Integer sp : id) {
////			System.out.println(sp.toString());
////		}
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
		
		//updateOra(1,"01-02-2018", 10);
		
//		deletAll();
	}
	
	
}