package db;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.entities.Spendtime;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.*;
import org.hibernate.query.Query;

public class TestHibrenate {
	
	static Session session;
	static Transaction transaction;
	
	public static void insert(int userID, String data, int ora) {
		session = DbManagerHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		Spendtime sp = new Spendtime();
		sp.setUserID(userID);
		sp.setData(data);
		sp.setOra(ora);
		session.save(sp);
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
			session.close();
		}
		return sp;
		
	}
	
	
//****************** SELECT id FROM Spendtime; ******************
	public static List<Integer> selectId() {
		session = DbManagerHibernate.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	    
	    List<Integer> spend = null;
	    
	    try {
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
	         Root<Spendtime> root = query.from(Spendtime.class);
	         query.select(root.get("id"));
	         Query<Integer> q=session.createQuery(query);
	         spend = q.getResultList();
//	         for (Integer i : spend) {
//	            System.out.println(i);
//	         }
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
		return spend;
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
//	         for (Spendtime i : byId) {
//	            System.out.println(i.getData());
//	            System.out.println(i.getOra());
//	         }
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
		return byId;
	}
	
	
	public static void deletAll() {
		
	}
	
	
	public static void main(String[] args) throws Exception {
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
		
		List <Spendtime> a = select();
		for (Spendtime o : a) {
			System.out.println("ID: "+ o.getId() + " DATA: "+ o.getData()+ " ORA: " + o.getOra());
		}
		
		List<Integer> id = selectId();
		for (Integer sp : id) {
			System.out.println(sp.toString());
		}
		
		List<Spendtime>id2 = selectByUserID(1);
		for (Spendtime sp : id2) {
			System.out.println(sp.getData() + " " + sp.getOra());
		}
	}
	
	
	
	
	
//*************************************  METODO VECCHIO *****************************************************
//	private EntityManagerFactory emf;
//	private EntityManager em;
//	
//	public TestHibrenate(String persistenceUnitName) {
//		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
//		em = emf.createEntityManager();
//	}
//	
//	public void insert(Object o) {
//		em.getTransaction().begin();;
//		em.persist(o);
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//	public static void main(String[] args) throws Exception {
//	Spendtime sp = new Spendtime();
//	sp.setId(1);
//	sp.setData("20-02-2018");
//	sp.setOra(8);
//	TestHibrenate th = new TestHibrenate("SpendTimePersistence");
//	th.insert(sp);
//}
	
	
	
//	************************ METODO CHE UTILIZZA IL FILE XML *********************************
//	private SessionFactory sessionFactory;
//	
//	protected void setUp() throws Exception {
//		//Otteniamo una session Factory configurata tramite l'xml
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//	}
//	
//	protected void shutDown() throws Exception {
//		if(sessionFactory != null) {
//			sessionFactory.close();
//		}
//	}
//	
//	public void test() {
//		Spendtime sp = new Spendtime();
//		sp.setId(1);
//		sp.setData("20-02-2018");
//		sp.setOra(8);
//		//Inserisco gli elementi di spendTime nel db
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(sp);
//		session.getTransaction().commit();
//		session.close();
//	}
//	

	
}
