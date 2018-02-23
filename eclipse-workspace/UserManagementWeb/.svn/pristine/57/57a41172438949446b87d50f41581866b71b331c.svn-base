package servletusers;

import java.sql.*;

public class ValidateToken
 {
     public static boolean checkUser(String email) 
     {
      boolean st = false;
      try{

         Class.forName("com.mysql.jdbc.Driver");

         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/utenti","root","");
         PreparedStatement ps =con.prepareStatement
                             ("select * from users where email=?");
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
     }
     
 }