package org.proxima.spendtime.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.db.DBManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.proxima.spendtime.entities.Spendtime;
import org.proxima.spendtime.entities.Spendtimetip;

public class HibernateDBManager extends DBManager {
	
	public static boolean check = false;
	final static Logger logger = Logger.getLogger(HibernateDBManager.class);
	
	//*********************** INSERT ********************
	public static void insertSt(int userID, String data, int ora, int tipoOre) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Spendtime spend = new Spendtime();
		Spendtimetip spt = new Spendtimetip();
		spt.getIdSpt();
		spend.setUserID(userID);
		spend.setData(data);
		spend.setOra(ora);
		spend.setTipoOre(tipoOre);
		session.save(spend);
		session.getTransaction().commit();
		 //Se l'inserimento va a buon fine CHECK diventa true
		check = true;
		session.close();
		System.out.println("sessione chiusa");
	}
	
	
	//************** Insert in SPENDTIMETIPS **********
	public static void insertStt(String label, String descrizione) {
		Session session = getSessionFactory().openSession();
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
	public static List<Spendtime>  getAllSpendTimes() {
		List<Spendtime> items=null;
		 
		 try {
			 
			 Session session = getSessionFactory().openSession();
			    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			    CriteriaQuery<Spendtime> criteriaQuery = criteriaBuilder.createQuery(Spendtime.class);
			    Root<Spendtime> root = criteriaQuery.from(Spendtime.class);
			    criteriaQuery.select(root);
			    Query<Spendtime> query = session.createQuery(criteriaQuery);
			    items = query.getResultList();
		
		    }catch (Exception e) {
			    logger.error(e.getStackTrace());
		}
		return items;
	}
	
//********************** SELECT from SpendTimeTip ******************	
	public static List<Spendtimetip> selectStt() {
		List<Spendtimetip> sp = null;
		
		try {
			
		Session session = getSessionFactory().openSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		    CriteriaQuery<Spendtimetip> criteriaQuery = criteriaBuilder.createQuery(Spendtimetip.class);
		    Root<Spendtimetip> root = criteriaQuery.from(Spendtimetip.class);
		    criteriaQuery.select(root);
		    Query<Spendtimetip> query = session.createQuery(criteriaQuery);
	    sp = query.getResultList();
		}catch (Exception e) {
		    logger.error(e.getStackTrace());
	}
	return sp;	
	}
	
		
//****************** SELECT id FROM Spendtime; ******************
	public static Spendtime selectById(int id) {
		Session session = getSessionFactory().openSession();
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
			 Session session = getSessionFactory().openSession();
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
		Session session = getSessionFactory().openSession();
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
		Session session = getSessionFactory().openSession();
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
			Session session = getSessionFactory().openSession();
			session.beginTransaction();

			Spendtime sp = new Spendtime();
			List<Spendtime> spend = getAllSpendTimes();
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
	
	
	
	
	//****************** DELETE ALL FROM Spendtime ***********************
	public static int deletAll() {
		Session session = getSessionFactory().openSession();
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
	
	 public static int deleteAllSpendTime() {
			
			
			int rows = 0;
			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			rows = session.createQuery("delete from org.proxima.spendtime.entities.SpendTime").executeUpdate();
			session.getTransaction().commit();
			
			session.close();
			return rows;

		}
	
	
	public static void main(String[] args) throws Exception {
//		SpendTime test = selectByUserIdAndDate(0, "20-02-2018");
		//System.out.println("test: " + test);
//		logger.debug("test: " + test);
//		insertSt(1, "01-02-2018", 6);
//		insertSt(1, "02-02-2018", 4);
//		insertSt(1, "03-02-2018", 8);
//		
//		insertSt(2, "01-02-2018", 3);
//		insertSt(2, "02-02-2018", 2);
//		insertSt(2, "03-02-2018", 4);
//		
//		insertSt(3, "01-02-2018", 3);
//		insertSt(3, "02-02-2018", 2);
		System.out.println("********************  LO FAI STO CAZZO DI INSERT **********");
		insertSt(3, "03-02-2018", 4,1);
		System.out.println("********************  LO HAI FATTO STO CAZZO DI INSERT **********");
//		List <SpendTime> a = getAllSpendTimes();
//		System.out.println("************** SELECT");
//		for (SpendTime o : a) {
//			System.out.println("ID: "+ o.getId() + " DATA: "+ o.getData()+ " ORA: " + o.getOra());
//		}
//		
//		List<SpendTimeTip> lista = selectStt();
//		logger.debug("************************SELECT STT *********");
//		for (SpendTimeTip spt : lista) {
//			logger.debug("ID: " + spt.getId()+ " " + "LABEL: " + spt.getLabel() + " " + "DESCRIZIONE: " + spt.getDescrizione());
//		}
		
//		List<Spendtime> join = selectJOIN();
//		logger.debug("******** JOIN **********");
//		for (Spendtime spj : join) {
//			logger.debug(spj.getSpendtimetip().toString());
//		}
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
