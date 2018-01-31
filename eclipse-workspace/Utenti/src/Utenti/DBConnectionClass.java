package Utenti;

import java.sql.SQLException;

public class DBConnectionClass {
	
	private String email;
	private String password;
	
	private boolean login;
	public DBConnectionClass (String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public boolean login() throws ClassNotFoundException, SQLException {
		ConnessDB cdb = new ConnessDB();
		cdb.connetti();
		if (email != null && password != null)
			login = true;
		return login;
	}
}
