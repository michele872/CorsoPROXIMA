/**
 * 
 */
package org.proxima.login;

import org.apache.log4j.Logger;
import org.db.UserDBManager;
import org.entities.User;

import servletusers.LoginServlet;

/**
 * @author maurizio
 *
 */
public class LoginManager {
	
	private final static Logger logger = Logger.getLogger(LoginManager.class);

	public final static int USER_OK = 0 ;
	public final static int EMAIL_NOT_EXISTS = 1 ;
	public final static int PASSWORD_NOT_VALID = 2 ;
	
	public static int validateUser (String email, String password) {

		logger.debug("EMAIL" + email);

		System.out.println("PASSWORD" + password);

		User u = UserDBManager.getUserByEmail(email);

		logger.debug("user form db: " + u);

		if (u==null) {
			return EMAIL_NOT_EXISTS ;
		} else {
			String userEmail = u.getEmail();

			System.out.println("UTENTE" + userEmail);

			String userPwd = u.getPassword();

			System.out.println("PASSWORD" + userPwd);
			if (userPwd.equals(password)) {
                return USER_OK ;				
			} else {
				return PASSWORD_NOT_VALID ;
			}
		}
	}
	
}
