/**
 * 
 */
package org.db;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.bean.User;
import org.db.UserDBManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author maurizio
 *
 */
public class UserDBManagerTest {
	@Test
	public void test1() {
		System.out.println("#########");
		System.out.println("TEST SELECT");
		System.out.println("#########");
		int size = UserDBManager.getUsers().size() ;
		System.out.println("@Test --> size: " + size);
        assertTrue( size>0 );
	}
	
	@Test
	public void test2() {
		System.out.println("#########");
		System.out.println("TEST SELECT BY EMAIL");
		System.out.println("#########");
		User returnUser = UserDBManager.getUserByEmail ("prova1@prova.it"); 
		System.out.println("@Test --> user by email: " + returnUser);
        assertTrue( returnUser!=null );
	}
	
//	@Test
//	public void test3_isEmailOnDB_true() {
//		System.out.println("#########");
//		System.out.println("TEST IS EMAIL ON DB");
//		System.out.println("#########");
//		boolean val = UserDBManager.isEmailOnDB("prova1@prova.it"); 
//		System.out.println("@Test --> is email on DB: " + val);
//        assertTrue( val );
//	}
//	
//	@Test
//	public void test3_isEmailOnDB_false() {
//		System.out.println("#########");
//		System.out.println("TEST IS EMAIL ON DB");
//		System.out.println("#########");
//		boolean val = UserDBManager.isEmailOnDB("email_Che_Non_Ce@prova.it"); 
//		System.out.println("@Test --> is email on DB: " + val);
//        assertFalse( val );
//	}
	
//	@Test
//	public void test4_updatePasswordByEmail() {
//		System.out.println("#########");
//		System.out.println("TEST UPDATE EMAIL");
//		System.out.println("#########");
//		
//		User u = UserDBManager.getUserByEmail("prova1@prova.it");
//		System.out.println("@Test --> password before: " + u.getPassword());
//
//		boolean val = UserDBManager.updatePasswordByEmail("prova1@prova.it", "ciaociaociao");
//		System.out.println("@Test --> update email: " + val);
//		
//		u = UserDBManager.getUserByEmail("prova1@prova.it");
//		System.out.println("@Test --> password after: " + u.getPassword());
//
//		val &= u.getPassword().equals("ciaociaociao");
//		assertTrue( val );
//	}
	
//	@Test
//	public void test5_insertUser() {
//		
//		User user = new User();
//		user.setId(1L);
//		user.setEmail("daniele@ciao.it");
//		user.setPassword("ciao");
//		user.setFirstname("dani");
//		user.setLastname("griz");
//		user.setBorndate("2018-01-28");
//		user.setRegdate("2018-01-25");
//		user.setRole(10);
//		Boolean result = false;
//		try {
//			result = UserDBManager.insertUser(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("@Before --> inserted rows number: " + result);
//		System.out.println("#########");
//		System.out.println("TEST INSERT USER REGISRATION");
//		System.out.println("#########");
//        assertTrue(result);
//	}
	
	private static int insertedNumber = 0;

	@Before
	public void insert() {
		insertedNumber = UserDBManager.insertNewUser("prova1@prova.it", "password1234", 10);
		System.out.println("@Before --> inserted rows number: " + insertedNumber);
	}

	@After
	public void cleanUsersDB () {
		int rows = new UserDBManager().deleteAll();
		System.out.println("Database cleaned.... deleted rows number: " + rows);
	}
	
	
}
