package servletusers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.db.UserDBManager;
import org.db.UserLoginTokenDBManager;
import org.entities.User;
import org.entities.*;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ServletGeneratedToken")
public class ServletGeneratedToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGeneratedToken() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private final static Logger logger = Logger.getLogger(ServletGeneratedToken.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		try {
//		
//        response.setContentType("text/html;charset=UTF-8");
//		
//		String token = request.getParameter("token");
//		
//			logger.warn("TOKEN PRESO? " + token);		
//
////			logger.warn("TOKEN NEL DATABASE PRESO? " + UserLoginTokenDBManager.getUserLoginTokenByGeneratedToken());
//			
////			logger.warn("DATA DEL TOKEN? " + UserLoginTokenDBManager.getUserByToken(token).isTokenExpired());
//			
//			SimpleDateFormat today_date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//			
//			boolean expired = today_date.parse(UserLoginTokenDBManager.getUserLoginTokenByGeneratedToken(token).isTokenExpired()).before(new Date());
//			
//			logger.warn("SCADUTO? " + expired);
//			
//			if (token.equals(UserLoginTokenDBManager.getUserLoginTokenByGeneratedToken(token).getGeneratedToken())) {
//				
////				if (today_date.parse(UserLoginTokenDBManager.getUserLoginTokenByGeneratedToken(token).isTokenExpired()).before(new Date()) == false) {
//					
//
////        	HttpSession session = request.getSession();
////        	session.setAttribute("loggedUser", UserLoginTokenDBManager.getUserLoginTokenByGeneratedToken(token));
////            
////        	response.sendRedirect("ok.html");
////        	
////        } else {
////        	
////        	response.sendRedirect("expiredtoken.jsp");
////        	
////        } 
////		} 
////			if (!token.equals(UserLoginTokenDBManager.getUserLoginTokenByGeneratedToken(token).getGeneratedToken())){
////			
////			response.sendRedirect("ko.html");
////			
////		}
//			
//		} catch (Exception e) {
//			
//			
//			
//		}
        
	}

}
