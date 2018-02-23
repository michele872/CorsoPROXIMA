package servletusers;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import org.bean.UserLoginToken;
import org.db.UserLoginTokenDBManager;

public class ValidateGenerationTK
 {
     public static boolean checkToken(String token) 
     {
      boolean st = false;
      try{

         Class.forName("com.mysql.jdbc.Driver");

         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/utenti","root","");
         PreparedStatement ps =con.prepareStatement
                             ("select * from userlogintoken where generated_token=?");
         ps.setString(1, token);
         ResultSet rs = ps.executeQuery();
         st = rs.next();
         
         if (rs != null) {
        	 
        	UserLoginToken u = UserLoginTokenDBManager.getUserByToken(token);
     		UserLoginTokenDBManager.setTokenDataUser(u.getEmail());
     		
     		String s = u.isTokenExpired();
     		
     	if (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(s).before(new Date()) != true) {
     		
     		return true;
     		
     	} else {
     		
     		return false;
     		
     	}
     		
     		
        	 
         }
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
     }
     
 }
